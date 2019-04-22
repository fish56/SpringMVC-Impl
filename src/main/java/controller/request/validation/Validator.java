package controller.request.validation;

import entity.Admin;
import entity.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import validator.Loose;

@RestController
@RequestMapping("/validation")
public class Validator {

    // 要求用户提交的数据必须通过验证
    //   通过@Validated来开启检验
    //   BindingResult 记录检验后的相关信息，必须排在@Validated后面
    @RequestMapping("/user")
    public ResponseEntity user(@Validated @RequestBody User user,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            // 将所有的错误信息都返回给用户
            return ResponseEntity.status(400)
                    .body(bindingResult.getAllErrors());
        }
        return new ResponseEntity(HttpStatus.valueOf(200));
    }

    // 使用Loose.class这个组，用户年龄可以大于120
    @RequestMapping("/admin")
    public ResponseEntity admin(@Validated(value = {Loose.class}) @RequestBody Admin admin,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            // 将所有的错误信息都返回给用户
            return ResponseEntity.status(400)
                    .body(bindingResult.getAllErrors());
        }
        return new ResponseEntity(HttpStatus.valueOf(200));
    }
}
