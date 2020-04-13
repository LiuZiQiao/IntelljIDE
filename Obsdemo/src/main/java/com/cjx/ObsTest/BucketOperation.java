package com.cjx.ObsTest;

/**
 * @author chenjiaxin
 * @version 1.0
 * @date 2020/4/8 0:18
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.AccessControlList;
import com.obs.services.model.BucketMetadataInfoRequest;
import com.obs.services.model.BucketMetadataInfoResult;
import com.obs.services.model.HeaderResponse;
import com.obs.services.model.ListBucketsRequest;
import com.obs.services.model.ObsBucket;
import com.obs.services.model.ObsObject;
import com.obs.services.model.StorageClassEnum;
public class BucketOperation {
    private static final String endPoint = "obs.cn-north-4.myhuaweicloud.com";

    private static final String ak = "ZEO8LNJFSEHNRO31ZIIT";

    private static final String sk = "vYpwYEXzCoCDTWRhMYiGo46DT65v1U5iidmwf45P";

    private static final String bucketName = null;

    private static final String bucketLocation = "cn-north-4";

    // 创建obsClient实例
    public ObsClient getInstance() {
        return new ObsClient(ak, sk, endPoint);
    }

    // 创建桶
    public void createBucket(String bucketName) throws IOException {
        ObsClient obsClient = getInstance();
        ObsBucket obsBucket = new ObsBucket();
        obsBucket.setBucketName(bucketName);
        // 设置桶访问权限为公共读，默认是私有读写
        obsBucket.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ);
        // 设置桶的存储类型为归档存储
        obsBucket.setBucketStorageClass(StorageClassEnum.COLD);
        // 设置桶区域位置
        obsBucket.setLocation(bucketLocation);
        // 创建桶
        try {
            // 创建桶成功
            HeaderResponse response = obsClient.createBucket(obsBucket);
            System.out.println(response.getRequestId());
        } catch (ObsException e) {
            // 创建桶失败
            System.out.println("HTTP Code: " + e.getResponseCode());
            System.out.println("Error Code:" + e.getErrorCode());
            System.out.println("Error Message: " + e.getErrorMessage());
            System.out.println("Request ID:" + e.getErrorRequestId());
            System.out.println("Host ID:" + e.getErrorHostId());
        }
        obsClient.close();
    }

    //获取桶列表
    public void listBucket() throws IOException {
        ObsClient obsClient = getInstance();
        // 列举桶
        ListBucketsRequest request = new ListBucketsRequest();
        request.setQueryLocation(true);
        List<ObsBucket> buckets = obsClient.listBuckets(request);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        for (ObsBucket bucket : buckets) {
            System.out.println("桶名称:" + bucket.getBucketName() + "\t" + "创建时间:" + sdf.format(bucket.getCreationDate())
                    + "\t区域:" + bucket.getLocation());
        }
        obsClient.close();
    }


    //删除桶
    public void removeBucket(String bucketName) throws IOException {
        // 创建ObsClient实例
        ObsClient obsClient = getInstance();
        boolean exists = obsClient.headBucket(bucketName);
        if (exists) {
            // 删除桶
            obsClient.deleteBucket(bucketName);
            obsClient.close();
        } else {
            System.out.println("没有您要删除的桶");
        }
    }

    //判断桶是否存在
    public void isExists(String bucketName) {
        ObsClient obsClient = getInstance();
        boolean exists = obsClient.headBucket(bucketName);
        if (exists) {
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }

    }

    //获取桶元数据
    public void getBucketMetadata(String bucketName)
            throws ObsException {
        ObsClient obsClient = getInstance();
        System.out.println("Getting bucket metadata\n");
        BucketMetadataInfoRequest request = new BucketMetadataInfoRequest(bucketName);
        request.setOrigin("http://www.a.com");
        request.getRequestHeaders().add("Authorization");
        BucketMetadataInfoResult result = obsClient.getBucketMetadata(request);
        System.out.println("StorageClass:" + result.getBucketStorageClass());
        System.out.println("\tAllowedOrigins " + result.getAllowOrigin());
        System.out.println("\tAllowedMethods " + result.getAllowMethods());
        System.out.println("\tAllowedHeaders " + result.getAllowHeaders());
        System.out.println("\tExposeHeaders " + result.getExposeHeaders());
        System.out.println("\tMaxAgeSeconds " + result.getMaxAge() + "\n");

    }

    //上传文件
    public void uploadFile() throws IOException {
        Util objectUtil = new Util();
        File file = new File("C:/Users/zhangjiagang/Desktop/test.txt");
        FileInputStream fis = new FileInputStream(file);
        Integer statusCode = objectUtil.uploadFile(fis, "test.txt");

        // 查询所有
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<ObsObject> list = objectUtil.getAllFileInfo();
        for (ObsObject obsObject : list) {
            System.out
                    .println("文件名：" + obsObject.getObjectKey() + "\t文件大小：" + obsObject.getMetadata().getContentLength()
                            + "B\t修改时间:" + sdf.format(obsObject.getMetadata().getLastModified()));
        }
    }

    //下载文件
    public void downloadFile() throws Exception {
        Util objectUtil = new Util();
        ObsObject object = objectUtil.getFile("test.txt");
        if (object != null) {
            InputStream is = object.getObjectContent();
            FileOutputStream fos = new FileOutputStream(new File("C:/Users/zhangjiagang/Desktop/test223.txt"));
            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            System.out.println("Success");
            fos.close();
            is.close();
        } else {
            System.out.println("No file!!!");
        }
    }

    //预览文件
    public void view() throws IOException {
        Util objectUtil = new Util();
        String url = objectUtil.preview("test.txt");
        System.out.println(url);
    }
}
