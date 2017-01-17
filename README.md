# dubbo版smvcm系统demo
===================================
技术选型：
springmvc
mybatis
mysql
dubbo2.5.3(准备转dubbox2.8.4坑)
### 工程备注
smvcm-common-web web应用通用工具
smvcm-web-manager 应用后台管理工程

使用zookeper发布服务
### 目前已有的RPC服务以及实
smvcm-facade-email => smvcm-service-email
smvcm-facade-users =>smvcm-service-users
smvcm-facade-wxmenu =>smvcm-service-wxmenu
### 目前已有的本地服务
com.sword.smvcm.service.ConfigService => com.sword.smvcm.service.impl.ConfigServiceImpl
集成了第三方的微信SDK
weixin-java-mp
