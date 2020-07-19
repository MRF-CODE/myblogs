#### 1、一张表，里面有ID自增主键，当insert了17条记录之后，删除了第15,16,17条记录，再把Mysql重启，再insert一条记录，这条记录的ID是18还是15 ？

表类型为MyISAM 是18，将最大Id 存在了数据文件里，不会丢失

表类型为InnoDB 是15，将最大Id 存在了内存中，会丢失

#### 2、Mysql的技术特点是什么？

Mysql数据库软件是一个客户端或服务器系统，其中包括：支持各种客户端程序和库的多线程SQL服务器、不同的后端、广泛的应用程序编程接口和管理工具。

#### 3、Heap表是什么？

Heap 表存储在内存中，用于临时高速存储

- BLOB 或 TEXT 字段是不允许的
- 只能使用比较运算符=，<,>,=>,<=
- heap 表不支持AUTO_INCREMENT
- 索引不可为 null

#### 4、Mysql服务器默认端口是什么？

3306

#### 5、与Oracle相比，Mysql有什么优势？

- MySQL 是开源软件，随时可用，无需付费
- MySQL 是便携式的
- 带有命令提示符的GUI
- 使用MySQL 查询浏览器支持管理

#### 6、如何区分FLOAT和DOUBLE？

- 浮点数以8 位精度存储在FLOAT 中，并且有四个字节
- 浮点数存储在DOUBLE 中，精度为18 位，有八个字节

#### 7、区分CHAR_LENGTH和LENGTH？

CHAR_LENGTH 是字符数，而LENGTH 是字节数。Latin 字符的这两个数据是相同的，但是对于Unicode 和其他编码，是不同的。

#### 8、请简洁描述Mysql中InnoDB支持的四种事务隔离级别名称，以及逐级之间的区别？

- read uncommited ：读到未提交数据
- read committed ： 脏读，不可重复读
- repeatable read ： 可重复读
- serializable ： 串行事务

#### 9、在Mysql中ENUM的用法是什么？

ENUM 是一个字符串对象，用于指定一组预定义的值，并可在创建表时使用。

