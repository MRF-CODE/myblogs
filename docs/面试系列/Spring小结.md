[TOC]

------

#### 什么是spring?

Spring 是一个java 企业级应用的开源开发框架。Spring 主要用来开发java 应用，但是有些扩展是针对构建J2EE 品台的 web 应用。Spring 框架目标是简化java 企业级应用开发，并通过POJO 为基础的编程模型促进良好的编程习惯

#### 使用Spring框架的好处是什么？

- 轻量级
- 面向切面编程
- 容器
- MVC 框架
- 事务管理
- 异常处理

#### Spring由哪些模块组成？

- Core module
- Bean module
- Context module
- Expression Language module
- JDBC module
- ORM module
- OXM module
- Java Messaging Service module
- Transaction module
- Web module
- Web-Servlet module
- Web-Struts module
- Web-Portlet module

#### 核心容器（应用上下文) 模块

这是基本的spring 模块，提供spring 框架的基础功能，BeanFactory 是任何以 spring 为基础的应用的核心。 spring 框架建立在此模块上，它使 spring 称为一个容器。

#### BeanFactory – BeanFactory 实现举例

Bean 工厂是工厂模式的一个实现，提供了控制反转功能，用来把应用的配置和依赖从真正的应用代码中分离。最常用的BeanFactory 实现是XmlBeanFactory.

#### XMLBeanFactory 

最常用的就是org.springframework.beans.factory.xml.XmlBeanFactory , 它根据XML 文件中的定义加载beans。该同期从XML 文件读取配置元数据并用它去创建一个安全配置的系统或应用。

#### 解释AOP模块

AOP 模块用于发给我们的 Spring 应用做面向切面的开发，很多支持由 AOP 联盟提供，这样就确保了 Spring 和 其他 AOP 框架的共通性。这个模块将元数据编程引入 spring 

#### 解释JDBC抽象和DAO模块

通过使用JDBC 抽象和DAO 模块，保证数据库代码的简洁，并能避免数据库资源错误关闭导致的问题，它在各种不同的数据库的错误信息之上，提供了一个统一的异常访问层。它还利用 spring 的AOP 模块给 spring 应用中的对象提供食物管理服务

#### 解释对象/关系映射集成模块

spring 通过提供ORM 模块，支持我们在直接JDBC 之上使用一个对象/ 关系映射映射工具，spring 支持集成主流的ORM 框架，如hibernate。

#### 解释WEB 模块

Spring 的 WEB 模块是构建在 application context 模块基础之上，提供一个适合web 应用的上下文。这个模块也包括支持多种面向 web 的任务，如透明地处理多个文件上传请求和程序级请求参数的绑定到你的业务对象。

#### Spring配置文件

spring 配置文件是个XML 文件，这个文件包含了类信息，描述了如何配置它们，以及如何相互调用。

#### 什么是Spring IOC 容器？

Spring IOC 负责创建对象，管理对象，装配对象，配置对象，并且管理这些对象的整个生命周期。

#### IOC的优点是什么？

IOC 或依赖注入把应用的代码量降到最低。使应用容易测试，单元测试不再需要单利和JNDI 查找机制。最小的代价和最小的侵入性使松散耦合得以实现。IOC 容器支持加载服务时的饿汉式初始化和懒加载

#### ApplicationContext通常的实现是什么？

- l FileSystemXmlApplicationContext ：此容器从一个XML文件中加载beans的定义，XML Bean 配置文件的全路径名必须提供给它的构造函数。

- l ClassPathXmlApplicationContext：此容器也从一个XML文件中加载beans的定义，这里，你需要正确设置classpath因为这个容器将在classpath里找bean配置。

- l WebXmlApplicationContext：此容器加载一个XML文件，此文件定义了一个WEB应用的所有bean。

#### Bean 工厂和 Application contexts  有什么区别？

Application contexts提供一种方法处理文本消息，一个通常的做法是加载文件资源（比如镜像），它们可以向注册为监听器的bean发布事件。另外，在容器或容器内的对象上执行的那些不得不由bean工厂以程序化方式处理的操作，可以在Application contexts中以声明的方式处理。Application contexts实现了MessageSource接口，该接口的实现以可插拔的方式提供获取本地化消息的方法。

#### 一个Spring的应用看起来象什么？

- 一个定义了一些功能的接口
- 这实现包括属性，setter getter 方法和函数等
- spring aop
- spring 的XML 配置文件
- 使用以上功能的客户端程序

#### 什么是Spring的依赖注入？

