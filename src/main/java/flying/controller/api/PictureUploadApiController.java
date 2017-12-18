package flying.controller.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import flying.config.PictureUploadProperties;


@RestController
@RequestMapping("/api/picture")
public class PictureUploadApiController {
	
	@Autowired
	private PictureUploadProperties uploadProperties;	

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String onPicUpload(MultipartFile file) throws IOException {
		if (file.isEmpty() || !isImage(file)) {
			return "Incorrect file.";
		}
		copyFileToPictures(file);
		return "OK";
	}
	
	private Resource copyFileToPictures(MultipartFile file) throws IOException {
		String fileExtension = getFileExtension(file.getOriginalFilename());
		File tempFile = File.createTempFile("pic", fileExtension, uploadProperties.getUploadPath().getFile());
		InputStream in = file.getInputStream();
		OutputStream out = new FileOutputStream(tempFile);
		IOUtils.copy(in, out);
		return new FileSystemResource(tempFile);
	}
	
	private boolean isImage(MultipartFile file) {
		return file.getContentType().startsWith("image");
	}
	
	private String getFileExtension(String name) {
		return name.substring(name.lastIndexOf("."));
	}
}
