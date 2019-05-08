package controller.request;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

// 这里的session到底是怎么玩的啊。。。。
@RestController
@RequestMapping("/request/session")
public class SessionHandler {
    // 设置session
    @RequestMapping("/set")
    public void set(HttpSession session, HttpServletRequest request){
        Map parameters = request.getParameterMap();
        for (Object key : parameters.keySet()){
            session.setAttribute(key.toString(), parameters.get(key));
        }
    }
    // 取出session
    @RequestMapping
    public String get(HttpSession session){
        StringBuilder stringBuilder = new StringBuilder();
        Enumeration enumeration = session.getAttributeNames();
        while (enumeration.hasMoreElements()){
            stringBuilder.append(enumeration.nextElement());
        }
        return stringBuilder.toString();
    }
}
