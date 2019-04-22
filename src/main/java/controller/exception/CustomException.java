package controller.exception;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class CustomException {
    @RequestMapping
    public void exception() throws Exception{
        throw new RuntimeException("exception1");
    }
}
