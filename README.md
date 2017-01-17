# dubbo版smvcm系统demo
技术选型：<br /\>
springmvc<br /\>
mybatis<br /\>
mysql<br /\>
dubbo2.5.3(准备转dubbox2.8.4坑)<br /\>
### 工程备注<br /\>
smvcm-facade-users			用户名服务消费者模块<br /\>
smvcm-facade-email			邮件服务消费者模块<br /\>
smvcm-facade-wxmenu			微信公众号菜单服务消费者模块<br /\>
smvcm-service-users			用户名服务服务者模块<br /\>
smvcm-service-email			邮件服务服务者模块<br /\>
smvcm-service-wxmenu		微信公众号菜单服务服务者模块<br /\>
smvcm-common				公共服务、工具类模块<br /\>
smvcm-common-config			公共配置管理服务模块<br /\>
smvcm-common-shiro			权限管理模块<br /\>
smvcm-common-web			web应用通用工具<br /\>
smvcm-web-manager			应用后台管理工程<br /\>

使用zookeper发布服务<br /\>
### 目前已有的RPC服务以及实<br /\>
smvcm-facade-email => smvcm-service-email<br /\>
smvcm-facade-users =>smvcm-service-users<br /\>
smvcm-facade-wxmenu =>smvcm-service-wxmenu<br /\>
### 目前已有的本地服务<br /\>
com.sword.smvcm.service.ConfigService => com.sword.smvcm.service.impl.ConfigServiceImpl<br /\>
集成了第三方的微信SDK<br /\>
weixin-java-mp<br /\>
