package controller.request;

import base.AutowiredTest;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collection;

import static org.junit.Assert.*;

public class SessionHandlerTest extends AutowiredTest {

    @Test
    public void get() throws Exception{
        // 返回的响应报文中确实 有session
        //   测试用例返回值中没有找到session id？

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/request/session/set")
                .param("username", "Jon")
                .param("password", "123456");
    }
}