package org.ObsTest.demojava;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/7 21:33
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import com.obs.services.ObsClient;
import com.obs.services.ObsConfiguration;
import com.obs.services.exception.ObsException;
import com.obs.services.model.ObsObject;


// 对象下载的用法
public class Downloads {
    private static final String endPoint = "obs.cn-north-4.myhuaweicloud.com";

    private static final String ak = "JLPO5IWXTDAMGF8KZIZR";

    private static final String sk = "H3VXEhbBEtOQl1VanetEuO0YB3drMI1VSTJlSgB3";

    private static ObsClient obsClient;

    private static String bucketName = "my-obs-bucket-demo";

    private static String objectKey = "my-obs-object-key-demo";

    private static String localFilePath = "/temp/" + objectKey;

    public static void main(String[] args) throws IOException {
        ObsConfiguration config = new ObsConfiguration();
        config.setSocketTimeout(30000);
        config.setConnectionTimeout(10000);
        config.setEndPoint(endPoint);
        try {

            obsClient = new ObsClient(ak, sk, config);

            System.out.println("Create a new bucket for demo\n");
            obsClient.createBucket(bucketName);

            System.out.println("Uploading a new object to OBS from a file\n");
            obsClient.putObject(bucketName, objectKey, createSampleFile());

            System.out.println("Downloading an object\n");


            simpleDownload();

            File localFile = new File(localFilePath);
            if (!localFile.getParentFile().exists()) {
                localFile.getParentFile().mkdirs();
            }

            System.out.println("Downloading an object to file:" + localFilePath + "\n");

            downloadToLocalFile();

            System.out.println("Deleting object  " + objectKey + "\n");
            obsClient.deleteObject(bucketName, objectKey, null);

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

    private static void downloadToLocalFile() throws ObsException, IOException {
        ObsObject obsObject = obsClient.getObject(bucketName, objectKey, null);
        ReadableByteChannel rchannel = Channels.newChannel(obsObject.getObjectContent());

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        WritableByteChannel wchannel = Channels.newChannel(new FileOutputStream(new File(localFilePath)));

        while (rchannel.read(buffer) != -1) {
            buffer.flip();
            wchannel.write(buffer);
            buffer.clear();
        }
        rchannel.close();
        wchannel.close();
    }

    private static void simpleDownload() throws ObsException, IOException {
        ObsObject obsObject = obsClient.getObject(bucketName, objectKey, null);
        displayTextInputStream(obsObject.getObjectContent());
    }

    private static void displayTextInputStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            System.out.println("\t" + line);
        }
        System.out.println();

        reader.close();
    }

    private static File createSampleFile() throws IOException {
        File file = File.createTempFile("obs-java-sdk-", ".txt");
        file.deleteOnExit();
        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.write("0123456789011234567890\n");
        writer.close();
        return file;
    }

}
