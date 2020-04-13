package org.ObsTest.demojava;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/7 21:31
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.obs.services.ObsClient;
import com.obs.services.ObsConfiguration;
import com.obs.services.exception.ObsException;
import com.obs.services.model.ObsObject;
import com.obs.services.model.PutObjectRequest;

// 创建文件夹的用法
public class CreateFolder {
    private static final String endPoint = "obs.cn-north-4.myhuaweicloud.com";

    private static final String ak = "JLPO5IWXTDAMGF8KZIZR";

    private static final String sk = "H3VXEhbBEtOQl1VanetEuO0YB3drMI1VSTJlSgB3";

    private static ObsClient obsClient;

    private static String bucketName = "chenjiaxin1119";

    public static void main(String[] args) throws IOException {

        ObsConfiguration config = new ObsConfiguration();
        config.setSocketTimeout(30000);
        config.setConnectionTimeout(10000);
        config.setEndPoint(endPoint);
        try {

            obsClient = new ObsClient(ak, sk, config);
            System.out.println("Create a new bucket for demo\n");
            obsClient.createBucket(bucketName);

            final String keySuffixWithSlash1 = "MyObjectKey1/";
            obsClient.putObject(bucketName, keySuffixWithSlash1, new ByteArrayInputStream(new byte[0]));
            System.out.println("Creating an empty folder " + keySuffixWithSlash1 + "\n");

            ObsObject object = obsClient.getObject(bucketName, keySuffixWithSlash1, null);
            System.out.println("Size of the empty folder '" + object.getObjectKey() + "' is "
                    + object.getMetadata().getContentLength());
            object.getObjectContent().close();

            final String keySuffixWithSlash2 = "MyObjectKey2/";
            PutObjectRequest request = new PutObjectRequest();
            request.setBucketName(bucketName);
            request.setObjectKey(keySuffixWithSlash2);
            request.setInput(new ByteArrayInputStream(new byte[0]));
            obsClient.putObject(request);
            System.out.println("Creating an empty folder " + keySuffixWithSlash2 + "\n");

            object = obsClient.getObject(bucketName, keySuffixWithSlash2, null);
            System.out.println("Size of the empty folder '" + object.getObjectKey() + "' is "
                    + object.getMetadata().getContentLength());
            object.getObjectContent().close();

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
}
