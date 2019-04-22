package controller.request.validation;

import base.AutowiredTest;
import com.alibaba.fastjson.JSONObject;
import entity.User;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class UserValidationTest extends AutowiredTest {

    @Test
    public void nameNotNull() throws Exception{
        User user = new User();
        user.setAge(18);

        String userString = JSONObject.toJSONString(user);

        ResultMatcher msg = MockMvcResultMatchers.content()
                .json(userString);

        ResultMatcher is4xx = MockMvcResultMatchers.status().is4xxClientError();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch("/validation/user")
                        .contentType("application/json")
                        .content(userString);

        mockMvc.perform(builder)
                .andExpect(is4xx);
    }
}