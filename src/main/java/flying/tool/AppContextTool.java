package flying.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import flying.tool.nozzle.RedisServiceI;

@Repository
public class AppContextTool {
	
	@Autowired
	private ApplicationContext applicationContext;

	public ApplicationContext getAppContext() {
		return applicationContext;
	}

	public RedisServiceI getRedis() {
		return (RedisServiceI) applicationContext.getBean("redisService");
	}

	public RedisServiceI getRedis(int dbIndex) {
		RedisServiceI redisService = getRedis();
		redisService.selectDb(dbIndex);
		return redisService;	
	}

}
