package controller.request;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request/pathVariable")
public class PathVariableHandler {
    // 可以通过这个注解拿到路由中的path变量
    // 为了对应，路由中的变量名称和参数的名称需要保持一致
    //   除非通过name属性来指定
    @RequestMapping("/{variable1}/{variable2}")
    public Integer integerType(@PathVariable Integer variable1,
                             @PathVariable(name = "variable2") Integer v2){
        return variable1 + v2;
    }
}