依赖注入，是IOC 的一个方面，是个通常的概念，它有多种解释。不用创建对象，只需要描述它如何被创建。不在代码里直接组装组件和服务，但是要在配置文件中描述哪些组件需要哪些服务，之后一个容器负责把它们组装起来

#### 有哪些不同类型的IOC（依赖注入）方式？

- 构造器依赖注入：通过容器出发一个类的构造器来实现的，该类有一系列参数，每个参数代表一个对其他类的依赖
- setter 方法注入：setter 方法注入是容器通过调用无参构造器或无参static 工厂方法实例化bean 之后，调用该bean 的setter 方法，即实现了基于 setter 的依赖注入。

#### 哪种依赖注入方式你建议使用，构造器注入，还是 Setter方法注入？

都可以使用，最好是构造器参数实现强制依赖，setter 方法实现可选依赖

#### 什么是Spring beans？

Spring beans 是哪些形成spring 应用的主干的java 对象，他们被spring IOC 容器初始化，装配和管理。这些beans 通过容器中配置的元数据创建。比如，以XML 文件中<bean 的形式定义。

Spring 框架定义的beans 都是单例beans 。 在bean tag 中有个属性 singleton,如果它被赋为TRUE,bean 就是单例，否则就是一个prototype bean。默认是TRUE, 所以所有在Spring 框架中的beans 缺省都是单例。

#### 一个 Spring Bean 定义 包含什么？

一个Spring Bean 的定义包含容器必知的所有配置元数据，包括如何创建一个bean，它的声明周期详情及它的依赖

#### 如何给Spring 容器提供配置元数据？

- XML 配置文件
- 基于注解的配置
- 基于Java 的配置

#### 你怎样定义类的作用域？

当定义一个bean 在spring 里，我们还能给这个bean 声明一个作用域。它可以通过bean 定义中的scope 属性来定义。如，当spring 要在需要的时候每次声场一个新的bean 实例，bean 的scope 属性被指定为prototype ，另一方面，一个 bean 每次使用的时候必须返回同一个实例，这个 bean 的 scope 属性必须设为 singleton

#### 解释Spring支持的几种bean的作用域

- singleton : bean 在每个spring IOC 容器中只有一个实例
- prototype : 一个bean 的定义可以有多个实例
- request : 每次 http 请求都会创建一个 bean ，该作用域仅在基于 web 的spring applicationContext 情形下有效
- session : 在一个 HTTP Session 中，一个 bean 定义对应一个实例，该作用域仅在基于web 的spring applicationContext 情形下有效
- global-session ： 在一个去全局的 HTTP session 中，一个bean 定义对应一个实例，该作用域仅在基于web 的spring ApplicationContext 情形下有效
- 缺省的 spring bean 的作用域是 singleton

#### Spring框架中的单例bean是线程安全的吗？

不是，线程安全的

#### 解释Spring框架中bean的生命周期

Spring容器 从XML 文件中读取bean的定义，并实例化bean。

Spring根据bean的定义填充所有的属性。

如果bean实现了BeanNameAware 接口，Spring 传递bean 的ID 到 setBeanName方法。

如果Bean 实现了 BeanFactoryAware 接口， Spring传递beanfactory 给setBeanFactory 方法。

如果有任何与bean相关联的BeanPostProcessors，Spring会在postProcesserBeforeInitialization()方法内调用它们。

如果bean实现IntializingBean了，调用它的afterPropertySet方法，如果bean声明了初始化方法，调用此初始化方法。

如果有BeanPostProcessors 和bean 关联，这些bean的postProcessAfterInitialization() 方法将被调用。

如果bean实现了 DisposableBean，它将调用destroy()方法。

#### 哪些是重要的bean生命周期方法？ 你能重载它们吗？

有两个重要的bean 生命周期方法，第一个是setup ， 它是在容器加载bean的时候被调用。第二个方法是 teardown  它是在容器卸载类的时候被调用。

The bean 标签有两个重要的属性（init-method和destroy-method）。用它们你可以自己定制初始化和注销方法。它们也有相应的注解（@PostConstruct和@PreDestroy）。

#### 什么是Spring的内部bean？

当一个bean仅被用作另一个bean的属性时，它能被声明为一个内部bean，为了定义inner bean，在Spring 的 基于XML的 配置元数据中，可以在 <property/>或 <constructor-arg/> 元素内使用<bean/> 元素，内部bean通常是匿名的，它们的Scope一般是prototype。

#### 在 Spring中如何注入一个java集合？

