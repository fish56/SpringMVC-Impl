# Spring Test For Web

我们可以通过
RealTest --> AutowiredTest --> BaseTest 的方式来继承环境配置

每个mock测试都有三个核心部分
- ResultMatcher

  检验返回值是否符合特定的要求
  
- MockHttpServletRequestBuilder

  用来构造一个HTTP请求
  
- mockMvc.perform(builder)
  
  执行测试，perform发起请求
  
  - .andExpect(status)
    andExpect来确认结果
    
  - .andDo()
    做一些处理，一般是print