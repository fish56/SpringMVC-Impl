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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RestResponseBodyTest extends AutowiredTest {
    private static String baseUrl = "/response/rest";

    @Autowired
    Monkey monkey;

    @Autowired
    Map map;

    @Autowired
    List list;

    @Test
    public void object() throws Exception{
        ResultMatcher msg = MockMvcResultMatchers.content()
                .json(JSONObject.toJSONString(monkey));

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(baseUrl + "/object");

        mockMvc.perform(builder)
                .andExpect(msg);
    }

    @Test
    public void map() throws Exception {
        ResultMatcher msg = MockMvcResultMatchers.content()
                .string(JSONObject.toJSONString(map));
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(baseUrl + "/map");

        mockMvc.perform(builder)
                .andExpect(msg);
    }

    @Test
    public void list() throws Exception {
        ResultMatcher msg = MockMvcResultMatchers.content()
                .string(JSONObject.toJSONString(list));
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(baseUrl + "/list");

        mockMvc.perform(builder)
                .andExpect(msg);
    }
}