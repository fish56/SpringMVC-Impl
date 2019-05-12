package filter;

import base.AutowiredTest;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class LoggerFilterTest extends AutowiredTest {

    // filter是JavaEE的规范，由Tomcat等服务器管理，这里启动的话不会触发filter
    @Test
    public void doFilter() throws Exception{

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/");

        mockMvc.perform(builder)
                .andDo(MockMvcResultHandlers.print());
    }
}