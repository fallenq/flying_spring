package flying.tool.nozzle;

import java.util.Map;

import flying.tool.model.ResponseModel;

public interface ResponseServiceI {
	public void init();
	public void init(ResponseModel model);
	public void setStatus(int status);
	public void setMessage(String message);
	public void setData(Map<String, Object> data);
	public void setDataValue(String column, String value);
	public void setDataValue(String column, Object object);
	public void emptyData();
	public void successStatus();
	public void failStatus();
	public boolean isSuccess();
	public boolean isSuccess(ResponseModel model);
	public ResponseModel combineResponse();
	public ResponseModel combineResponse(String message);
	public ResponseModel combineResponse(Map<String, Object> data);
	public ResponseModel combineResponse(String message, Map<String, Object> data);
	public ResponseModel combineResponse(int status);
	public ResponseModel successCombine();
	public ResponseModel errorParamCombine();
	public ResponseModel noSpUserCombine();
	public ResponseModel errorSubmitCombine();
}
