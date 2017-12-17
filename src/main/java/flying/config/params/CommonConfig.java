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
	
}
