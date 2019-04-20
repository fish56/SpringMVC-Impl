package controller;

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

public class RestControllerHandlerTest extends AutowiredTest {
    @Test
    public void map() throws Exception {
        // 响应的状态码为200
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();

        // 和RestController的写法呼应，返回值需要将map转化为JSON格式。
        // 但是Object转JSON可能会出现顺序不一致，
        //   所以只能在只有一个字段的情况下使用下面的方式
        Map map = new HashMap();
        map.put("name", "Jon");
        ResultMatcher msg = MockMvcResultMatchers.content()
                .string(JSONObject.toJSONString(map));

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/rest/map");

        mockMvc.perform(builder)
                .andExpect(ok)
                .andExpect(msg);
    }

    @Test
    public void list() {
    }
}