package controller.request;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

// SpringMVC 支持原生的Servlet API
@RestController
@RequestMapping("/request/servlet")
public class ServletHandler {
    @RequestMapping
    public void servlet(HttpServletRequest request, HttpServletResponse response){
        response.setStatus(201);
    }

    // SpringMVC 也能帮我们提取request，response中的属性
    //   比如InputStream，OutputStream
    @RequestMapping("/is-os")
    public void inputStream(InputStream is, OutputStream os) throws Exception{
        byte[] bytes = new byte[100];
        int length;
        while ((length = is.read(bytes)) != -1) {
            os.write(bytes, 0, length);
        }
    }
}
