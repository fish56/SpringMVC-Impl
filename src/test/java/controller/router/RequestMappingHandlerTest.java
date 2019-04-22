package controller.router;

import base.AutowiredTest;
import base.BaseTest;
import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RequestMappingHandlerTest extends AutowiredTest {

    @Test
    public void router1() throws Exception{

        ResultMatcher msg = MockMvcResultMatchers.content()
                .string("router1");

        // Request Mapping 可以匹配GET POST PATCH 等方法
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.patch("/routers/router1");

        mockMvc.perform(builder)
                .andExpect(msg);
    }

    @Test
    public void router2() throws Exception{
        ResultMatcher methodNotAllowed = MockMvcResultMatchers.status().isMethodNotAllowed();

        // 因为设置了RequestMethod，所以这个方法会返回405状态码, 代表 method not allow
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.patch("/routers/router2");

        mockMvc.perform(builder)
                .andExpect(methodNotAllowed);
    }

    @Test
    public void multipleRouters() throws Exception{
        ResultMatcher isOk = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder builder3 =
                MockMvcRequestBuilders.patch("/routers/router3");
        MockHttpServletRequestBuilder builder4 =
                MockMvcRequestBuilders.patch("/routers/router4");

        mockMvc.perform(builder3)
                .andExpect(isOk);
        mockMvc.perform(builder4)
                .andExpect((isOk));
    }
}