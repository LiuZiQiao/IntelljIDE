package com.cjx.ObsTest;

/**
 * @author chenjiaxin
 * @version 1.0
 * @date 2020/4/8 0:17
 */
public class TestBucket {
    public static void main(String[] args) throws Exception {
        BucketOperation bucket=new BucketOperation();
        //测试创建桶方法
//	    String bucketName = JOptionPane.showInputDialog("请输入您要创建的桶名称");
//		bucket.createBucket(bucketName);
//		System.out.println("完成");

        //测试获取桶列表方法
//		bucket.listBucket();

        //测试删除桶方法
//	    String bucketName = JOptionPane.showInputDialog("请输入您要创建的桶名称");
//		bucket.removeBucket(bucketName);

        //判断桶是否存在
//	    String bucketName = JOptionPane.showInputDialog("请输入您要创建的桶名称");
//		bucket.isExists(bucketName);

        //测试获取桶元数据
//		String bucketName = JOptionPane.showInputDialog("请输入您要创建的桶名称");
//		bucket.getBucketMetadata(bucketName);

        //测试直接设置桶访问策略
//		String bucketName = JOptionPane.showInputDialog("请输入您要创建的桶名称");
//		bucket.accessControll(bucketName);

        //上传文件
        //bucket.uploadFile();

        //下载文件
//		bucket.downloadFile();
//		System.exit(0);

        //预览文件
        bucket.view();
    }

}
