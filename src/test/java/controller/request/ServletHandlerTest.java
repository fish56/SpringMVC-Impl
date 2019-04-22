package controller.request;

import base.AutowiredTest;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class ServletHandlerTest extends AutowiredTest {

    @Test
    public void servlet() throws Exception{
        ResultMatcher status = MockMvcResultMatchers.status().is(201);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/request/servlet");

        // 成功的使用原生的Servlet
        mockMvc.perform(builder)
                .andExpect(status);
    }

    @Test
    public void inputStream() throws Exception{
        String msg = "hello world";

        ResultMatcher resultMatcher = MockMvcResultMatchers.content()
                .string(msg);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/request/servlet/is-os")
                .content(msg);

        // 服务器读取请求体并原样返回
        mockMvc.perform(builder)
                .andExpect(resultMatcher);
    }
}