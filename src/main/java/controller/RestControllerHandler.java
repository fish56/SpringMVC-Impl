package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestControllerHandler {
    // 将Map类型的返回值自动转换为JSON字符串
    @GetMapping("/rest/map")
    public Map map(){
        Map map = new HashMap();
        map.put("name", "Jon");
        return map;
    }

    @GetMapping("/rest/list")
    public List list(){
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        return list;
    }
}
