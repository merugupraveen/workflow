package org.example;

import redis.clients.jedis.Jedis;

public class RedisUtils {

  static Jedis jedis = new Jedis("localhost" , 6379);

  public static void set(String key, String  val, long ttl) {
    jedis.setex(key, ttl , val);
//    jedis.close();
  }

  public static void main(String[] args) {
    set("s","v", 12);
  }

}
