package tzw.sust.file.dao;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageInfo;
import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.DeleteObjectResult;
import com.obs.services.model.HttpMethodEnum;
import com.obs.services.model.ObsObject;
import com.obs.services.model.PutObjectResult;
import com.obs.services.model.TemporarySignatureRequest;
import com.obs.services.model.TemporarySignatureResponse;
import com.obs.services.model.fs.NewFolderRequest;
import com.obs.services.model.fs.ObsFSFolder;
import com.obs.services.model.fs.RenameRequest;
import com.obs.services.model.fs.RenameResult;

import tzw.sust.entitys.FileInfo;
/**
 * @author TianZhengwei
 * @date 2020/04/16 21:00
 * @description
 */
@Configuration
public class IObsDao {
//	@Value("${ak}")
//	private String ak;
//	@Value("${sk}")
//	private String sk;
//	@Value("${endpoint}")
//	private String endPoint;
//	@Value("${bucketName}")
//	private String bucketName;
	private static final String endPoint = "obs.cn-north-4.myhuaweicloud.com";

    private static final String ak = "0MEVV6HAZKRVPLUGEA0B";

    private static final String sk = "F83zWB5RBNEGcifUDJLUHLKWJbctzd8H4P29SKUB";

    private static final String bucketName = "obs-skd-10";

	// https://obssdk.obs.cn-north-1.myhuaweicloud.com/apidoc/cn/java/index.html
	// 创建客户端对象
	public ObsClient getObsClient() {
		return new ObsClient(ak, sk, endPoint);
	}

	// 上传文件--对象名，文件流
	public String upLoadFile(String objectKey, InputStream stream) {
		ObsClient obsClient = getObsClient();
		try {
			PutObjectResult putObject = getObsClient().putObject(bucketName, objectKey, stream);
			String key = putObject.getObjectKey();
			obsClient.close();
			return key;
		} catch (ObsException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 下载文件
	public ObsObject downLoadFile(String objectKey) {
		ObsObject object = getObsClient().getObject(bucketName, objectKey);
		return object;
	}

	// 删除文件
	public boolean removeFile(String objectKey) {
		DeleteObjectResult result = getObsClient().deleteObject(bucketName, objectKey);
		return result.isDeleteMarker();
	}

	// 创建文件夹
	public ObsFSFolder createFolder(String folderName) {
		ObsFSFolder newFolder = getObsClient().newFolder(new NewFolderRequest(bucketName, folderName));
		return newFolder;
	}

	// 获取文件对象
	public ObsObject getFile(String objectKey) {
		// 不带参数的列举所有
		try {
			ObsClient obsClient = getObsClient();
			ObsObject object = obsClient.getObject(bucketName, objectKey);
			obsClient.close();
			return object;
		} catch (ObsException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 预览---授权访问
    // 预览只支持流式文件
    public String previewFile(String objectKey) throws IOException {
        ObsClient obsClient = getObsClient();

        TemporarySignatureRequest request = new
                TemporarySignatureRequest(HttpMethodEnum.GET, 300);
        request.setBucketName(bucketName);
        request.setObjectKey(objectKey);
        TemporarySignatureResponse response = obsClient.createTemporarySignature(request);
        obsClient.close();
        return response.getSignedUrl();
    }

	// 文件重命名
	public RenameResult renameFile(String objectKey, String newFileName) throws IOException {
		ObsClient obsClient = getObsClient();
		RenameRequest renameRequest = new RenameRequest(bucketName, objectKey, newFileName);
		RenameResult result = obsClient.renameFile(renameRequest);
		obsClient.close();
		return result;
	}

}
