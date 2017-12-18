package flying.tool.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import flying.tool.nozzle.AppContextServiceI;
import flying.tool.nozzle.RedisServiceI;

@Service
public class AppContextImpl implements AppContextServiceI {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public ApplicationContext getAppContext() {
		return applicationContext;
	}

	@Override
	public RedisServiceI getRedis() {
		return (RedisServiceI) applicationContext.getBean("redisService");
	}

	@Override
	public RedisServiceI getRedis(int dbIndex) {
		RedisServiceI redisService = getRedis();
		redisService.selectDb(dbIndex);
		return redisService;	
	}

}
