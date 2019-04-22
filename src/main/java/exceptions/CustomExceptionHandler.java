package exceptions;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 在配置文件中注册后，所有Controller抛出的异常都应该又这个处理器接管
public class CustomExceptionHandler implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
        // 拿到异常ex，做出一些业务逻辑处理
        System.out.println(ex.getMessage());

        // 捕捉到异常后，返回一个自定义的错误状态码
        response.setStatus(599);

        return new ModelAndView();
    }
}
