package controller.request;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 读取请求头中的数据
@RestController
@RequestMapping("/request/headers")
public class RequestHeaderHandler {
    @RequestMapping("/header1")
    public String getHeader(@RequestHeader String header1){
        return header1;
    }

    @RequestMapping
    public String getHeaders(@RequestHeader HttpHeaders headers){
        // 将headers中的header1这个头部返回给用户
        return headers.get("header1").get(0);
    }
}
