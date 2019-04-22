package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
public class User {
    @NotNull
    private String name;

    // @Size(min = 12, max = 120)
    private Integer age;
}