package controller.router;

import base.AutowiredTest;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class GetMappingHandlerTest extends AutowiredTest {

    @Test
    public void get() throws Exception{
        ResultMatcher msg = MockMvcResultMatchers.content()
                .string("get");
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/routers/get");

        mockMvc.perform(builder)
                .andExpect(msg);
    }
}