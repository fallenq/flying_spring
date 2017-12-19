package flying.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import flying.config.enums.RedisSparrowEnum;
import flying.config.enums.ResponseCommonMsgEnum;
import flying.config.enums.ResponseSparrowMsgEnum;
import flying.config.enums.SparrowValidateEnum;
import flying.config.params.CommonConfig;
import flying.service.sparrow.basic.SpUserMobileService;
import flying.service.sparrow.functions.SpUserFuncService;
import flying.tool.AppContextTool;
import flying.tool.CommonTool;
import flying.tool.MobileTool;
import flying.tool.ResponseTool;
import flying.tool.SessionTool;
import flying.tool.ValidateTool;
import flying.tool.WarnMsgTool;
import flying.tool.model.LoginInfoModel;
import flying.tool.model.ResponseModel;
import flying.tool.validate.nozzle.ValidateModelServiceI;

@RestController
@RequestMapping("/api/mobile")
public class MobileApiController {
	
	@Autowired
	private AppContextTool appContext;
	@Autowired
	private SpUserMobileService mobileService;
	@Autowired
	private SpUserFuncService userFuncService;

	/**
	 * Send validate code in sms
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/validate/code", method = RequestMethod.POST)
	public ResponseModel sendMobileCode(HttpServletRequest request) {
		int type = SparrowValidateEnum.MOBILE_VALIDATE_SEND_TYPE.getValue();
		String mobile = request.getParameter("mobile");
		String ipAddress = CommonTool.getCLientIp(request);
		ResponseTool responseService = ResponseTool.getInstance();
		ValidateTool validateTool = ValidateTool.getInstance();
		ValidateModelServiceI validateService = validateTool.getValidateService(type, appContext.getRedis(RedisSparrowEnum.BASIC.getValue()));
		if (validateTool.determine(validateService, mobile, ipAddress)) {
			String validateCode = CommonTool.getValidateNumber(CommonConfig.VALIDATE_CODE_LENGTH_FOUR);
			if (validateCode.isEmpty()) {
				return responseService.errorSubmitCombine();
			} else {
				ResponseModel sendResponse = MobileTool.getInstance().sendMobileCode(mobile, validateCode);
				if (responseService.isSuccess(sendResponse)) {
					validateService.setRedisValue(validateCode);
					validateService.incrementLimit();
					// TODO: 测试后删除===========
					responseService.setDataValue("vcode", validateCode);
					// TODO: end==============
					responseService.successStatus();
				} else {
					responseService.setMessage(sendResponse.getMessage());
				}
			}
		} else {
			responseService.setMessage(WarnMsgTool.getSparrowValue(ResponseSparrowMsgEnum.USER_MOBILE_SENDED.getValue()));
		}
		return responseService.combineResponse();
	}
	
	/**
	 * Compare validate code in sms
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/compare/code", method = RequestMethod.POST)
	public ResponseModel compareMobileCode(String mobile, String code) {
		ResponseTool responseService = ResponseTool.getInstance();
		ValidateModelServiceI validateService = ValidateTool.getInstance().getValidateService(SparrowValidateEnum.MOBILE_VALIDATE_SEND_TYPE.getValue(), appContext.getRedis(RedisSparrowEnum.BASIC.getValue()));
		if (validateService.determine(mobile, code)) {
			return responseService.successCombine();
		}
		return responseService.combineResponse(WarnMsgTool.getCommonValue(ResponseCommonMsgEnum.VALIDATE_CODE_ERROR.getValue()));
	}

	/**
	 * Mobile if exist
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/exist", method = RequestMethod.POST)
	public ResponseModel existMobile(String mobile) {
		return mobileService.existMobile(mobile);
	}

	/**
	 * Bind mobile to user
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/bind", method = RequestMethod.POST)
	public ResponseModel bindMobile(HttpServletRequest request) {
		ResponseTool responseService = ResponseTool.getInstance();
		LoginInfoModel loginInfo = userFuncService.getLoginInfo(SessionTool.getInstance(request, appContext.getRedis()));
		String mobile = request.getParameter("mobile");
		String vcode = request.getParameter("vcode");
		ValidateModelServiceI validateService = ValidateTool.getInstance().getValidateService(SparrowValidateEnum.MOBILE_VALIDATE_SEND_TYPE.getValue(), appContext.getRedis(RedisSparrowEnum.BASIC.getValue()));
		if (!validateService.determine(mobile, vcode)) {
			return responseService.combineResponse(WarnMsgTool.getCommonValue(ResponseCommonMsgEnum.VALIDATE_CODE_ERROR.getValue()));
		}
		return userFuncService.bindMobile(loginInfo.getUserId(), mobile);
	}

	/**
	 * Unbind mobile with user
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/unbind", method = RequestMethod.POST)
	public ResponseModel unbindMobile(HttpServletRequest request) {
		LoginInfoModel loginInfo = userFuncService.getLoginInfo(SessionTool.getInstance(request));
		return userFuncService.unbindMobile(loginInfo.getUserId());
	}

}
