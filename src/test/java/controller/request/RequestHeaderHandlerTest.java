package controller.request;

import base.AutowiredTest;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class RequestHeaderHandlerTest extends AutowiredTest {

    @Test
    public void getHeader() throws Exception{
        String value1 = "value1";

        ResultMatcher msg = MockMvcResultMatchers.content()
                .string(value1);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/request/headers/header1")
                .header("header1", value1);

        mockMvc.perform(builder)
                .andExpect(msg);
    }

    @Test
    public void getHeaders() throws Exception{
        String value1 = "value1";

        ResultMatcher msg = MockMvcResultMatchers.content()
                .string(value1);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/request/headers")
                        .header("header1", value1);

        mockMvc.perform(builder)
                .andExpect(msg);
    }
}