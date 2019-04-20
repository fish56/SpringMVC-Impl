package controller.request;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// SpringMVC 支持原生的
@RestController
@RequestMapping("/request/servlet")
public class ServletHandler {
    @RequestMapping
    public void servlet(HttpServletRequest request, HttpServletResponse response){
    }
}
