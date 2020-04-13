package com.cjx.ObsTest;

/**
 * @author chenjiaxin
 * @version 1.0
 * @date 2020/4/8 0:19
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.obs.services.ObsClient;
import com.obs.services.model.DeleteObjectResult;
import com.obs.services.model.HttpMethodEnum;
import com.obs.services.model.ObjectListing;
import com.obs.services.model.ObsObject;
import com.obs.services.model.PutObjectResult;
import com.obs.services.model.TemporarySignatureRequest;
import com.obs.services.model.TemporarySignatureResponse;

public class Util {
    private static final String endPoint = "obs.cn-north-4.myhuaweicloud.com";

    private static final String ak = "ZEO8LNJFSEHNRO31ZIIT";

    private static final String sk = "vYpwYEXzCoCDTWRhMYiGo46DT65v1U5iidmwf45P";

    private static final String bucketName = "obs-skd-06";

    public ObsClient getInstance() {
        return new ObsClient(ak, sk, endPoint);
    }

    public Integer uploadFile(InputStream is, String objectKey) throws IOException {
        ObsClient obsClient = getInstance();
        boolean flag = obsClient.doesObjectExist(bucketName, objectKey);
        PutObjectResult result = null;
        if (flag) {
            return 0;
        } else {
            result = obsClient.putObject(bucketName, objectKey, is);
        }
        obsClient.close();
        return result.getStatusCode();
    }

    public List<ObsObject> getAllFileInfo() throws IOException {
        ObsClient obsClient = getInstance();
        ObjectListing objectList = obsClient.listObjects(bucketName);
        List<ObsObject> list = objectList.getObjects();
        obsClient.close();
        return list;
    }

    public boolean removeFile(String objectKey) throws IOException {
        ObsClient obsClient = getInstance();
        boolean flag = obsClient.doesObjectExist(bucketName, objectKey);
        DeleteObjectResult result = null;
        if (flag) {
            result = obsClient.deleteObject(bucketName, objectKey);
        }
        obsClient.close();
        return result.isDeleteMarker();
    }

    public ObsObject getFile(String objectKey) {
        ObsClient obsClient = getInstance();
        boolean flag = obsClient.doesObjectExist(bucketName, objectKey);
        if (flag) {
            ObsObject object = obsClient.getObject(bucketName, objectKey);
            return object;
        }
        return null;
    }

    public String preview(String objectKey) throws IOException {
        ObsClient obsClient = getInstance();
        TemporarySignatureRequest request = new TemporarySignatureRequest(HttpMethodEnum.GET, 500);
        request.setBucketName(bucketName);
        request.setObjectKey(objectKey);
        TemporarySignatureResponse response = obsClient.createTemporarySignature(request);
        obsClient.close();
        return response.getSignedUrl();
    }
}
