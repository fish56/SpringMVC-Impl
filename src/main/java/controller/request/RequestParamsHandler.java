package controller.request;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    // required 默认为true。如果请求中没有，就会抛出异常
    @RequestMapping("/String")
    public String StringType(@RequestParam(required = false) String value){
        return value;
    }

    // 将请求体中的Param解析成String数组
    @RequestMapping("/StringArray")
    public Integer StringArrayType(@RequestParam String[] values){
        System.out.println(JSONObject.toJSONString(values));
        return values.length;
    }

    // 获得请求中的所有参数
    //   直接使用@RequestParam注解，如果SpringMVC
    //   发现这是一个map类型，就会把所有的参数放在这个map里面
    @RequestMapping("/all-params")
    public Map allParams(@RequestParam Map<String, String> map){
        return map;
    }
}
