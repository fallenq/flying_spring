package flying.tool.validate.impl;

import flying.config.params.SparrowConfig;
import flying.tool.nozzle.RedisServiceI;

public class MobileSendValidateImpl extends BaseValidateModel {
	
	public static MobileSendValidateImpl getInstance(RedisServiceI redisService) {
		return new MobileSendValidateImpl(redisService);
	}
	
	public MobileSendValidateImpl(RedisServiceI redisService) {
		super(redisService);
		redisPrefix = SparrowConfig.MOBILE_SEND_REDIS_KEY_PREFIX;
		redisLeftTime = SparrowConfig.MOBILE_SEND_TIME_LIMIT;
		redisLimitPrefix = SparrowConfig.MOBILE_SEND_LIMIT_REDIS_KEY_PREFIX;
		limitMax = SparrowConfig.MOBILE_SEND_LIMIT_MAX_REDIS_KEY_PREFIX;
	}

}
