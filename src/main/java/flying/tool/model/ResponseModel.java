package flying.tool.model;

import java.util.Map;

public class ResponseModel {
	private Integer status = 0;
	private String message = null;
	private Map<String, Object> data = null;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public ResponseModel() {
		
	}
	
	public ResponseModel(int status, String message, Map<String, Object> data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
//	public Map<String, Object> transform(){
//		Map<String, Object> map = CommonTool.emptyMap();
//		map.put("status", Integer.toString(this.status));
//		if (message instanceof String) {
//			map.put("msg", this.message);
//		} else {
//			map.put("msg", "");
//		}
//		if (data instanceof Map) {
//			map.put("data", data);
//		} else {
//			map.put("data", CommonTool.emptyMap());
//		}
//		return map;
//	}
}
