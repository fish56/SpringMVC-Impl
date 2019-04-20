package controller.response;

import entity.Monkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// SpringMVC会将Object、Map、List转化为JSON格式的字符串

@RestController
@RequestMapping("/response/rest")
public class RestResponseBody {
    @Autowired
    private Monkey monkey;

    @Autowired
    private Map map;

    @Autowired
    private List list;

    @RequestMapping("/object")
    public Monkey object(){
        return monkey;
    }

    @GetMapping("/map")
    public Map map(){
        return map;
    }

    @GetMapping("/list")
    public List<String> list(){
        return list;
    }
}
