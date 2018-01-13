package flying.tool.validate.impl;

import java.util.concurrent.TimeUnit;

import flying.tool.StringTool;
import flying.tool.TimeTool;
import flying.tool.nozzle.RedisServiceI;
import flying.tool.validate.nozzle.ValidateModelServiceI;

public class BaseValidateModel implements ValidateModelServiceI {

	protected String redisKey = "";
	protected String redisPrefix = "";
	protected String redisLimitKey = "";
	protected String redisLimitPrefix = "";
	protected String redisLimitItem = "";
	protected int redisLeftTime = 0;
	protected int limitMax = 0;
	protected RedisServiceI redisService;

	public BaseValidateModel(RedisServiceI redisService) {
		this.redisService = redisService;
	}

	// @Override
	// public ValidateModelServiceI getValidateService() {
	// return validateService;
	// }

	@Override
	public String getRedisKey() {
		return redisKey;
	}

	@Override
	public void setRedisKey(String redisKey) {
		this.redisKey = redisPrefix + redisKey;
	}

	@Override
	public void setRedisLimitKey(String redisLimitItem) {
		this.redisLimitKey = redisLimitPrefix + TimeTool.simpleDate();
		this.redisLimitItem = redisLimitItem;
	}

	@Override
	public boolean determine() {
		if (!StringTool.isAvailableString(redisKey)) {
			return false;
		}
		try {
			String redisKeyValue = redisService.get(redisKey);
			if (redisKeyValue.isEmpty()) {
				return true;
			}
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	@Override
	public boolean determine(String redisKey, String compareValue) {
		if (!StringTool.isAvailableString(redisKey) || !StringTool.isAvailableString(compareValue)) {
			return false;
		}
		try {
			setRedisKey(redisKey);
			String redisKeyValue = redisService.get(this.redisKey);
			if (redisKeyValue.equals(compareValue)) {
				removeRedisValue();
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean determineLimit() {
		if (!StringTool.isAvailableString(redisLimitKey) || !StringTool.isAvailableString(redisLimitItem)) {
			return false;
		}
		try {
			int limitValue = (int) redisService.zscore(redisLimitKey, redisLimitItem);
			if (limitValue < limitMax) {
				return true;
			}
		} catch (NumberFormatException e) {
			return true;
		}
		return false;
	}

	@Override
	public boolean setRedisValue(String value) {
		redisService.set(redisKey, value, redisLeftTime);
		return false;
	}

	@Override
	public String getRedisValue() {
		return redisService.get(redisKey);
	}

	@Override
	public void incrementLimit(int disc) {
		if (StringTool.isAvailableString(redisLimitKey) && StringTool.isAvailableString(redisLimitItem)) {
			try {
				redisService.zincrby(redisLimitKey, redisLimitItem, disc);
			} catch (Exception e) {
				redisService.zadd(redisLimitKey, redisLimitItem, disc);
				redisService.expire(redisLimitKey, 1, TimeUnit.DAYS);
			}
		}
	}

	@Override
	public void incrementLimit() {
		incrementLimit(1);
	}

	@Override
	public void removeRedisValue() {
		redisService.delete(redisKey);
	}

}
