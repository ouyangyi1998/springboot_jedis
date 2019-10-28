# springboot_jedis
jedis对于redis进行操作，jedis类似于redisTemplate
- 项目来自github @jwwam的入门代码 感谢
- 通过jedis进行操作，不需要重写redisTemplate
- user需要继承序列化接口 implements Serializable 才能进行序列化和反序列化操作
- redisUtil select()可以实现对redis进行分库set的操作 在redisConstant中定义好，每个库是实际需要数据
- 序列化和反序列化就是对于object和byte[]之间进行操作

