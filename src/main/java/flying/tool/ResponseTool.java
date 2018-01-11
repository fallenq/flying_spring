package flying.tool;

import java.util.Map;

import flying.config.enums.ResponseCommonMsgEnum;
import flying.config.enums.ResponseSparrowMsgEnum;
import flying.config.enums.ResponseStatusEnum;
import flying.tool.model.ResponseModel;

public class ResponseTool {

	private int status = 0;
	private String message = "";
	private Map<String, Object> data = null;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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
	
	public ResponseTool() {
		init();
	}

	public void init() {
		this.data = CommonTool.emptyMap();
		this.message = "";
		failStatus();
	}

	public void init(ResponseModel model) {
		status = model.getStatus();
		message = model.getMessage();
		data = model.getData();
	}

	public static ResponseTool getInstance() {
		return new ResponseTool();
	}

	public void emptyData() {
		this.data.clear();
	}

	public void setDataValue(String column, String value) {
		this.data.put(column, value);
	}

	public void setDataValue(String column, Object value) {
		this.data.put(column, value);
	}

	public void successStatus()	{
		this.status = ResponseStatusEnum.SUCCESS.getValue();
	}

	public void failStatus()	{
		this.status = ResponseStatusEnum.FAILURE.getValue();
	}

	public boolean isSuccess() {
		return this.status == ResponseStatusEnum.SUCCESS.getValue();
	}

	public boolean isSuccess(ResponseModel model) {
		return model.getStatus() == ResponseStatusEnum.FAILURE.getValue();
	}
	
	protected ResponseModel excuteMap(int status, String message, Map<String, Object> data) {
		return new ResponseModel(status, message, data);
	}

	public ResponseModel combineResponse() {
		return excuteMap(status, message, data);
	}

	public ResponseModel combineResponse(String message) {
		return excuteMap(status, message, data);
	}

	public ResponseModel combineResponse(Map<String, Object> data) {
		return excuteMap(status, message, data);
	}

	public ResponseModel combineResponse(String message, Map<String, Object> data) {
		return excuteMap(status, message, data);
	}

	public ResponseModel combineResponse(int status) {
		return excuteMap(status, message, data);
	}

	public ResponseModel successCombine() {
		return combineResponse(ResponseStatusEnum.SUCCESS.getValue());
	}

	public ResponseModel errorParamCombine() {
		return combineResponse(WarnMsgTool.getCommonValue(ResponseCommonMsgEnum.PARAM_ERROR.getValue()));
	}

	public ResponseModel emptySpUserCombine() {
		return combineResponse(WarnMsgTool.getSparrowValue(ResponseSparrowMsgEnum.USER_NOEXISTS.getValue()));
	}

	public ResponseModel errorSubmitCombine() {
		return combineResponse(WarnMsgTool.getCommonValue(ResponseCommonMsgEnum.SUBMIT_ERROR.getValue()));
	}

}
