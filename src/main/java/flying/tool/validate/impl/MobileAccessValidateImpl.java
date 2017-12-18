package flying.tool.validate.impl;

import flying.config.params.SparrowConfig;
import flying.tool.nozzle.RedisServiceI;

public class MobileAccessValidateImpl extends BaseValidateModel {

	public static MobileAccessValidateImpl getInstance(RedisServiceI redisService) {
		return new MobileAccessValidateImpl(redisService);
	}

	public MobileAccessValidateImpl(RedisServiceI redisService) {
		super(redisService);
		redisPrefix = SparrowConfig.MOBILE_ACCESS_REDIS_KEY_PREFIX;
		redisLeftTime = SparrowConfig.MOBILE_ACCESS_TIME_LIMIT;
	}

}