Create table size(name ENUM('Smail,'Medium','Large');

#### 10、如何定义REGEXP？

REGEXP 是匹配模式，其中匹配模式在搜索值的任何位置。

#### 11、CHAR和VARCHAR的区别？

- CAHR 和VARCAHR 类型在存储和检索方面有所不同

- CAHR 列长度固定为创建表时声明的长度，长度值范围是1到255

当CHAR 值被存储时，它们被用空格填充到特定长度，检索CHAR 值时需删除尾随空格

#### 12、列的字符串类型可以是什么？

- SET
- BLOB
- ENUM
- CHAR
- TEXT
- VARCHAR

#### 13、如何获取当前的Mysql版本？

select version();

#### 14、Mysql中使用什么存储引擎？

存储引擎称为表类型，数据使用各种技术存储在文件中。

- Storage mechanism
- Locking levels
- Indexing
- Capabilities and functions

#### 15、Mysql驱动程序是什么？

-  PHP驱动程序

-  JDBC驱动程序

-  ODBC驱动程序

-  CWRAPPER

-  PYTHON驱动程序

-  PERL驱动程序

-  RUBY驱动程序

-  CAP11PHP驱动程序

-  Ado.net5.mxj

#### 16、TIMESTAMP在UPDATE CURRENT_TIMESTAMP数据类型上做什么？

创建表是TIMESTAMP 列用zero 更新。只要表中的其他字段发生改变，UPDATE CURRENT_TIMESTAMP修饰符就将时间戳字段更新为当前时间。

#### 17、主键和候选键有什么区别？

表格的每一行都是由主键唯一标识，一个表只能有一个主键。

主键也是候选键。

#### 18、如何使用Unix shell登录Mysql？

\# [mysql dir]/bin/mysql -h hostname -u UserName -p password

#### 19、 myisamchk是用来做什么的？

用来压缩MyISAM 表，减少了磁盘或内存使用

#### 20、MYSQL数据库服务器性能分析的方法命令有哪些?

- show status
- show session status like ‘Select’
- show profiles

#### 21、如何控制HEAP表的最大尺寸？

Heap 表的大小可通过称为max_heap_table_size 的mysql 配置变量来控制

#### 22、MyISAM Static和MyISAM Dynamic有什么区别？

MyISAM Static 上的所有字段有固定宽度。动态MyISAM 表将具有像TEXT,BLOB 等字段，以适应不同长度的数据类型。MyISAM Static 在受损情况下更容易恢复。

#### 23、federated表是什么？

federated 表，允许访问位于其他服务器数据库上的表

#### 24、如果一个表有一列定义为TIMESTAMP，将发生什么？

每当行被更改时，时间戳字段将获取当前时间戳

#### 25、列设置为AUTO INCREMENT时，如果在表中达到最大值，会发生什么情况？

会停止递增，任何进一步的插入都将产生错误，因为秘钥已经被使用

#### 26、怎样才能找出最后一次插入时分配了哪个自动增量？

LAST_INSERT_ID 将返回由Auto——increment 分配的最后一个值，并且不需要指定表名称

#### 27、你怎么看到为表格定义的所有索引？

SHOW INDEX FROM demo

#### 28.、LIKE声明中的％和_是什么意思？

% 对应0个或多个字符，_对应一个字符

SELECT *FROM demo WHERE NAME LIKE '7_____'

#### 29、如何在Unix和Mysql时间戳之间进行转换？

- UNIX_TIMESTAMP() 从mysql 时间戳向unix 时间戳转换
- FROM_UNIXTIME() 从unix 时间戳向mysql 时间戳转换

#### 30、列对比运算符是什么？

=，<>,<=,<,>,=>,<<,>>,<=>,AND,OR,LIKE

#### 31、我们如何得到受查询影响的行数？

- SELECT FOUND_ROWS()
- row_count()
- 暂时没弄清用法

#### 32、Mysql查询是否区分大小写？

不区分大小写

select version(),select VERSION() 没有区别

#### 33、LIKE和REGEXP操作有什么区别？

LIKE 和REGEXP 运算符用于表示^和％。

SELECT * FROM employee WHERE emp_name REGEXP "^b";

SELECT * FROM employee WHERE emp_name LIKE "%b";

#### 34、BLOB和TEXT有什么区别？

BLOB 是一个二进制对象，可以容纳可变数量的数据。有四种类型的BLOB:

- TINYBLOB

- BLOB

- MEDIUMBLOB

- LONGBLOB

它们只能在所能容纳价值的最大长度上有所不同

TEXT 是一个不区分打下写的BLOB. 四种TEXT 类型

- TINYTEXT

- TEXT

- MEDIUMTEXT

- LONGTEXT

#### 35、mysql_fetch_array和mysql_fetch_object的区别是什么？

- mysql_fetch_array : 将结果行作为关联数组或来自 数据库的常规数组返回
- mysql_fetch_object : 从数据库返回结果行作为对象

#### 36、我们如何在mysql中运行批处理模式？

mysql mysql.out

#### 37、MyISAM表格将在哪里存储，并且还提供其存储格式？

每个 MyISAM 表格以三种格式存储在磁盘上：

- “.frm” 文件存储表定义
- 数据文件具有“.MYD”(MYData) 扩展名
- 索引文件具有“.MYI”(MYIndex) 扩展名

#### 38、Mysql中有哪些不同的表格？

- MyISAM
- Heap
- Merge
- INNODB
- ISAM

#### 39、ISAM是什么？

ISAM 简称为索引顺序访问方法。它是由IBM 开发的，用于在磁带等存储系统上存储和检索数据。

#### 40、InnoDB是什么？

InnoDB 是一个由 Oracle 公司开发的Innobase Oy 事务安全存储引擎。

#### 41、Mysql如何优化DISTINCT？

DISTINCT 在所有列上转换为group by ,并与order by 子句结合使用。

select distinct t1.a from t1,t2 where t1.a = t2.a;

#### 42、如何输入字符为十六进制数字？

如果想输入字符为十六进制数字，可以输入带有单引号的十六进制数据和前缀(X),或者只用(ox) 前缀输入十六进制数字。

如果表达式上下文是字符串，则十六进制数字串将自动转换为字符串。

#### 43、如何显示前50行？

select * from table limit 0,50;

#### 44、可以使用多少列创建索引？

16个

#### 45、NOW（）和CURRENT_DATE（）有什么区别？

NOW() 命令用于显示当前年月日时分秒

CURRENT_DATE() 显示年月日

#### 46、什么样的对象可以使用CREATE语句创建？

- DATABASE
- EVENT
- FUNCTION
- INDEX
- PROCEDURE
- TABLE
- TRIGGER
- USER
- VIEW
- TABLE

#### 47、Mysql表中允许有多少个TRIGGERS？

6个。

- BERFORE INSERT
- AFTER INSERT
- BEFORE UPDATE
- AFTER UPDATE
- BEFORE DELETE
- AFTER DELETE

#### 48、什么是非标准字符串类型？

- TINYTEXT
- TEXT
- MEDIUMTEXT
- LONGTEXT

#### 49、什么是通用SQL函数？

- CONCAT(A,B) 
- FORMAT(X,D)
- CURRDATE(),CURRTIME()
- NOW()

#### 50、解释访问控制列表

ACL(访问控制列表) 是与对象关联的权限列表。这个列表是MySQL 服务器安全模式的基础，它有助于排出用户无法连接的问题。

MySQL 将ACL 缓存在内存中。当用户尝试认证或运行命令时，MySQL 会按照预定的顺序检查ACL 的认证信息和权限。

#### 51、MYSQL支持事务吗？

在缺省模式下，mysql 是autocommit 模式的，所有数据库操作会即时提交，所以在缺省模式下不支持事务。

如果mysql 表类型使用InnoDB Tables 或 BDB tables 的话，可以使用事务，使用 set autocommit = 0 就可以使MySQL 允许在非autocommit 模式，在非autocommit 模式下，必须使用commit 提交更改，或者使用rollback 回滚更改

#### 52、 mysql里记录货币用什么字段类型好

NUMERIC 和DECIMAL 类型

#### 53、MYSQL数据表在什么情况下容易损坏？

服务器突然断电导致数据文件损坏，强制关机，没有先关闭mysql 服务等

#### 54、mysql有关权限的表都有哪几个？

user,db,table_priv,columns_priv和host

#### 55、Mysql中有哪几种锁？

MyISAM 支持表锁，InnoDB 支持标所和行锁，默认为行锁

表锁：开销小，加锁快，不会出现死锁。锁粒度大，发生锁冲突概率高，并放量低

行锁：开销大，检锁慢，会出现死锁。锁粒度小，发生锁冲突概率低，并发量高

