package controller.request;

import base.AutowiredTest;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.http.Cookie;

import static org.junit.Assert.*;

public class CookieValueHandlerTest extends AutowiredTest {

    @Test
    public void cookieValue() throws Exception{
        ResultMatcher msg = MockMvcResultMatchers.content()
                .string("value1");

        Cookie cookie = new Cookie("key1", "value1");

        // 判断服务器是否读取到了cookie的值
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch("/request/cookie")
                .cookie(cookie);

        mockMvc.perform(builder)
                .andExpect(msg);
    }
}