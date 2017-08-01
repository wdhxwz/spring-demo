package com.wangdh.spring.cache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;

import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis缓存配置
 * 
 * @author wdhcxx
 *
 */
@Configuration
@EnableCaching
@ComponentScan(basePackages = { "com.wangdh.spring.cache.service" })
public class RedisCacheConfig extends CachingConfigurerSupport {
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();

		// 单机配置
		connectionFactory.setHostName("127.0.0.1");
		connectionFactory.setPort(6379);

		// 集群配置
		RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
		RedisNode redisNode7000 = new RedisNode("10.1.21.4", 7000);
		RedisNode redisNode7001 = new RedisNode("10.1.21.4", 7001);
		RedisNode redisNode7002 = new RedisNode("10.1.21.4", 7002);
		RedisNode redisNode7003 = new RedisNode("10.1.21.4", 7003);
		RedisNode redisNode7004 = new RedisNode("10.1.21.4", 7004);
		RedisNode redisNode7005 = new RedisNode("10.1.21.4", 7005);
		redisClusterConfiguration.addClusterNode(redisNode7000);
		redisClusterConfiguration.addClusterNode(redisNode7001);
		redisClusterConfiguration.addClusterNode(redisNode7002);
		redisClusterConfiguration.addClusterNode(redisNode7003);
		redisClusterConfiguration.addClusterNode(redisNode7004);
		redisClusterConfiguration.addClusterNode(redisNode7005);
		connectionFactory = new JedisConnectionFactory(redisClusterConfiguration);

		// 设置连接池配置
		connectionFactory.setPoolConfig(jedisConfig());

		// 设置数据库，默认0
		connectionFactory.setDatabase(2);

		// 设置使用连接池
		connectionFactory.setUsePool(true);

		// 哨兵配置
		// RedisSentinelConfiguration redisSentinelConfiguration = new
		// RedisSentinelConfiguration();
		// RedisNode redisNode = new RedisNode("10.1.21.4", 7000);
		// redisSentinelConfiguration.addSentinel(redisNode);

		// 10.1.21.4:7000 10.1.21.4:7001 10.1.21.4:7002 10.1.21.4:7003
		// 10.1.21.4:7004 10.1.21.4:7005

		return connectionFactory;
	}

	@Bean
	public JedisPoolConfig jedisConfig() {
		JedisPoolConfig config = new JedisPoolConfig();

		// 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
		config.setBlockWhenExhausted(true);

		// 设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
		config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");

		// 最大空闲连接数, 默认8个
		config.setMaxIdle(8);

		// 最大连接数, 默认8个
		config.setMaxTotal(10);

		// 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,
		// 默认-1
		config.setMaxWaitMillis(-1);

		// 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
		config.setMinEvictableIdleTimeMillis(1800000);

		// 最小空闲连接数, 默认0
		config.setMinIdle(0);

		// 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
		config.setNumTestsPerEvictionRun(3);

		// 在获取连接的时候检查有效性, 默认false
		config.setTestOnBorrow(false);

		// 在空闲时检查有效性, 默认false
		config.setTestWhileIdle(false);

		// 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
		config.setTimeBetweenEvictionRunsMillis(-1);

		return config;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);

		// 设置key的序列化
		redisTemplate.setKeySerializer(new StringRedisSerializer());

		// 设置value序列化存储
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

		// 设置使用CacheName作为每个key的前缀
		cacheManager.setUsePrefix(true);

		return cacheManager;
	}

	@Bean
	public RedisHttpSessionConfiguration redisHttpSessionConfiguration() {
		RedisHttpSessionConfiguration redisHttpSessionConfiguration = new RedisHttpSessionConfiguration();
		redisHttpSessionConfiguration.setMaxInactiveIntervalInSeconds(600);
		
		return redisHttpSessionConfiguration;
	}
}
