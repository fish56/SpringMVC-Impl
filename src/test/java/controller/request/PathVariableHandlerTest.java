package controller.request;

import base.AutowiredTest;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class PathVariableHandlerTest extends AutowiredTest {

    @Test
    public void integerType() throws Exception{
        ResultMatcher msg = MockMvcResultMatchers.content()
                .string("3");

        // 对应相应的Controller，应该返回1 + 2；
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch("/request/pathVariable/1/2");

        mockMvc.perform(builder)
                .andExpect(msg);
    }
}