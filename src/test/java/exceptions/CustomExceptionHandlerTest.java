package exceptions;

import base.AutowiredTest;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class CustomExceptionHandlerTest extends AutowiredTest {

    @Test
    public void resolveException() throws Exception{

        ResultMatcher is599 = MockMvcResultMatchers
                .status().is(599);

        // 这个路由的控制器会抛出异常，期望exceptionHandler能够
        //   处理这个异常，并且返回599状态码
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/exception");

        mockMvc.perform(builder)
                .andExpect(is599);
    }
}