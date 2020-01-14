//package jedis;
//
//
//import jedis.util.JedisPoolUtils;
//import org.junit.Test;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//public class JedisTest {
//    /**
//     * jedis连接池的使用
//     */
//
//    @Test
//    public void test() {
//
////        //0.创建一个配置对象
////        JedisPoolConfig config = new JedisPoolConfig();
////        config.setMaxTotal(50);//最大连接数目
////        config.setMaxIdle(10);//最大空闲连接
////
////
////        //1.创建Jedis连接池对象
////        //  JedisPool jedisPool=new JedisPool();
////        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
////        //2.获取连接
////        Jedis jedis = jedisPool.getResource();
//
//        //通过连接池工具类获取
//        Jedis jedis=JedisPoolUtils.getJedis();
//        //3.使用
//        jedis.set("hehe", "haha");
//        //4.关闭连接池
//        jedis.close();
//
//    }
//}
