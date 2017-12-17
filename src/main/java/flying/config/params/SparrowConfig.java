package flying.config.params;

public class SparrowConfig {
	// Login
	public static int LOGIN_CODE_TIME_LIMIT = 60;
	public static String LOGIN_CODE_REDIS_KEY_PREFIX = CommonConfig.COMMON_REDIS_PREFIX + "login:vcaccess:";
	// Mobile
	public static int MOBILE_SEND_TIME_LIMIT = 60;
	public static String MOBILE_SEND_REDIS_KEY_PREFIX = CommonConfig.COMMON_REDIS_PREFIX + "mobile:vcsend:";
	public static String MOBILE_SEND_LIMIT_REDIS_KEY_PREFIX = CommonConfig.COMMON_REDIS_PREFIX + "mobile:vcsend:limit:";
	public static int MOBILE_SEND_LIMIT_MAX_REDIS_KEY_PREFIX = 5;
	public static int MOBILE_ACCESS_TIME_LIMIT = 60;
	public static String MOBILE_ACCESS_REDIS_KEY_PREFIX = CommonConfig.COMMON_REDIS_PREFIX + "mobile:vcaccess:";
}
