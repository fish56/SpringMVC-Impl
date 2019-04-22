# SpringMVC Impl

### 程序的流程

之前看代码看着看着就晕了，不知道从哪里开始

其实每个webapp都是开始于WEB-INF/web.xml。

web.xml

  -> SpringMVC 核心配置文件
  
  -> 相关的bean
  
  -> 被自动扫描的包
  
可以按照这个顺序阅读

### 参数绑定

整个框架就是基于Servlet的，而SpringMVC最舒服的一点就是能够
更具路由函数的需要，自动的传递相关的数据。处理JSON的时候，
比JS还要舒服。

### 参数校验

- 添加依赖
- 配置检验器
- 在xml中注册

### 依赖
好多依赖都是Provide依赖，需要自己找。。。
服了