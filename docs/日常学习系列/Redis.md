#### Redis 常见数据结构以及常用场景分析

- String

常用命令set,get,decr,incr,mget 等，常规应用：微博数，粉丝数等

- Hash

常用命令hget,hset,hgetall 等，可以以hash 数据结构存储用户信息，商品信息等

- List

常用命令lpush,rpush,lpop,rpop,lrange 等，微博的关注列表，粉丝列表，消息列表等功能

-  Set

sadd,spop,smembers,sunion,sinterstore等，共同关注，共同粉丝，共同喜好等功能

- Sorted Set

zadd,zrange,zrem,zcard 等，在直播系统中，实时排行信息包含直播间在线用户列表，各种礼物排行榜，弹幕消息等

#### Redis设置过期时间

- 定期删除

  默认每隔100ms随机抽取设置了过期时间的key,如果过期就删除

- 惰性删除

  定期删除没有删除掉的数据在访问的时候会进行判断删除

  由于设置过期时间不能完全的保证数据一定会被清除所以引入了Redis 内存淘汰机制

#### Redis内存淘汰机制

redis 提供6中数据淘汰策略

1. volatile-lru:从已设置过期时间的数据集中挑选最近最少使用的数据淘汰
2. volatile-ttl:从已设置过期时间的数据集中挑选将要过期的数据淘汰
3. volatile-random:从已设置过期时间的数据集中任意选择数据淘汰
4. allkeys-lru:当内存不足以容纳新写入数据时，在键空间中，移除最近最少使用的key(常用)
5. allkeys-random:从数据集中任意选择数据淘汰
6. no-eviction:禁止驱逐数据，也就是说当内存不足以容纳新写入数据时，新写入数据报错

4.0 版本以后增加两种

​	volatile-lfu:从已设置过期时间的数据集中挑选最不经常使用的数据淘汰

​	allkeys-lfu:当内存不足以容纳新写入数据时，在键空间中，移除最不经常使用的key

