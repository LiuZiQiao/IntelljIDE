package org.ObsTest.demojava;
/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/7 22:04
 */

import com.obs.services.ObsClient;
import com.obs.services.ObsConfiguration;
import com.obs.services.exception.ObsException;
import com.obs.services.model.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ListObjectsInFolder {
    private static final String endPoint = "obs.cn-north-4.myhuaweicloud.com";

    private static final String ak = "JLPO5IWXTDAMGF8KZIZR";

    private static final String sk = "H3VXEhbBEtOQl1VanetEuO0YB3drMI1VSTJlSgB3";

    private static ObsClient obsClient;

    private static String bucketName = "chenjiaxin1119";

    public static void main(String[] args) throws UnsupportedEncodingException {
        ObsConfiguration config = new ObsConfiguration();
        config.setSocketTimeout(30000);
        config.setConnectionTimeout(10000);
        config.setEndPoint(endPoint);
        try {

            obsClient = new ObsClient(ak, sk, config);


            obsClient.createBucket(bucketName);

            final String content = "Hello OBS";
            final String keyPrefix = "MyObjectKey";
            final String folderPrefix = "src";
            final String subFolderPrefix = "test";
            ObjectListing objectListing = null;
            ListObjectsRequest listObjectsRequest = null;
            List<String> keys = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                String key = folderPrefix + i + "/";
                obsClient.putObject(bucketName, key, new ByteArrayInputStream(new byte[0]), null);
                keys.add(key);

                for (int j = 0; j < 3; j++) {
                    String subKey = key + subFolderPrefix + j + "/";
                    obsClient.putObject(bucketName, subKey, new ByteArrayInputStream(new byte[0]));
                    keys.add(subKey);
                }
            }


            objectListing = obsClient.listObjects(bucketName);
            for (ObsObject object : objectListing.getObjects()) {
                for (int i = 0; i < 2; i++) {
                    String objectKey = object.getObjectKey() + keyPrefix + i;
                    obsClient.putObject(bucketName, objectKey, new ByteArrayInputStream(content.getBytes("UTF-8")),
                            null);
                    keys.add(objectKey);
                }
            }

            obsClient.putObject(bucketName, keyPrefix + 0, new ByteArrayInputStream(content.getBytes("UTF-8")), null);
            obsClient.putObject(bucketName, keyPrefix + 1, new ByteArrayInputStream(content.getBytes("UTF-8")), null);
            keys.add(keyPrefix + 0);
            keys.add(keyPrefix + 1);
            System.out.println("Put " + keys.size() + " objects completed.");
            System.out.println();

            System.out.println("List all objects in folder src0/ \n");
            listObjectsRequest = new ListObjectsRequest(bucketName);
            listObjectsRequest.setPrefix("src0/");
            objectListing = obsClient.listObjects(listObjectsRequest);
            for (ObsObject object : objectListing.getObjects()) {
                System.out.println("\t" + object.getObjectKey() + " etag[" + object.getMetadata().getEtag() + "]");
            }
            System.out.println();

            System.out.println("List all objects in folder src0/test0/ \n");
            listObjectsRequest = new ListObjectsRequest(bucketName);
            listObjectsRequest.setPrefix("src0/test0/");
            objectListing = obsClient.listObjects(listObjectsRequest);
            for (ObsObject object : objectListing.getObjects()) {
                System.out.println("\t" + object.getObjectKey() + " etag[" + object.getMetadata().getEtag() + "]");
            }
            System.out.println();


            System.out.println("List all objects group by folder \n");
            listObjectsRequest = new ListObjectsRequest(bucketName);
            listObjectsRequest.setDelimiter("/");

            objectListing = obsClient.listObjects(listObjectsRequest);
            System.out.println("Root path:");
            for (ObsObject object : objectListing.getObjects()) {
                System.out.println("\t" + object.getObjectKey() + " etag[" + object.getMetadata().getEtag() + "]");
            }
            listObjectsByPrefix(listObjectsRequest, objectListing);

            System.out.println();

            DeleteObjectsRequest request = new DeleteObjectsRequest();
            request.setBucketName(bucketName);
            request.setQuiet(false);
            KeyAndVersion[] kvs = new KeyAndVersion[keys.size()];
            int index = 0;
            for (String key : keys) {
                kvs[index++] = new KeyAndVersion(key);
            }

            request.setKeyAndVersions(kvs);

            System.out.println("Delete results:");

            DeleteObjectsResult deleteObjectsResult = obsClient.deleteObjects(request);
            for (DeleteObjectsResult.DeleteObjectResult object : deleteObjectsResult.getDeletedObjectResults()) {
                System.out.println("\t" + object);
            }

        } catch (ObsException e) {
            System.out.println("Response Code: " + e.getResponseCode());
            System.out.println("Error Message: " + e.getErrorMessage());
            System.out.println("Error Code:       " + e.getErrorCode());
            System.out.println("Request ID:      " + e.getErrorRequestId());
            System.out.println("Host ID:           " + e.getErrorHostId());
        } finally {
            if (obsClient != null) {
                try {
                    obsClient.close();
                } catch (IOException e) {
                }
            }
        }

    }

    private static void listObjectsByPrefix(ListObjectsRequest listObjectsRequest, ObjectListing objectListing)
            throws ObsException {
        for (String prefix : objectListing.getCommonPrefixes()) {
            System.out.println("Folder " + prefix + ":");
            listObjectsRequest.setPrefix(prefix);
            objectListing = obsClient.listObjects(listObjectsRequest);
            for (ObsObject object : objectListing.getObjects()) {
                System.out.println("\t" + object.getObjectKey() + " etag[" + object.getMetadata().getEtag() + "]");
            }
            listObjectsByPrefix(listObjectsRequest, objectListing);
        }
    }
}
