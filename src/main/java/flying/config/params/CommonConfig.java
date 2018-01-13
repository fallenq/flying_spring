package flying.config.params;

public class CommonConfig {
	
	public static int VALIDATE_CODE_LENGTH_DEFAULT = 6;
	public static int VALIDATE_CODE_LENGTH_FOUR = 4;
	public static int VALIDATE_CODE_LENGTH_SIX = 6;
	public static int REDIS_DEFAULT_TIMEOUT = 60;
	
	public static String COMMON_REDIS_PREFIX = "test:";
	public static String COMMON_SESSION_PREFIX = "test:";
	public static String SESSION_DATA_PREFIX = "spring:session:sessions:";
	public static String SESSION_COLUMN_PREFIX = "sessionAttr:";
	
	public static String COMMON_DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static String SIMPLE_DEFAULT_TIME_FORMAT = "yyyy-MM-dd";
	
}
