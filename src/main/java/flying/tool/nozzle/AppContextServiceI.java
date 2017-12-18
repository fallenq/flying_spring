package flying.tool.nozzle;

import org.springframework.context.ApplicationContext;

public interface AppContextServiceI {
	public ApplicationContext getAppContext();
	public RedisServiceI getRedis();
	public RedisServiceI getRedis(int dbIndex);
}
