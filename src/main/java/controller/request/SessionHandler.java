package controller.request;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

// 这里的session到底是怎么玩的啊。。。。
@RestController
@RequestMapping("/request/session")
@SessionAttributes({"username"})
public class SessionHandler {
    @RequestMapping("/set")
    public void set(Map<String, String> map){
        map.put("username", "Jon");
    }
    @RequestMapping("/get")
    public String get(Map<String, String> map){
        return map.get("username");
    }
}
