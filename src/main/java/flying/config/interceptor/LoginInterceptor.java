package flying.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import flying.config.enums.ResponseCommonMsgEnum;
import flying.service.sparrow.functions.SpUserFuncService;
import flying.tool.AppContextTool;
import flying.tool.JsonTool;
import flying.tool.ResponseTool;
import flying.tool.SessionTool;
import flying.tool.WarnMsgTool;
import flying.tool.model.LoginInfoModel;

public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private AppContextTool appContext;
	@Autowired
	private SpUserFuncService userFuncService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Validating user login info
		SessionTool sessionTool = SessionTool.getInstance(request, appContext.getRedis());
		LoginInfoModel loginInfo = userFuncService.getLoginInfo(sessionTool);
		if (loginInfo != null) {
			// TODO: modify session ipAddress with login ipAddress
//			String ipAddress = CommonTool.getCLientIp(request);
//			if (!ipAddress.equals(loginInfo.getIpAddress())) {
//				loginInfo.setIpAddress(ipAddress);
//				session.setAttribute(ServiceConfig.USER_LOGIN_INFO, loginInfo);
//			}
			return true;
		} else {
			ResponseTool responseService = ResponseTool.getInstance();
			responseService.setMessage(WarnMsgTool.getCommonValue(ResponseCommonMsgEnum.SYSTEM_BUSY.getValue()));
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			response.getWriter().write(JsonTool.write(responseService.combineResponse()));
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
