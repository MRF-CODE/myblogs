### SpringCloud Alibaba-Nacos 

#### nacos 下载地址

链接：https://pan.baidu.com/s/1PiT9vQeNK4EgECC31FES4Q 
提取码：mkxa

#### 启动nacos

- 双击bin 中的startup.cmd 文件

- 访问 http://localhost:8848/nacos/

- 使用默认的nacos/nacos 登录

#### 将微服务注册到nacos 中

1. 修改pom.xml 文件，引入 Nacos Discovery Starter

   ```
   <dependency>
               <groupId>com.alibaba.cloud</groupId>
               <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
           </dependency>
   ```

2. 配置nacos 的注册地址

   ```
   cloud:
       nacos:
         discovery:
           server-addr: 127.0.0.1:8848
   ```

3. 使用@EnableDiscoveryClient 开启服务的注册发现功能

4. 配置自己的名字

   ```
   application:
       name: gulimall-coupon
   ```

#### 如何使用Nacos作为配置中心统一管理配置

引入依赖

```
<dependency>
<groupId>com.alibaba.cloud</groupId>
<artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
```

创建一个bootstrap.properties

```
spring.application.name=gulimall-coupon
spring.cloud.nacos.config.server-addr=127.0.0.1:8848
```

需要给配置中心默认添加一个叫 数据集（Data Id）gulimall-coupon.properties。默认规则，应用名.properties

给 应用名.properties 添加任何配置

动态获取配置。

- @RefreshScope：动态获取并刷新配置

- @Value("${配置项的名}")：获取到配置。

- 如果配置中心和当前应用的配置文件中都配置了相同的项，优先使用配置中心的配置。

### spring feign

远程调用别的服务流程

1. 引入open-feign

   ```
   <dependency>
               <groupId>org.springframework.cloud</groupId>
               <artifactId>spring-cloud-starter-openfeign</artifactId>
           </dependency>
   ```

2. 编写一个接口，告诉SpringCloud 这个接口需要调用远程服务

   1）声明接口的每一个方法都是调用哪个远程服务的哪个请求

   ```
   @FeignClient("gulimall-coupon")
   public interface CouponFeignService {
   
       @RequestMapping("/coupon/coupon/member/list")
       public R membercoupons();
   
   }
   ```

3. 开启远程调用功能

   ```
   @EnableFeignClients(basePackages = "com.atguigu.gulimall.member.feign")
   ```

   

