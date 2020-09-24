### 一道sql 语句：查询学生表中学生姓名相同的名字

```
SELECT DISTINCT sname FROM student WHERE sname IN (SELECT sname FROM student GROUP BY sname HAVING(COUNT(sname)) > 1)
```

### explain

#### id列

id 越大执行执行优先级越高，id 相同依次执行，id 为空最后执行

#### select_type列

- simple: 简单查询
- primary：复杂查询中最外层的子查询
- subquery: 包含在select 中的子查询（不在from 子句中）
- derived: 包含在from 子句中的子查询
- union: 在union 中的第二个和随后的select

#### table列

查询的表

#### type列

查找数据行的大概范围

- system: 是const特例，只有一条数据
- const: 主键
- eq_ref: 根据主键关联，唯一索引
- ref: 不使用唯一索引，使用普通索引或者索引部分前缀
- range: >,< 等范围符号
- index: 全索引扫描
- all: 全表扫描

#### possible_keys列

预估使用的索引

#### key列

真正使用的索引

#### key_len列

使用索引的长度

- 字符串
  - char(n) :　ｎ字节长度
  - varchar(n): 2字节存储字符串长度，如果是utf-8,则长度3n+2
- 数值类型
  - tinyint: 1字节
  - smallint: 2字节
  - int: 4字节
  - bigint: 8字节
- 时间类型
  - date: 3字节
  - timestamp: 4字节
  - datetime: 8字节
- 如果字段允许为NULL,需要1字节记录是否为NULL

索引最大长度为768字节，超过的话会使用最左前缀原则匹配

#### ref列

表查找值中的变量或者列

#### rows列

预估查询结果的行数

#### extra列

- using Index：使用覆盖索引
- using where : 查询的列未被索引覆盖
- using index condition: 查询的列不完全被索引覆盖
- using temporary: mysql 需要创建一张临时表处理查询
- using filesort: 将用外部排序而不是索引排序
- select table optimized away : 使用聚合函数信息

### 索引优化的几个原则

- 不能在索引列上做任何操作，会导致索引失效而转向全表扫描

- 存储引擎不能使用索引中范围条件右侧的列

- 尽量使用覆盖索引，减少select * 语句

- mysql 在使用不等于的时候无法使用索引全表扫描

- is null,is not null 不会走索引

- like 以通配符开头，mysql 索引失效会变成全表扫描

- 字符串不加单引号索引失效