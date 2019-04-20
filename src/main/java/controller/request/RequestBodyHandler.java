package controller.request;

import com.alibaba.fastjson.JSONObject;
import entity.Monkey;
import org.springframework.web.bind.annotation.*;

// 读取请求体中的数据
// 和requestParams用发基本一致，这里主要将JSON转化为POJO
@RestController
@RequestMapping("/request/body")
public class RequestBodyHandler {

    @RequestMapping("/monkey")
    public Monkey MonkeyType(@RequestBody Monkey monkey){
        return monkey;
    }
}
