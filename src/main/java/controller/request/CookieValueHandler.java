package controller.request;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request/cookie")
public class CookieValueHandler {
    // 获得cookie的值，并且返回
    @RequestMapping
    public String cookieValue(@CookieValue String key1){
        return key1;
    }
}
