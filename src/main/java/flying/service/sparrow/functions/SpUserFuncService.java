package flying.service.sparrow.functions;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import flying.config.enums.ResponseSparrowMsgEnum;
import flying.config.enums.UserTypeEnum;
import flying.config.params.ServiceConfig;
import flying.entity.sparrow.SparrowUser;
import flying.entity.sparrow.SparrowUserMobile;
import flying.service.sparrow.basic.SpUserMobileService;
import flying.service.sparrow.basic.SpUserService;
import flying.tool.JsonTool;
import flying.tool.ResponseTool;
import flying.tool.SessionTool;
import flying.tool.StringTool;
import flying.tool.WarnMsgTool;
import flying.tool.model.LoginInfoModel;
import flying.tool.model.ResponseModel;

@Repository
public class SpUserFuncService {

	@Autowired
	private SpUserMobileService mobileService;
	@Autowired
	private SpUserService userService;

	public ResponseModel registerByMobile(String mobile) {
		ResponseTool responseService = ResponseTool.getInstance();
		SparrowUserMobile userMobile = new SparrowUserMobile(mobile);
		int mobileId = mobileService.insert(userMobile);
		if (mobileId > 0) {
			Map<String, Object> pwdSet = userService.createUserPwd();
			SparrowUser user = new SparrowUser();
			user.setNickname(StringTool.parseMobile(mobile, 1));
			user.setUserType(UserTypeEnum.MOBILE_USER_TYPE.getValue());
			user.setSalt((String) pwdSet.get("salt"));
			user.setLoginPwd((String) pwdSet.get("password"));
			user.setUserMobileId(mobileId);
			int userId = userService.insert(user);
			if (userId > 0) {
				userMobile.setUserId(userId);
				mobileService.updateById(userMobile);
				responseService.successStatus();
			}
		}
		if (responseService.isSuccess()) {
			responseService.setMessage(WarnMsgTool.getSparrowValue(ResponseSparrowMsgEnum.USER_REGIST_SUCCESS.getValue()));
		}
		return responseService.combineResponse(WarnMsgTool.getSparrowValue(ResponseSparrowMsgEnum.USER_REGIST_FAILURE.getValue()));
	}

	public void setLoginInfo(SessionTool tool, LoginInfoModel loginInfo) {
		tool.setSessionParam(ServiceConfig.USER_LOGIN_INFO, JsonTool.write(loginInfo));
	}

	public LoginInfoModel getLoginInfo(SessionTool tool) {
		return tool.getSessionRedis(ServiceConfig.USER_LOGIN_INFO, LoginInfoModel.class);
	}

	public void clearLoginInfo(SessionTool tool) {
		tool.removeSession(ServiceConfig.USER_LOGIN_INFO);
	}

	public ResponseModel editUser(int userId, Map<String, Object> userInfo, SparrowUser sparrowUser) {
		ResponseTool responseService = ResponseTool.getInstance();
		if (sparrowUser == null) {
			sparrowUser = userService.getUserById(userId);
			if (sparrowUser == null) {
				return responseService.emptySpUserCombine();
			}
		}
		sparrowUser.setNickname((String) userInfo.getOrDefault("nickname", ""));
		sparrowUser.setFace((String) userInfo.getOrDefault("face", ""));
		if (userService.updateById(sparrowUser) > 0) {
			responseService.successStatus();
		} else {
			return responseService.errorSubmitCombine();
		}
		return responseService.combineResponse();
	}

	public ResponseModel editUser(int userId, Map<String, Object> userInfo) {
		return editUser(userId, userInfo, null);
	}

