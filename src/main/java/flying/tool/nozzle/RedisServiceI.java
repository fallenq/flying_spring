package flying.tool.nozzle;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface RedisServiceI {
	public String ping();
	public void selectDb(int dbIndex);
	public boolean hasKey(String name);
	public boolean expire(String name, int timeout, TimeUnit unit);
	public void set(String name, String value);
	public void set(String name, String value, int timeout);
	public void setForever(String name, String value);
	public void setWithTimeout(String name, String value, int timeout, TimeUnit unit);
	public boolean setnx(String name, String value);
	public boolean setnx(String name, String value, int timeout);
	public boolean setnxForever(String name, String value);
	public boolean setnxWithTimeout(String name, String value, int timeout, TimeUnit unit);
	public String get(String name);
	public long incrementLong(String name, long disc);
	public void delete(String name);
	public boolean zadd(String name, String item, double score);
	public double zscore(String name, String item);
	public double zincrby(String name, String item, double increment);
	public Map<String, Object> hgetAll(String name);
	public Object hgetField(String name, String column);
}
