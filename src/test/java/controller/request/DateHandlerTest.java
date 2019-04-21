package controller.request;

import base.AutowiredTest;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class DateHandlerTest extends AutowiredTest {
    private static String baseUrl = "/request/date/";

    @Test
    public void dateValue() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("MMddyyyy");
        final String dateString = "10101911";
        Date date = format.parse(dateString);

        ResultMatcher msg = MockMvcResultMatchers.content()
                .string(date.toString());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get(baseUrl + "MMddyyyy?since=" + dateString);

//        String res = mockMvc.perform(builder)
//                .andReturn().getResponse().getContentAsString();
//        System.out.println(res);

        mockMvc.perform(builder)
                .andExpect(msg);

    }

    @Test
    public void dateExactValue() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        final String dateString = "1996-10-10-11-11-11";
        Date date = format.parse(dateString);

        ResultMatcher msg = MockMvcResultMatchers.content()
                .string(date.toString());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get(baseUrl + "yyyy-MM-dd-HH-mm-ss?since=" + dateString);

        mockMvc.perform(builder)
                .andExpect(msg);
    }
}