## redis学习总结

### 一. redis是什么？
redis是一个支持分布式的，面向kv结构的内存数据库。可以作为mysql的一个补充，缓存一些不经常变化的数据。
官方定义：Redis是一个开源的、基于内存的数据结构存储器，可以用作数据库、缓存和消息中间件。


### 二. es的数据结构
redis的值的类型有：STRING(字符串)，LIST(列表)，SET(集合)，HASH(散列表)，ZSET(有序集合)


### 三. 分布式集群架构




### 六. api介绍
- STRING(字符串):get set del
- LIST(列表):lpush,rpush,lpop,rpop,lindex,lrange
- SET(集合):sadd,srem,sismember,smembers,
- HASH(散列表):像一个微缩版的redis(HashMap):hget,hset,hdel,hgetall
- ZSET(有序集合):和散列表一样存储键值对，但是值必须为浮点数,它是唯一一个既可以根据成员来访问元素，又可以根据分值和分值的排列顺序来访问元素的结构：zadd,zrange,zrangebyscore,zrem,zinterstore(zset交集，score为各个score之和)

### 七. redis的其他用法。

redis如何实现分布式锁?

redis如何实现事务?

redis如何实现消息队列?

redis如何实现延时队列?


### 七. 其他重要问题。

如何解决缓存穿透？

如何解决缓存雪崩？