<list>类型用于注入一列值，允许有相同的值。

<set> 类型用于注入一组值，不允许有相同的值。

<map> 类型用于注入一组键值对，键和值都可以为任意类型。

<props>类型用于注入一组键值对，键和值都只能为String类型。

#### 什么是bean装配？

装配，或bean 装配是指在 spring 容器中把 bean 组装到一起，前提是容器需要知道bean 的依赖关系，如何通过依赖注入来把它们装配到一起。

#### 什么是bean的自动装配？

spring 容器能够自动装配互相合作的bean，这意味着容器不需要constructor-arg 和 property 配置，能通过 bean 工厂自动处理 bean 之间的协作

#### 解释不同方式的自动装配

- no：默认的方式是不进行自动装配，通过显式设置ref 属性来进行装配。

- byName：通过参数名 自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byname，之后容器试图匹配、装配和该bean的属性具有相同名字的bean。

- byType：通过参数类型自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byType，之后容器试图匹配、装配和该bean的属性具有相同类型的bean。如果有多个bean符合条件，则抛出错误。

- constructor：这个方式类似于byType， 但是要提供给构造器参数，如果没有确定的带参数的构造器参数类型，将会抛出异常。

- autodetect：首先尝试使用constructor来自动装配，如果无法工作，则使用byType方式。

#### 自动装配有哪些局限性？

- 重写：仍然需要用 constructor-arg 和property 配置来定义依赖，意味着总要重写自动装配
- 基本数据类型：不能自动装配简单的属性，比如基本数据类型，String 字符串，和类
- 模糊特性：自动装配不如显式装配精确，建议使用显式装配

#### 你可以在Spring中注入一个null 和一个空字符串吗？

可以

#### 什么是基于Java的Spring注解配置? 给一些注解的例子

基于Java的配置，允许你在少量的Java注解的帮助下，进行你的大部分Spring配置而非通过XML文件。

以@Configuration 注解为例，它用来标记类可以当做一个bean的定义，被Spring IOC容器使用。另一个例子是@Bean注解，它表示此方法将要返回一个对象，作为一个bean注册进Spring应用上下文。

#### 什么是基于注解的容器配置？

相对于XML文件，注解型的配置依赖于通过字节码元数据装配组件，而非尖括号的声明。

开发者通过在相应的类，方法或属性上使用注解的方式，直接组件类中进行配置，而不是使用xml表述bean的装配关系。

#### 怎样开启注解装配？

注解装配在默认情况下是不开启的，为了使用注解装配，我们必须在Spring配置文件中配置 <context:annotation-config/>元素。

#### @Required  注解

这个注解表明bean的属性必须在配置的时候设置，通过一个bean定义的显式的属性值或通过自动装配，若@Required注解的bean属性未被设置，容器将抛出BeanInitializationException。

#### @Autowired 注解

@Autowired 注解提供了更细粒度的控制，包括在何处以及如何完成自动装配。它的用法和@Required一样，修饰setter方法、构造器、属性或者具有任意名称和/或多个参数的PN方法。

#### @Qualifier 注解

当有多个相同类型的bean却只有一个需要自动装配时，将@Qualifier 注解和@Autowire 注解结合使用以消除这种混淆，指定需要装配的确切的bean。

#### 在Spring框架中如何更有效地使用JDBC？

使用spring JDBC 框架，资源管理和错误处理的代价都会被减轻。所以开发者只需写 statements 和 queries 从数据存取数据，JDBC 也可以在spring 框架提供的模板类的帮助下更有效的被使用，这个模板就是JdbcTemplate

#### JdbcTemplate

JdbcTemplate 类提供了很多便利的方法解决诸如吧数据库数据转换成基本数据类型或对象，执行写好的或可调用的数据操作语句，提供自定义的数据错误处理

#### Spring对DAO的支持

spring 对数据访问对象的支持目的是简化它和数据访问技术集合使用。使我们可以方便切换持久层，编码时不用担心会捕获每种技术特有的异常

#### 使用Spring通过什么方式访问Hibernate？

- 控制反转 hibernate template 和 callback
- 继承 HibernateDAOSupport  提供一个AOP 拦截器

#### Spring支持的ORM

- hibernate
- Mybatis
- JPA
- TopLink
- JDO
- OJB

#### 如何通过HibernateDaoSupport将Spring和Hibernate结合起来？

用 Spring 的SessionFactory 调用 LocalSessionFactory。集成过程分三步：

