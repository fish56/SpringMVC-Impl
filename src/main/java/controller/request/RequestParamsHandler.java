package controller.request;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request/params")
public class RequestParamsHandler {
    @RequestMapping("/int")
    public int intType(@RequestParam int value){
        return value;
    }
    // Integer 和 int最大的区别在于前者允许读取到空值
    @RequestMapping("/Integer")
    public Integer integerType(@RequestParam Integer value){
        return value;
    }
    @RequestMapping("/String")
    public String StringType(@RequestParam String value){
        return value;
    }

    // 将请求体中的Param解析成String数组
    @RequestMapping("/StringArray")
    public Integer StringArrayType(@RequestParam String[] values){
        System.out.println(JSONObject.toJSONString(values));
        return values.length;
    }
}
