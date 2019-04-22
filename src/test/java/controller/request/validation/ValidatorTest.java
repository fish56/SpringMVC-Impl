package controller.request.validation;

import base.AutowiredTest;
import com.alibaba.fastjson.JSONObject;
import entity.Admin;
import entity.User;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

import static org.junit.Assert.*;

public class ValidatorTest extends AutowiredTest {

    @Test
    public void nameLength() throws Exception{
        User user = new User();
        user.setName("abc");

        String userString = JSONObject.toJSONString(user);

        ResultMatcher msg = MockMvcResultMatchers.content()
                .json(userString);

        ResultMatcher is4xx = MockMvcResultMatchers.status().is4xxClientError();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch("/validation/user")
                        .contentType("application/json")
                        .content(userString);

        ResultHandler resultHandler = MockMvcResultHandlers.print();
        // 用户名太短，服务器应该返回400
        mockMvc.perform(builder)
                .andExpect(is4xx)
                .andDo(resultHandler);
    }

    @Test
    public void ageValue() throws Exception{
        User user = new User();
        user.setName("Jon Snow");
        user.setAge(17);

        String userString = JSONObject.toJSONString(user);

        ResultMatcher is4xx = MockMvcResultMatchers.status().is4xxClientError();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch("/validation/user")
                        .contentType("application/json")
                        .content(userString);

        ResultHandler resultHandler = MockMvcResultHandlers.print();
        // 未成年是不行得
        mockMvc.perform(builder)
                .andExpect(is4xx)
                .andDo(resultHandler);
    }

    @Test
    public void phoneNumber() throws Exception{
        User user = new User();
        user.setName("Jon Snow");
        user.setAge(18);
        user.setPhoneNumber("L123456");

        String userString = JSONObject.toJSONString(user);


        ResultMatcher is4xx = MockMvcResultMatchers.status().is4xxClientError();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch("/validation/user")
                        .contentType("application/json")
                        .content(userString);

        ResultHandler resultHandler = MockMvcResultHandlers.print();
        // 电话号码不能有数字的
        mockMvc.perform(builder)
                .andExpect(is4xx)
                .andDo(resultHandler);
    }

    @Test
    public void pastTime() throws Exception{
        User user = new User();
        user.setName("Jon Snow");
        user.setAge(18);
        user.setPhoneNumber("123456");
        Date futureDate = new Date(new Date().getTime() + 100000);
        user.setBirthday(futureDate);

        String userString = JSONObject.toJSONString(user);

        ResultMatcher is4xx = MockMvcResultMatchers.status().is4xxClientError();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch("/validation/user")
                        .contentType("application/json")
                        .content(userString);

        ResultHandler resultHandler = MockMvcResultHandlers.print();
        // 电话号码不能有数字的
        mockMvc.perform(builder)
                .andExpect(is4xx)
                .andDo(resultHandler);
    }

    @Test
    public void admin() throws Exception{
        // 因为服务器的Controller的检验会在选择的是Loose模式，
        // 所以没有年龄不能超过120岁的限制
        Admin admin = new Admin();
        admin.setName("Jon Snow");
        admin.setAge(180);

        String adminString = JSONObject.toJSONString(admin);

        ResultMatcher isOk = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch("/validation/admin")
                        .contentType("application/json")
                        .content(adminString);

        ResultHandler resultHandler = MockMvcResultHandlers.print();

        mockMvc.perform(builder)
                .andDo(resultHandler)
                .andExpect(isOk);
    }
}