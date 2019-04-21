package controller.response;

import base.AutowiredTest;
import com.alibaba.fastjson.JSONObject;
import entity.Monkey;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class ResponseStatusTest extends AutowiredTest {
    private static String baseUrl = "/response/status";

    @Test
    public void status404() throws Exception{
        ResultMatcher is404 = MockMvcResultMatchers.status().is(404);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get(baseUrl + "/404");

        mockMvc.perform(builder)
                .andExpect(is404);
    }

    @Test
    public void status302() throws Exception{
        ResultMatcher is302 = MockMvcResultMatchers.status().is(302);
        ResultMatcher haveLocationHeader = MockMvcResultMatchers.
                header().string("Location", "https://www.github.com/fish56");

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get(baseUrl+ "/302");

        mockMvc.perform(builder)
                .andExpect(is302)
                .andExpect(haveLocationHeader);
//        System.out.println(mockMvc.perform(builder).andReturn()
//          .getResponse().getHeaderNames().toString());
    }

    @Autowired
    private Monkey monkey;
    @Test
    public void status201() throws Exception{
        ResultMatcher is201 = MockMvcResultMatchers.status().is(201);
        ResultMatcher msg = MockMvcResultMatchers.content()
                .json(JSONObject.toJSONString(monkey));

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get(baseUrl + "/201");

        mockMvc.perform(builder)
                .andExpect(msg);
    }
}