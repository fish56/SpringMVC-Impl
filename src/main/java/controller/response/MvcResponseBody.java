package controller.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/response/mvc")
public class MvcResponseBody {
    @RequestMapping("/model-and-view")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key1", "value1");
        modelAndView.setViewName("mvc");
        return modelAndView;
    }

    // 可以把ModelAndView拆分来写
    // 传入的参数Model就是之前ModelAndView里面的Model
    // 返回的字符串就是视图的名称
    @RequestMapping("/model")
    public String modelAsArg(Model model){
        model.addAttribute("key1", "value1");
        return "mvc";
    }

    // 可以把数据写成map的形式
    @RequestMapping("/map-as-model")
    public String strAsResult(Map<String, String> model){
        model.put("key1", "value1");
        return "mvc";
    }
}
