package controller.response;

import base.AutowiredTest;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class ResponseHeaderTest extends AutowiredTest {
    private static String baseUrl = "/response/headers";

    @Test
    public void setHeader() throws Exception{
        // 确认是否有特定的响应头部，和服务器端一致
        ResultMatcher header1 = MockMvcResultMatchers.header()
                .string("header1","value1");

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get(baseUrl + "/header1");

        mockMvc.perform(builder)
                .andExpect(header1);
    }

    @Test
    public void produces() throws Exception{
        // 确认是否成功设置ContentType
        ResultMatcher contentType = MockMvcResultMatchers.header()
                .string("Content-Type", "text/produces;charset=utf-8");

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get(baseUrl + "/produces");

        mockMvc.perform(builder)
                .andExpect(contentType);
    }
}