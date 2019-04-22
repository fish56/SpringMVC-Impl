package controller.response;

import entity.Monkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/response/headers")
public class ResponseHeader {

    // 直接通过ResponseEntity设置响应头部
    @RequestMapping("/header1")
    public ResponseEntity setHeader(){
        return ResponseEntity.status(200)
                .header("header1","value1")
                .build();
    }

    // 设置响应头部时，ContentType可以走一个后门
    //   通过注解中的produces来设置
    @RequestMapping(value = "/produces", produces = "text/produces;charset=utf-8")
    public String produces(){
        return "Hello world";
    }
}
