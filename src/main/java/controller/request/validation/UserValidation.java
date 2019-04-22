package controller.request.validation;

import entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/validation")
public class UserValidation {

    // 要求用户提交的数据必须通过验证
    @RequestMapping("/user")
    public User nameNotNull(@Valid @RequestBody User user){
        return user;
    }
}
