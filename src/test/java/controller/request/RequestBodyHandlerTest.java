package controller.request;

import base.AutowiredTest;
import com.alibaba.fastjson.JSONObject;
import entity.Monkey;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class RequestBodyHandlerTest extends AutowiredTest {
    @Autowired
    Monkey monkey;

    @Test
    public void monkeyType() throws Exception {
        // 发送monkey的JSON格式字符串
        // 期待服务器能够正常的返回
        String monkeyString = JSONObject.toJSONString(monkey);

        ResultMatcher msg = MockMvcResultMatchers.content()
                .json(monkeyString);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch("/request/body/monkey")
                        .contentType("application/json")
                        .content(monkeyString);

        mockMvc.perform(builder)
                .andExpect(msg)
                .andDo(MockMvcResultHandlers.print());
    }
}