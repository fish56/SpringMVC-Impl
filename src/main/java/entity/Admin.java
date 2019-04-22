package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import validator.Loose;
import validator.Strict;

import javax.validation.constraints.*;
import java.util.Date;

// 给不同的检验规则分组
@Getter
@Setter
@NoArgsConstructor
public class Admin {
    @NotNull // 用户名必须存在
    @Size(min = 5, max = 10, message = "名字长度应该在5-10之间")
    private String name;

    // 判断数字在合理区间
    @Max(value = 120, message = "你这年龄也太大了吧", groups = {Strict.class})
    //@Min(value = 8, message = "小小孩子不要看暴漫！", groups = Loose.class)
    private Integer age;
}