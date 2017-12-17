package flying.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//import com.alibaba.fastjson.JSON;
//import com.service.config.enums.ResponseCommonMsgEnum;
//import com.service.model.LoginInfoModel;
//import com.service.sparrow.nozzle.SpUserFuncServiceI;
//import com.service.tool.SessionTool;
//import com.service.tool.WarnMsgTool;
//import com.service.tool.impl.ResponseImpl;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Autowired
//	private SpUserFuncServiceI userFuncService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Validating user login info
//		SessionTool sessionTool = SessionTool.getInstance(request);
//		LoginInfoModel loginInfo = userFuncService.getLoginInfo(sessionTool);
//		if (loginInfo != null) {
//			// TODO: modify session ipAddress with login ipAddress
////			String ipAddress = CommonTool.getCLientIp(request);
////			if (!ipAddress.equals(loginInfo.getIpAddress())) {
////				loginInfo.setIpAddress(ipAddress);
////				session.setAttribute(ServiceConfig.USER_LOGIN_INFO, loginInfo);
////			}
//			return true;
//		} else {
//			ResponseImpl responseImpl = ResponseImpl.getInstance();
//			responseImpl.setMessage(WarnMsgTool.getCommonValue(ResponseCommonMsgEnum.SYSTEM_BUSY.getValue()));
//			response.setHeader("Content-type", "text/html;charset=UTF-8");
//			response.getWriter().write(JSON.toJSONString(responseImpl.combineResponse()));
//			return false;
//		}
		return false;
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
