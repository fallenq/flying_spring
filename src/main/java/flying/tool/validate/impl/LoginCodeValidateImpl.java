package flying.tool.validate.impl;

import flying.config.params.SparrowConfig;
import flying.tool.nozzle.RedisServiceI;

public class LoginCodeValidateImpl extends BaseValidateModel {
	
	public static LoginCodeValidateImpl getInstance(RedisServiceI redisService) {
		return new LoginCodeValidateImpl(redisService);
	}
	
	public LoginCodeValidateImpl(RedisServiceI redisService) {
		super(redisService);
		redisPrefix = SparrowConfig.LOGIN_CODE_REDIS_KEY_PREFIX;
		redisLeftTime = SparrowConfig.LOGIN_CODE_TIME_LIMIT;
	}

}
