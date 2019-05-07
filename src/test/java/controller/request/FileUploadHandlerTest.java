package controller.request;

import base.AutowiredTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class FileUploadHandlerTest extends AutowiredTest {

    @Test
    public void html() throws Exception{
        ResultMatcher is200 = MockMvcResultMatchers.status().is(200);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/request/fileupload");

        mockMvc.perform(builder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(is200);
    }

    // 模拟文件上传
    //   https://stackoverflow.com/questions/21800726
    @Test
    public void upload() throws Exception{
        MockMultipartFile firstFile = new MockMultipartFile("file1", "filename.txt", "text/plain", "some xml".getBytes());
        MockMultipartFile secondFile = new MockMultipartFile("file2", "other-file-name.data", "text/plain", "some other type".getBytes());
        MockMultipartFile jsonFile = new MockMultipartFile("file", "", "application/json", "{\"json\": \"someValue\"}".getBytes());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart("/request/fileupload")
                .file(firstFile)
                .file(secondFile)
                .file(jsonFile)
                .param("some-random", "4"))
                .andDo( MockMvcResultHandlers.print())
                .andReturn();
        String res = result.getResponse().getContentAsString();
        assertEquals("{\"json\": \"someValue\"}", res);
    }
}