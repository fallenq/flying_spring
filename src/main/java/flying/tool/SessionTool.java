package flying.tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import flying.config.params.CommonConfig;
import flying.tool.nozzle.RedisServiceI;

public class SessionTool {

	private HttpSession session;

	private RedisServiceI redisService = null;

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	public RedisServiceI getRedisService() {
		return redisService;
	}

	public void setRedisService(RedisServiceI redisService) {
		this.redisService = redisService;
	}

	public static SessionTool getInstance(HttpServletRequest request) {
		SessionTool tool = new SessionTool();
		tool.setSession(request.getSession());
		return tool;
	}

	public static SessionTool getInstance(HttpServletRequest request, RedisServiceI redisService) {
		SessionTool tool = getInstance(request);
		tool.setRedisService(redisService);
		return tool;
	}

	/**
	 * Get session by name
	 * 
	 * @param keyName
	 * @return
	 */
	public void setSessionParam(String name, Object object) {
		session.setAttribute(name, object);
	}

	/**
	 * Get session id
	 * 
	 * @return
	 */
	public String getSessionId() {
		return session.getId();
	}

	/**
	 * Get session of redis
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getSessionRedis(String name) {
		if (!StringTool.isAvailableString(name)) {
			return null;
		}
		String sessionKey = CommonConfig.SESSION_DATA_PREFIX + getSessionId();
		String sessionDataKey = CommonConfig.SESSION_COLUMN_PREFIX + name;
		return (T) redisService.hgetField(sessionKey, sessionDataKey);
	}

	/**
	 * Get session object of redis
	 * 
	 * @param name
	 * @param clazz
	 * @return
	 */
	public <T> T getSessionRedis(String name, Class<T> clazz) {
//		JSONObject object = getSessionRedis(name);
//		return CommonTool.parseJSONObject(object, clazz);
		return null;
	}

	/**
	 * Get session by name
	 * 
	 * @param keyName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getSessionParam(String name) {
		T object = (T) session.getAttribute(name);
		return object;
	}

	/**
	 * Remove session by name
	 * 
	 * @param name
	 * @return
	 */
	public void removeSession(String name) {
		session.removeAttribute(name);
	}

}
