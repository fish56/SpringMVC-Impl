package controller.request;

import base.AutowiredTest;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class SessionHandlerTest extends AutowiredTest {

    @Test
    public void get() throws Exception{
        ResultMatcher resultMatcher = MockMvcResultMatchers.content()
                .string("Jon");

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/request/session/set");
        mockMvc.perform(builder);

        MockHttpServletRequestBuilder builder2 =
                MockMvcRequestBuilders.get("/request/session/get");
        mockMvc.perform(builder2)
               .andExpect(resultMatcher);
    }
}