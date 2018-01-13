package flying.tool.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import flying.config.PictureUploadProperties;
import flying.tool.TimeTool;
import flying.tool.file.nozzle.UploadToolNozzle;

@Repository
public class PictureUploadTool extends FileTool implements UploadToolNozzle {
	
	@Autowired
	private PictureUploadProperties uploadProperties;
	
	@Override
	public Resource localUpload(MultipartFile file) {
		String fileExtension = getFileExtension(file.getOriginalFilename());
		String dirname = getUploadUrl() + "/" + TimeTool.currentDate("yyyyMMdd");
		if (createOrValidateDir(dirname)) {
			try {
				Resource resource = getUploadResource().createRelative(getResourceRelative(dirname));
				File tempFile = File.createTempFile("pic", fileExtension, resource.getFile());
				InputStream in = file.getInputStream();
				OutputStream out = new FileOutputStream(tempFile);
				IOUtils.copy(in, out);
				return new FileSystemResource(tempFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Resource getUploadResource() {
		return uploadProperties.getUploadPath();
	}

	@Override
	public String getUploadUrl() {
		try {
			return getUploadResource().getURL().getPath();
		} catch (IOException e) {
			return "";
		}
	}

}
