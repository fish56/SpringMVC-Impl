package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 需要实现这个接口
public class Counter implements HandlerInterceptor {
    // 在路由方法调用前执行
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        System.out.println("preHandle: a request comes...");

        // 如果返回值为false，就终止这个HTTP请求
        return true;
    }

    // handler成功执行后调用，路由方法抛出异常后不会调用
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle: a response success...");

    }

    // 在即将返回前调用，可以拦截到异常
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {

        System.out.println("afterCompletion: send a response");

    }
}
