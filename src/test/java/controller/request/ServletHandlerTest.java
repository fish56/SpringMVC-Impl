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
        ResultMatcher status = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/request/servlet");

        // 成功的使用原生的Servlet
        mockMvc.perform(builder)
                .andExpect(status);
    }
}