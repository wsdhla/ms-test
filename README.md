# Spring Cloud 开发环境搭建demo

#### 工程说明
+ ms-test  *<font color=gray>聚合工程</font>*
+ ms-test-parent  *<font color=gray>父工程</font>*
+ ms-test-eureka-s  *<font color=gray>注册中心模块</font>*
+ ms-test-config-s  *<font color=gray>配置中心模块</font>*
+ ms-test-eureka-c-p  *<font color=gray>服务提供者模块</font>*
+ ms-test-eureka-c-c  *<font color=gray>服务消费者模块</font>*



### 配置中心三个节点
+ node1
+ node2
+ node3

启动配置中心服务：  
java -jar xxxx.jar --spring.profiles.active=node1  
java -jar xxxx.jar --spring.profiles.active=node2  
java -jar xxxx.jar --spring.profiles.active=node3  


curl -X POST http://localhost:8181/actuator/refresh
curl -X POST http://localhost:8080/actuator/busrefresh