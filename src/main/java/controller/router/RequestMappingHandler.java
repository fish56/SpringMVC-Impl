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
    @RequestMapping(value = "/router2", method = RequestMethod.GET)
    public String router2(){
        return "router2";
    }
}
