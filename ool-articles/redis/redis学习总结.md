## redis学习总结

### 一. redis是什么？
redis是一个支持分布式的，面向kv结构的内存数据库。可以作为mysql的一个补充，缓存一些不经常变化的数据。
官方定义：Redis是一个开源的、基于内存的数据结构存储器，可以用作数据库、缓存和消息中间件。


### 二. es的数据结构
redis的值的类型有：STRING(字符串)，LIST(列表)，SET(集合)，HASH(散列表)，ZSET(有序集合)

redis的数据结构的实现：
- 字符串使用SDS（simple dynamic string）：增加了size和free冗余，提前分配更多的内存，使得字符串变化时执行更少操作。同时使得有些操作O(1),如取长度。
- dict字典结构，和java一样，使用数组+链表的方式实现。不过redis的实现带有两个hash表，使得扩容和收容时rehash可以渐进式操作，把rehash操作平摊到每次操作中。
- 跳跃表（skiplist）:redis的sorted set使用改进的skiplist来实现：增加跨度span来实现排位rank的计算.

redis通过数据结构来实现一个对象系统，之后通过对象系统实现数据库。对象的类型有字符串、列表、集合、散列表、有序集合这五种。使用对象的好处是可以针对不同的使用场景，为对象设置不同的数据结构，从而优化效率。对象中与保存数据相关的三个属性分别是type（类型）,encoding（使用的数据结构）,ptr（指向底层数据结构的指针）。
类型和数据结构的对应关系：
- string 	: int,embstr,raw
- list		: ziplist,linkedlist
- hash		: ziplist,ht
- set		: intset,ht
- zset		: ziplist,skiplist

75
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