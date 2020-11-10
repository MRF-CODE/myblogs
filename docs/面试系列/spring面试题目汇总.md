- BeanFactory 和ApplicationContext有什么区别

  BeanFactory 是一个含有bean 的工厂类，是spring 里面最底层的接口,是延迟加载的，如果bean 没有被注入，则在第一次调用getBean() 方法的时候会抛出异常；ApplicationContext 的父类是BeanFactory, 在启动的时候就将所有的bean加载了，此外还提供了国际化，统一资源读取等功能

- BeanFactory 和FactoryBean有什么区别

  BeanFactory 是管理bean的工厂，FactoryBean 本质上是一个bean,但是这个bean有点特殊，是一种定制实例化bean的方式，通过实现FactoryBean，完成自定义的bean实例化细节

- Spring 声明周期

  - 找到配置文件中的定义
  - 创建bean实例
  - 实现了*.aware 接口调用对应的方法，比如BeanNameAware,则调用setBeanName*( )方法
  - BeanPostProcesser ,InitializingBean 接口
  - DisposableBean 接口，destory() 方法
  - destory-method 

- 地方

- 地方

- 地方

- 地方

- 地方

- 地方

- 地方

- 按时f撒旦法

- sad

- 