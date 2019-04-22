package controller.router;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routers")
public class RequestMappingHandler {
    @RequestMapping("/router1")
    public String router1(){
        return "router1";
    }

    // 只处理GET方法的请求
    @RequestMapping(value = "/router2", method = RequestMethod.GET)
    public String router2(){
        return "router2";
    }

    // 同时管理多个路由
    //   通过PathVariable也可以做到
    @RequestMapping(value = {"/router3", "/router4"})
    public String multipleRouters(){
        return "34";
    }
}
