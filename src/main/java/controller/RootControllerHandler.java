package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 通过配置文件定义的Controller，需要实现这个接口
// 给个路由函数都要返回一个ModelAndView对象
// 然后交给相关的视图解析器来处理
public class RootControllerHandler implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        // 创建一个ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();

        // 给这个对象传递数据
        modelAndView.addObject("name", "Tom");

        // 设置视图的名称，结合配置文件中的ViewResolver，可以解析成真实的jsp文件
        modelAndView.setViewName("root");

        return modelAndView;
    }
}