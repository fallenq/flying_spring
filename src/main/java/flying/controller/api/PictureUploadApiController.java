package flying.controller.api;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import flying.tool.file.PictureUploadTool;


@RestController
@RequestMapping("/api/picture")
public class PictureUploadApiController {
	@Autowired
	private PictureUploadTool pictureUploadTool;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String onPicUpload(MultipartFile file) throws IOException {
		if (file.isEmpty() || !pictureUploadTool.isImage(file)) {
			return "Incorrect file.";
		}
		Resource resource = pictureUploadTool.localUpload(file);
		if (resource != null) {
			System.out.println(pictureUploadTool.getOutFileName(resource.getURL().getPath()));
		}
		return "OK";
	}
	
}
