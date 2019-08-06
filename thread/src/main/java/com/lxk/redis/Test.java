package com.lxk.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    private Jedis jedis;

    public boolean connectRedis(){
        jedis = RedisUtil.getJedis();
        if (jedis != null)
            return true;
        return false;
    }


    public void testString(){
        jedis.set("name","lxk");
        System.out.println(jedis.get("name"));
    }

    public void testMap(){
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("name","lxk");
//        map.put("age","22");
//        map.put("sex","男");
//        jedis.hmset("user",map);

        List<String> list = jedis.hmget("user","name","age","sex");
        for (String s: list) {
            System.out.println(s);
        }

        jedis.hdel("user","sex");
        List<String> list1 = jedis.hmget("user","name","age","sex");
        for (String s: list1) {
            System.out.println(s);
        }
    }

    public void testList(){
//        jedis.lpush("java","Spring");
//        jedis.lpush("java","Mybaits");
//        jedis.lpush("java","Redis");
        jedis.del("java");
        jedis.rpush("java","javaee");
        jedis.rpush("java","javase");
        //jedis.del("java");
        System.out.println(jedis.lrange("java",0,3));//end: -1  表示取得所有
    }

    public void testSet(){
        jedis.sadd("users","liu");
        jedis.sadd("users","xiao");
        jedis.sadd("users","kun");

        System.out.println(jedis.smembers("users"));
        System.out.println(jedis.scard("users"));
        System.out.println(jedis.srandmember("users"));
    }

    public void  testSort(){
        jedis.rpush("a","1");
        jedis.rpush("a","3");
        jedis.rpush("a","2");
        jedis.rpush("a","5");
        jedis.lpush("a","4");
        System.out.println(jedis.lrange("a",0,-1));
        System.out.println(jedis.sort("a"));
        System.out.println(jedis.lrange("a",0,-1));

    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.connectRedis());
        //t.testString();
//        t.testMap();
//        t.testList();
//        t.testSet();
        t.testSort();
    }
}
