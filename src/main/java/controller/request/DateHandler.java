package controller.request;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

// 参数绑定可以按照特定的格式
//   解析日期类型
@RestController
@RequestMapping("/request/date")
public class DateHandler {
    // 将数据转化为时间类型
    @RequestMapping("/MMddyyyy")
    public String dateValue(@RequestParam @DateTimeFormat(pattern="MMddyyyy") Date since){
        System.out.println(since.toString());
        return since.toString();
    }
    @RequestMapping("/yyyy-MM-dd-HH-mm-ss")
    public String dateExactValue(@DateTimeFormat(pattern="yyyy-MM-dd-HH-mm-ss")
                                 @RequestParam Date since){
        System.out.println(since.toString());
        return since.toString();
    }
}