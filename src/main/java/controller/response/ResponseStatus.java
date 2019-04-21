package controller.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// 可以返回一个ResponseEntity
//   通过它设置状态码和响应头部

@RestController
@RequestMapping("/response/status")
public class ResponseStatus {

    // 单纯设置状态码
    @RequestMapping("/404")
    public ResponseEntity status404(){

        // 404, "Not Found"
        return new ResponseEntity(HttpStatus.valueOf(404));
    }

    // 设置状态码和响应头部
    @RequestMapping("/302")
    public ResponseEntity status302(){
        // 302, "Moved Temporarily"

        return ResponseEntity.status(302)
                .header("Location","https://www.github.com/fish56")
                .body("");
    }
}
