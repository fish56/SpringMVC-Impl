package controller.request;

import base.AutowiredTest;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RequestParamsHandlerTest extends AutowiredTest {
    private static String baseUrl = "/request/params/";

    @Test
    public void intType() throws Exception{
        ResultMatcher msg = MockMvcResultMatchers.content()
                .string("1");

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch(baseUrl + "int")
                        .param("value", "1");
        // 拼接后的URL： /request/params/int?value=1

        mockMvc.perform(builder)
                .andExpect(msg);
    }

    // 因为读取参数时是Integer，所以它允许空值
    @Test
    public void integerType() throws Exception {
        ResultMatcher msg = MockMvcResultMatchers.content()
                .string("1");

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch(baseUrl + "Integer");
        // 拼接后的URL： /request/params/Integer
        // 因为Controller没有读取到数据，所以会返回空的响应体

        ResultActions resultActions = mockMvc.perform(builder);
        MvcResult result = resultActions.andReturn();
        String res =result.getResponse().getContentAsString();
        Assert.assertEquals("", res);
    }

    @Test
    public void stringType() {
    }

    @Test
    public void stringArrayType() throws Exception{
        ResultMatcher msg = MockMvcResultMatchers.content()
                .string("2");

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get(baseUrl + "StringArray?values=v1&values=v2");

        mockMvc.perform(builder)
                .andExpect(msg);
    }

    @Test
    public void allParams() throws Exception{
        // 服务器读取所有参数并返回

        // 服务器应该读取所有参数而不用知道参数的key
        //   所以这里使用了一个随机字符串作为key
        String randomKey = RandomStringUtils.randomAlphabetic(10);

        Map<String, String> map = new HashMap<String, String>();
        map.put("k1", "v1");
        map.put(randomKey, "v2");

        ResultMatcher msg = MockMvcResultMatchers.content()
                .json(JSONObject.toJSONString(map));

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get(baseUrl + "all-params")
                .param("k1", "v1")
                .param(randomKey, "v2");

        mockMvc.perform(builder)
                .andExpect(msg);
    }
}