package flying.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import flying.config.enums.RedisSparrowEnum;
import flying.config.enums.ResponseSparrowMsgEnum;
import flying.config.params.CommonConfig;
import flying.service.sparrow.functions.SpVersionService;
import flying.tool.AppContextTool;
import flying.tool.CommonTool;
import flying.tool.ResponseTool;
import flying.tool.ValidateTool;
import flying.tool.WarnMsgTool;
import flying.tool.model.ResponseModel;
import flying.tool.validate.nozzle.ValidateModelServiceI;

@RestController
@RequestMapping("/api/common")
public class CommonApiController {
	
	@Autowired
	private AppContextTool appContext;

	@Autowired
	private SpVersionService versionService;

	/**
	 * Get login validate
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/validate/address", method = RequestMethod.POST)
	public ResponseModel loginValidate(HttpServletRequest request) {
		int type = Integer.parseInt(request.getParameter("type"));
		ResponseTool responseService = ResponseTool.getInstance();
		ValidateTool validateTool = ValidateTool.getInstance();
		ValidateModelServiceI validateService = validateTool.getValidateService(type, appContext.getRedis(RedisSparrowEnum.BASIC.getValue()));
		if (validateTool.determine(validateService, CommonTool.getCLientIp(request))) {
			String validateCode = CommonTool.getValidateNumber(CommonConfig.VALIDATE_CODE_LENGTH_FOUR);
			if (!validateCode.isEmpty()) {
				validateService.setRedisValue(validateCode);
				responseService.setDataValue("code", validateCode);
				responseService.successStatus();
			} else {
				return responseService.errorSubmitCombine();
			}
		} else {
			responseService.setMessage(WarnMsgTool.getSparrowValue(ResponseSparrowMsgEnum.CODE_ACCESSED.getValue()));
		}
		return responseService.combineResponse();
	}

	/**
	 * Compare device version
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/version/compare", method = RequestMethod.POST)
	public ResponseModel compareVersion(HttpServletRequest request) {
//		int dtype = Integer.parseInt(request.getParameter("dtype"));
		String versionCode = request.getParameter("vcode");
		return versionService.compareLastVersion(1, versionCode);
	}

}