	public ResponseModel editPassword(int userId, String password, int type, SparrowUser sparrowUser) {
		ResponseTool responseService = ResponseTool.getInstance();
		if (!StringTool.isAvailableString(password)) {
			return responseService.errorParamCombine();
		}
		if (sparrowUser == null) {
			sparrowUser = userService.getUserById(userId);
			if (sparrowUser == null) {
				return responseService.emptySpUserCombine();
			}
		}
		if (type == 1) {
			if (userService.compareUserLoginPwd(sparrowUser, password)) {
				return responseService.combineResponse(WarnMsgTool.getSparrowValue(ResponseSparrowMsgEnum.USER_LOGIN_PASSWORD_SAME.getValue()));
			}
			Map<String, Object> pwdSet = userService.createUserPwd(sparrowUser, password);
			sparrowUser.setLoginPwd((String) pwdSet.get("password"));
			int updateUserId = userService.updateById(sparrowUser);
			if (updateUserId > 0) {
				return responseService.successCombine();
			}
		}
		return responseService.errorSubmitCombine();
	}

	public ResponseModel editPassword(int userId, String password) {
		return editPassword(userId, password, 1, null);
	}

	public ResponseModel editPassword(String mobile, String password) {
		ResponseTool responseService = ResponseTool.getInstance();
		if (!StringTool.isAvailableString(mobile)) {
			return responseService.errorParamCombine();
		}
		SparrowUser sparrowUser = userService.getUserByMobile(mobile);
		if (sparrowUser == null) {
			return responseService.emptySpUserCombine();
		}
		return editPassword(sparrowUser.getId(), password, 1, sparrowUser);
	}

	public ResponseModel getUserInfo(int userId, int method, String...params) {
		ResponseTool responseService = ResponseTool.getInstance();
		SparrowUser sparrowUser = userService.getUserById(userId);
		if (sparrowUser != null) {
			responseService.setDataValue("user", sparrowUser);
			responseService.setDataValue("mobile", null);
			if (method == 1) {
				SparrowUserMobile userMobile = mobileService.getUserMobileById(sparrowUser.getUserMobileId());
				if (userMobile != null) {
					responseService.setDataValue("mobile", userMobile);
				} else {
					responseService.setDataValue("mobile", null);
				}
			}
			responseService.successStatus();
		}
		return responseService.combineResponse();
	}

	public ResponseModel getUserInfo(int userId) {
		return getUserInfo(userId, 0);
	}

	public ResponseModel bindMobile(Integer userId, String mobile, String...params) {
		ResponseTool responseService = ResponseTool.getInstance();
		ResponseModel userModel = getUserInfo(userId);
		if (responseService.isSuccess(userModel)) {
			SparrowUser user = (SparrowUser) userModel.getData().get("user");
			if (user.getUserMobileId() > 0) {
				return responseService.combineResponse(WarnMsgTool.getSparrowValue(ResponseSparrowMsgEnum.USER_MOBILE_BINDED.getValue()));
			}
			SparrowUserMobile userMobile = mobileService.getUserMobileByMobile(mobile);
			if (userMobile != null) {
				return responseService.combineResponse(WarnMsgTool.getSparrowValue(ResponseSparrowMsgEnum.USER_MOBILE_EXISTS.getValue()));
			}
			userMobile = new SparrowUserMobile(mobile);
			int mobileId = mobileService.insert(userMobile);
			user.setUserMobileId(mobileId);
			if (userService.updateById(user) > 0) {
				return responseService.successCombine();
			} else {
				return responseService.errorSubmitCombine();
			}
		}
		return responseService.emptySpUserCombine();
	}

	public ResponseModel unbindMobile(int userId) {
		ResponseTool responseService = ResponseTool.getInstance();
		ResponseModel userModel = getUserInfo(userId);
		if (responseService.isSuccess(userModel)) {
			SparrowUser user = (SparrowUser) userModel.getData().get("user");
			if (user.getUserMobileId() == 0) {
				return responseService.combineResponse(WarnMsgTool.getSparrowValue(ResponseSparrowMsgEnum.USER_MOBILE_UNBINDED.getValue()));
			}
			int mobileId = user.getUserMobileId();
			user.setUserMobileId(0);
			if (userService.updateById(user) > 0) {
				mobileService.delete(mobileId);
				return responseService.successCombine();
			} else {
				return responseService.errorSubmitCombine();
			}
		}
		return responseService.emptySpUserCombine();
	}
	
}
