package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

// 详细的注解说明参考官方文档，这里不适合多做说明
@Getter
@Setter
@NoArgsConstructor
public class User {
    @NotNull // 用户名必须存在
    @Size(min = 5, max = 10, message = "名字长度应该在5-10之间")
    private String name;

    // 判断数字在合理区间
    @Min(value = 18, message = "未成年人禁止使用")
    @Max(value = 120, message = "你这年龄也太大了吧")
    private Integer age;

    // 通过正则来判断 长度为5-11的纯数字电话号码
    //   能用正则的话，基本解决所有字符串相关的检验
    @Pattern(regexp = "\\d{5,11}", message = "应该是长度为5-11的纯数字序列")
    private String phoneNumber;

    // 时间应该是当前时间之前
    @Past(message = "你还能是未来出生的？")
    private Date birthday;
}