package controller.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/request/fileupload")
public class FileUploadHandler {
    @GetMapping
    public String html(){
        return "fileupload";
    }

    @PostMapping
    @ResponseBody
    public String upload(MultipartFile file) throws Exception{
        System.out.println(file.getBytes().length);
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        return new String(file.getBytes());
    }
}
