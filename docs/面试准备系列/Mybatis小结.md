#### #{} 和${} 的区别是什么？

- #{} 采用的是预编译的方式，在处理时，会将SQL 中的#{} 替换为？号，调用preparedStatement 的set 方法来赋值
- ${} 采用的是字符串替换的方式，在处理时，会将${} 之间替换为变量值

#### 通常一个Xml 映射文件，都会写一个 Dao 接口与之对应，请问，这个 Dao 接口的工作原理是什么？Dao 接口里的方法参数不同时，方法能重载吗？

Dao 接口就是我们常说的Mapper 接口，接口的全限定名，就是映射文件中namespace 的值，接口的方法名，就是映射文件中的MappedStatement的id 值，接口方法内的参数，就是sql 的参数值。Mapper 接口是没有实现类的，当调用方法的时候，将全限定名方法名参数作为key 值，可以定位唯一的MappedStatement 。

工作原理：JDK 代理的方式，当Mybatis 运行时会使用JDK 动态代理为Dao 接口生成代理proxy 对象，代理对象会拦截接口方法，转而执行MappedStatement 所代表的sql，然后将sql 执行结果返回。

不能重载，因为是全限定名+方法名的保存和寻找策略。

#### Mybatis 是如何进行分页的？分页插件的原理是什么？

Mybatis 使用RowBounds 对象进行分页，它是针对ResultSet 结果集执行的内存分页，而非物理分页，可以使用带有物理分页的参数来完成物理分页，也可以使用分页插件完成物理分页。

分页插件的基本原理是使用Mybatis 提供的插件接口，实现自定义插件，在插件的拦截方法内拦截待执行的sql，然后重写sql，根据方言dialect，添加对应的物理分页语句和物理分页参数。

#### Mybatis 是如何将Sql 执行接口封装非目标对象并返回的？都有哪些映射形式？

- 使用ResultMap 标签，逐一定义列名和对象属性名之间的映射关系。

- 使用sql 列别名功能，将列别名书写为对象属性名

  有了列名与属性名的映射关系后，Mybatis 通过反射创建对象，同时使用反射给对象的属性逐一赋值并返回，找不到映射关系的属性，无法完成赋值。

#### Xml 映射文件中，除了常见的select|insert|update|delete 标签之外，还有哪些标签？

trim|where|set|foreach|if|choose|when|otherwise|bind 等，通过标签引入sql片段，为不支持自增的主键生成策略标签

#### 简述Mybatis 的插件运行原理，以及如何编写一个插件？

Mybatis 仅可以编写针对ParameterHandler、ResultSetHandler、StatementHandler、Executor 这四种接口的插件，使用动态代理，为需要拦截的接口生成代理对象以实现接口方法拦截功能，每当执行者4种接口对象的方法时，就会进入拦截方法，具体就是 InvocationHandler 的invoke() 方法，当然，只会拦截哪些你执行需要拦截的方法。

实现Mybatis 的Interceptor 接口并复写intercept() 方法，然后给插件编写注解，指定要拦截哪一个接口的哪些方法即可，同时在配置文件中配置插件。

#### 一级、二级缓存

- 一级缓存：基于PerpetualCache 的HashMap 本地缓存，存储作用域为Session, 当Session flush 或close 之后，该session 中的所有 Cache 清空
- 二级缓存与一级缓存的机制相同，不同在于存储作用域为Mapper(Namespace)，并且可自定义存储源，开启二级缓存需要在映射文件中增加cache
- 当作用域中进行了cud 操作后，缓存清空

#### Mybatis 是否支持延迟加载？如果支持，它的实现原理是什么？

Mybatis 仅支持association 关联对象和collection 关联集合对象的延迟加载，association 指的就是一对一，collection 指的就是一对多查询。在Mybatis 配置文件中，可以配置是否启用延迟加载lazyLoadingEnabled.

原理：使用CGLIB创建目标对象的代理对象，当调用目标方法时，进入拦截器方法，比如调用a.getB().getName()，拦截器invoke() 方法发现a.getB()是null值，那么就会单独发送事先保存好的查询关联B 对象的Sql,把B 查询上来，然后调用a.setB(b)，于是a 的对象b 属性就有值了，接着完成a.getB().getName() 方法的调用。这就是延迟加载的基本原理。

#### Mybatis 映射文件中，如果A 标签通过include 引用了B 标签的内容，请问，B 标签能否定义在A 标签的后面，还是说必须定义在A 标签的前面？

虽然Mybatis 解析XML 映射文件是按照顺序解析的，但是，被引用的B 标签依然可以定义在任何地方，Mybatis 都可以正确识别。

原理：mybatis 解析A 标签，发现A 标签引用了B 标签，但是B标签尚未解析到，尚不存在，此时，Mybatis 会将A 标签标记为未解析状态，然后继续解析余下的标签，包含B 标签，待所有标签解析完毕，Mybatis 会重新解析那些被标记未解析的标签，此时在解析A标签时，B 标签已经存在，A 标签也就可以正常解析了。

#### 简述Mybatis 的Xml 映射文件和Mybatis 内部数据结构之前的映射关系？

Mybatis 将所有xml 配置信息都封装到All-In-One 重量级对象Configuration 内部。在Xml 映射文件中，parameterMap 标签会被解析为ParameterMap 对象，其每个子元素会被解析为ParameterMapping 对象。resultMap 标签会被解析为 ResultMap 对象，其每个子元素会被解析为ResultMapping 对象。每一个select、insert、update、delete 标签均会被解析为MappedStatement 对象，标签内的sql 会被解析为BoundSql 对象。