- 配置 the Hibernate SessionFactory
- 继承 HibernateDaoSupport 实现一个DAO
- 在AOP 支持的事务中装配

#### Spring支持的事务管理类型

- 编程式事务管理 : 代码
- 声明式事务管理 : 注解

#### Spring框架的事务管理有哪些优点？

- 它为不同的事务API 如JTA,JDBC,Hibernate,JPA,JDO, 提供了一个不变的编程模式
- 为编程式事务管理提供了一套简单的API 而不是一些复杂的事务API
- 支持声明式事务管理
- 和Spring 各种数据访问抽象层很好得集成

#### 你更倾向用那种事务管理类型？

声明式事务管理，因为它对应用代码的影响最下，更符合一个无侵入的轻量级容器的思想。

声明式事务管理优于编程式事务管理，虽然比编程式事务管理少了一点灵活性。

#### 解释AOP

面向切面的编程，是一种编程技术，允许程序模块化横向切割关注点，或横切典型的责任划分，如日志和事务管理

#### Aspect 切面

AOP 核心就是切面，它将过个类的通用行为封装成可重用的模块，该模块含有一组API 一同横切功能。比如，一个日志模块可以被称为日志的AOP 切面。根据需求的不同，一个应用程序可以有若干个切面。在Spring AOP 中，切面通过带有@Aspect 注解的类实现

#### 在Spring AOP 中，关注点和横切关注的区别是什么？

关注点是应用中一个模块的行为，一个关注点可能会被定义成一个我们想实现的一个功能。

横切关注点是一个关注点，此关注点是整个应用都会使用的功能，并影响整个应用，比如日志，安全和数据传输，几乎应用的每个模块都有需要的功能，因此这些都属于横切关注点。

#### 连接点

连接点代表一个应用程序的某个位置，在这个位置我们可以插入一个AOP 切面，实际上是个应用程序执行spring AOP 的位置

#### 通知

通知是个在方法执行前或执行后要做的动作，实际山是程序执行时要通过SpringAOP 框架出发的代码段。

- before ：前置通知，在一个方法执行前被调用
- after : 在方法执行之后调用的通知，无论方法执行是否成功
- after-returning : 仅当方法成功完成后执行的通知
- after-throwing ：在方法抛出议程退出时执行的通知
- around : 在方法执行之前和之后调用的通知

#### 切点

切入点是一个或一组连接点，通知将在这些位置执行。可以通过表达式或匹配的方式指明切入点

#### 什么是引入？

引入允许我们在已存在的类中增加新的方法和属性

#### 什么是目标对象？

被一个或者多个切面所通知的对象。通常是代理对象。也叫通知对象

#### 什么是代理？

代理是通知目标对象后创建的对象，从客户端角度看，代理对象和目标对象是一样的

#### 有几种不同类型的自动代理？

BeanNameAutoProxyCreator

DefaultAdvisorAutoProxyCreator

Metadata autoproxying

#### 什么是织入。什么是织入应用的不同点？

织入是将切面和其他应用类型或对象连接或创建一个被通知对象的过程。

织入可以在编译时，加载时或运行时完成。

#### 解释基于XML Schema方式的切面实现

在这种情况下，切面由常规类以及基于XML 的配置实现

#### 解释基于注解的切面实现

在这种情况下，涉及到的切面声明的风格与带有java5 标注的普通java 类一致。

#### 什么是Spring的MVC框架？

spring 配备构建web 应用的全功能 MVC 框架。spring 可以很便捷的和其他MVC 框架集成，如Struts，spring 的MVC 框架用控制反转把业务对象和控制逻辑清晰的隔离。它允许以声明的方式把请求参数和业务对象绑定。

#### DispatcherServlet

Spring 的MVC 框架是围绕DispatcherServlet 来设计的，用来处理所有的HTTP 请求和响应

#### WebApplicationContext

WebApplicationContext 继承了ApplicationContext ，并增加了一些WEB 应用必备的功能，不同于一般的ApplicationContext，因为他能处理主题，并找到被关联的servlet.

#### 什么是Spring MVC框架的控制器？

控制器提供一个访问应用程序的行为，此行为通常通过服务接口实现。控制器解析用户输入并将其转换为一个由视图呈现给用户的模型。spring 用一个非常抽象的方式实现了一个控制层，允许用户创建多种用途的控制器。

#### @Controller 注解

表名该类扮演控制器的角色，spring 不需要你继承任何其它控制器基类或引用servlet API

#### @RequestMapping 注解

该注解是用来映射一个URL 到一个类或一个特定的处理方法上

