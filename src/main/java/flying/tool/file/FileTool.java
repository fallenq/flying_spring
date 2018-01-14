package flying.tool.file;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import flying.config.params.UploadConfig;

public class FileTool {
	
	public boolean isImage(MultipartFile file) {
		return file.getContentType().startsWith("image");
	}
	
	public String getFileExtension(String name) {
		return name.substring(name.lastIndexOf("."));
	}
	
	protected String getResourceRelative(String dirname, String rootDir) {
		if (dirname.startsWith("../")) {
			dirname = dirname.replaceFirst("../", "");
		}
		if (dirname.startsWith("./")) {
			dirname = dirname.replaceFirst("./", "");
		}
		if (!rootDir.isEmpty()) {
			dirname = dirname.replaceFirst(rootDir + "/", "");
		}
		return dirname;
	}
	
	protected String getResourceRelative(String dirname) {
		return getResourceRelative(dirname, UploadConfig.DEFAULT_UPLOAD_ROOT);
	}
	
	protected boolean createOrValidateDir(String dirname) {
		File dir = new File(dirname);
		if (!dir.exists()) {
			return dir.mkdirs();
		}
		return true;
	}
	
	public String getOutFileName(Resource resource) {
		String dirname = "";
		if (resource != null) {
			try {
				dirname = resource.getURL().getPath();
				return dirname.substring(dirname.indexOf(UploadConfig.DEFAULT_UPLOAD_ROOT) - 1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
		return dirname;
	}
	
	public Resource createRelativeResource(Resource resource, String relativePath) {
		try {
			return resource.createRelative(relativePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return null;
	}

}
