package flying.tool;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTool {
	
	public static <T> T read(String content, Class<T> clazz) {
		if (!StringTool.isAvailableString(content)) {
			return null;
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(content, clazz);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String write(Object object) {
		if (object == null) {
			return null;
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			return null;
		}
	}

	
}
