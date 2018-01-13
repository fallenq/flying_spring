package flying.tool.file.nozzle;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface UploadToolNozzle {
	public Resource localUpload(MultipartFile file);
	public Resource getUploadResource();
	public String getUploadUrl();
}
