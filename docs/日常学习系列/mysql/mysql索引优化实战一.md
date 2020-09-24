使用trace工具查看mysql最终是否走索引

### 优化总结：

1、MySQL支持两种方式的排序filesort和index，Using  index是指MySQL扫描索引本身完成排序。index 效率高，filesort效率低。

2、order by满足两种情况会使用Using index。

1) order by语句使用索引最左前列。

2) 使用where子句与order by子句条件列组合满足索引最左前列。

3、尽量在索引列上完成排序，遵循索引建立（索引创建的顺序）时的最左前缀法则。   4、如果order by的条件不在索引列上，就会产生Using filesort。

5、能用覆盖索引尽量用覆盖索引

6、group by与order by很类似，其实质是先排序后分组，遵照索引创建顺序的最左前缀法则。对于group by的优化如果不需要排序的可以加上***\*order\**** ***\*by\**** ***\*null禁止排序\****。注意，where高于having，能写在where中的限定条件就不要去having限定了。