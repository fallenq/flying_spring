package flying.tool.impl;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import flying.config.params.CommonConfig;
import flying.tool.nozzle.RedisServiceI;

@Service("redisService")
public class RedisImpl implements RedisServiceI {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private ValueOperations<String, Object> operationValue = null;
	private ZSetOperations<String, Object> operationZset = null;
	private HashOperations<String, String, Object> operationHash = null;

	private ValueOperations<String, Object> getValueOperation() {
		if (operationValue == null) {
			operationValue = redisTemplate.opsForValue();
		}
		return operationValue;
	}
	
	private ZSetOperations<String, Object> getZsetOperation() {
		if (operationZset == null) {
			operationZset = redisTemplate.opsForZSet();
		}
		return operationZset;
	}
	
	private HashOperations<String, String, Object> getHashOperation() {
		if (operationHash == null) {
			operationHash = redisTemplate.opsForHash();
		}
		return operationHash;
	}

	@Override
	public String ping() {
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.ping();
			}
		});
	}

	@Override
	public void selectDb(int dbIndex) {
		JedisConnectionFactory redisConnectFactory = (JedisConnectionFactory) redisTemplate.getConnectionFactory();
		redisConnectFactory.setDatabase(dbIndex);
		redisTemplate.setConnectionFactory(redisConnectFactory);
	}

	@Override
	public boolean hasKey(String name) {
		return redisTemplate.hasKey(name);
	}

	@Override
	public boolean expire(String name, int timeout, TimeUnit unit) {
		return redisTemplate.expire(name, timeout, unit);
	}

	@Override
	public void set(String name, String value) {
		setWithTimeout(name, value, CommonConfig.REDIS_DEFAULT_TIMEOUT, TimeUnit.SECONDS);
	}

	@Override
	public void set(String name, String value, int timeout) {
		setWithTimeout(name, value, timeout, TimeUnit.SECONDS);
	}

	@Override
	public void setForever(String name, String value) {
		getValueOperation().set(name, value);
	}

	@Override
	public void setWithTimeout(String name, String value, int timeout, TimeUnit unit) {
		if (timeout <= 0) {
			timeout = CommonConfig.REDIS_DEFAULT_TIMEOUT;
		}
		if (unit == null) {
			unit = TimeUnit.SECONDS;
		}
		getValueOperation().set(name, value, timeout, unit);
	}

	@Override
	public boolean setnx(String name, String value) {
		return setnxWithTimeout(name, value, CommonConfig.REDIS_DEFAULT_TIMEOUT, TimeUnit.SECONDS);
	}

	@Override
	public boolean setnx(String name, String value, int timeout) {
		return setnxWithTimeout(name, value, timeout, TimeUnit.SECONDS);
	}

	@Override
	public boolean setnxForever(String name, String value) {
		return getValueOperation().setIfAbsent(name, value);
	}

	@Override
	public boolean setnxWithTimeout(String name, String value, int timeout, TimeUnit unit) {
		if (setnxForever(name, value)) {
			expire(name, timeout, unit);
			return true;
		}
		return false;
	}

	@Override
	public String get(String name) {
		return (String) getValueOperation().get(name);
	}

	@Override
	public long incrementLong(String name, long disc) {
		return getValueOperation().increment(name, disc);
	}

	@Override
	public void delete(String name) {
		redisTemplate.delete(name);
	}

	@Override
	public boolean zadd(String name, String item, double score) {
		return getZsetOperation().add(name, item, score);
	}

	@Override
	public double zscore(String name, String item) {
		return getZsetOperation().score(name, item);
	}

	@Override
	public double zincrby(String name, String item, double increment) {
		return getZsetOperation().incrementScore(name, item, increment);
	}

	@Override
	public Map<String, Object> hgetAll(String name) {
		return getHashOperation().entries(name);
	}

	@Override
	public Object hgetField(String name, String column) {
		return getHashOperation().get(name, column);
	}

}
