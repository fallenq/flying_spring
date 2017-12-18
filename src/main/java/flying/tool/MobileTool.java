package flying.tool;

import flying.tool.impl.ResponseImpl;
import flying.tool.model.ResponseModel;

public class MobileTool {
	
	private static MobileTool mobileTool = null;

	/**
	 * Get the instance
	 * 
	 * @return
	 */
	public static MobileTool getInstance() {
		if (mobileTool == null) {
			mobileTool = new MobileTool();
		}
		return mobileTool;
	}

	/**
	 * Send mobile message
	 * 
	 * @param mobile
	 * @param content
	 * @param templateId
	 * @return
	 */
	public ResponseModel sendMobileMsg(String mobile, String content, String templateId) {
		ResponseImpl responseService = ResponseImpl.getInstance();
		// TODO: use send sms with third api
		responseService.successStatus();
		return responseService.combineResponse();
	}

	/**
	 * Send validate code to mobile
	 * 
	 * @param mobile
	 * @param vcode
	 * @param ipAddress
	 * @return
	 */
	public ResponseModel sendMobileCode(String mobile, String vcode) {
		ResponseImpl responseService = ResponseImpl.getInstance();
		// TODO: add mobile sms template ID
		ResponseModel sendResult = sendMobileMsg(mobile, vcode, "");
		if (responseService.isSuccess(sendResult)) {
			responseService.successStatus();
			responseService.setDataValue("vcode", vcode);
		} else {
			responseService.setMessage(sendResult.getMessage());
		}
		return responseService.combineResponse();
	}


}
