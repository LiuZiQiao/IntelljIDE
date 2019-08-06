package com.lxk.redis;

import org.omg.CORBA.TIMEOUT;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
    private static String ADDR = "148.70.97.159";
    private static int PORT = 6379;
    private static String AUTH = "123456";
    private static int MAX_ACTIVE = 1024;
    private static int MAX_IDLE = 200;
    private static int MAX_WAIT = 1000;
    private static int TIMEOUT = 1000;
    private static JedisPool jedisPool = null;
    static {
        try{
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(MAX_IDLE);
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxWaitMillis(MAX_WAIT);
            jedisPool = new JedisPool(config,ADDR,PORT, TIMEOUT,AUTH);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized static Jedis getJedis(){
        try{
            if(jedisPool != null){
                Jedis resource = jedisPool.getResource();
                return resource;
            }else {
                return null;
            }
        }catch (Exception e ){
            e.printStackTrace();
            return null;
        }
    }

    public static void returnResource(final  Jedis jedis){
        if(jedis != null){
            jedisPool.returnResource((jedis));
        }
    }
}
