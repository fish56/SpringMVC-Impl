package interceptor;

import base.AutowiredTest;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class CorsTest extends AutowiredTest {

    @Test
    public void preHandle() throws Exception{
        ResultMatcher cOrigin = MockMvcResultMatchers
                .header().string("Access-Control-Allow-Origin","*");

        // 这个路由的控制器会抛出异常，期望exceptionHandler能够
        //   处理这个异常，并且返回599状态码
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/");

        mockMvc.perform(builder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(cOrigin);
    }

    @Test
    public void postHandle() throws Exception{
        ResultMatcher cOrigin = MockMvcResultMatchers
                .header().string("Access-Control-Allow-Methods","*");

        // 这个路由的控制器会抛出异常，期望exceptionHandler能够
        //   处理这个异常，并且返回599状态码
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/");

        mockMvc.perform(builder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(cOrigin);
    }

    @Test
    public void afterCompletion() throws Exception{
        ResultMatcher cOrigin = MockMvcResultMatchers
                .header().string("Access-Control-Allow-Headers","*");

        // 这个路由的控制器会抛出异常，期望exceptionHandler能够
        //   处理这个异常，并且返回599状态码
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/");

        mockMvc.perform(builder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(cOrigin);
    }
}