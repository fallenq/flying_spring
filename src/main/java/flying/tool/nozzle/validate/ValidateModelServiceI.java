package flying.tool.nozzle.validate;

public interface ValidateModelServiceI {
//	public ValidateModelServiceI getValidateService();
	public String getRedisKey();
	public void setRedisKey(String redisKey);
	public void setRedisLimitKey(String redisLimitKey);
	public boolean determine();
	public boolean determine(String redisKey, String compareValue);
	public boolean determineLimit();
	public boolean setRedisValue(String value);
	public void incrementLimit(int disc);
	public void incrementLimit();
	public String getRedisValue();
	public void removeRedisValue();
}
