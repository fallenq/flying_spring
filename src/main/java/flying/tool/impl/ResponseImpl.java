package flying.tool.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import flying.config.enums.ResponseCommonMsgEnum;
import flying.config.enums.ResponseSparrowMsgEnum;
import flying.config.enums.ResponseStatusEnum;
import flying.tool.CommonTool;
import flying.tool.WarnMsgTool;
import flying.tool.model.ResponseModel;
import flying.tool.nozzle.ResponseServiceI;

@Service("responseImpl")
public class ResponseImpl implements ResponseServiceI {

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
	
	public ResponseImpl() {
		init();
	}

	@Override
	public void init() {
		this.data = CommonTool.emptyMap();
		this.message = "";
		failStatus();
	}

	@Override
	public void init(ResponseModel model) {
		status = model.getStatus();
		message = model.getMessage();
		data = model.getData();
	}

	public static ResponseImpl getInstance() {
		return new ResponseImpl();
	}

	@Override
	public void emptyData() {
		this.data.clear();
	}

	@Override
	public void setDataValue(String column, String value) {
		this.data.put(column, value);
	}

	@Override
	public void setDataValue(String column, Object value) {
		this.data.put(column, value);
	}

	@Override
	public void successStatus()	{
		this.status = ResponseStatusEnum.SUCCESS.getValue();
	}

	@Override
	public void failStatus()	{
		this.status = ResponseStatusEnum.FAILURE.getValue();
	}

	@Override
	public boolean isSuccess() {
		return this.status == ResponseStatusEnum.SUCCESS.getValue();
	}

	@Override
	public boolean isSuccess(ResponseModel model) {
		return model.getStatus() == ResponseStatusEnum.FAILURE.getValue();
	}
	
	protected ResponseModel excuteMap(int status, String message, Map<String, Object> data) {
		return new ResponseModel(status, message, data);
	}

	@Override
	public ResponseModel combineResponse() {
		return excuteMap(status, message, data);
	}

	@Override
	public ResponseModel combineResponse(String message) {
		return excuteMap(status, message, data);
	}

	@Override
	public ResponseModel combineResponse(Map<String, Object> data) {
		return excuteMap(status, message, data);
	}

	@Override
	public ResponseModel combineResponse(String message, Map<String, Object> data) {
		return excuteMap(status, message, data);
	}

	@Override
	public ResponseModel combineResponse(int status) {
		return excuteMap(status, message, data);
	}

	@Override
	public ResponseModel successCombine() {
		return combineResponse(ResponseStatusEnum.SUCCESS.getValue());
	}

	@Override
	public ResponseModel errorParamCombine() {
		return combineResponse(WarnMsgTool.getCommonValue(ResponseCommonMsgEnum.PARAM_ERROR.getValue()));
	}

	@Override
	public ResponseModel noSpUserCombine() {
		return combineResponse(WarnMsgTool.getSparrowValue(ResponseSparrowMsgEnum.USER_NOEXISTS.getValue()));
	}

	@Override
	public ResponseModel errorSubmitCombine() {
		return combineResponse(WarnMsgTool.getCommonValue(ResponseCommonMsgEnum.SUBMIT_ERROR.getValue()));
	}

}
