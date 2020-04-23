package tzw.sust.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.obs.services.model.ObjectMetadata;
import com.obs.services.model.ObsObject;

import tzw.sust.entitys.FileInfo;

/**
 * @author TianZhengwei
 * @date 2020/04/16 19:34
 * @description
 */
public class ObsObjectUtil {
	public FileInfo formatObsObject(ObsObject object) {
		ObjectMetadata metadata = object.getMetadata();
		Long contentLength = object.getMetadata().getContentLength();
		FileInfo info = new FileInfo();
		info.setFileid(new AutoGenerateFileid().getFileid_auto());
		if (contentLength < 1024) {
			info.setFilesize(contentLength + " b");
		}
		if (contentLength > 1024) {
			contentLength /= 1024; // kb
			info.setFilesize((double) contentLength + " kb");
		}
		if (contentLength > 1024) {
			contentLength /= 1024;// M
			info.setFilesize((double) contentLength + " M");
		}
		if (contentLength > 1024) {
			contentLength /= 1024;// G
			info.setFilesize((double) contentLength + " G");
		}
		info.setFilename(object.getObjectKey());
		Date lastModified = metadata.getLastModified();
		info.setUploadtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastModified));
		return info;
	}
}
