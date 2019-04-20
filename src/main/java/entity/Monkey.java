package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Monkey {
    public static Long Count = 99999999l;
    private String name;
    private Integer age;
}
