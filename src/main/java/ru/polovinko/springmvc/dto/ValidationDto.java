package ru.polovinko.springmvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import ru.polovinko.springmvc.validation.NameGroup;

@Getter
@Setter
@Accessors(chain = true)
public class ValidationDto {

    @Positive
    private Integer age;

    @NotBlank(groups = NameGroup.class)
    @Length(max = 15)
    private String name;
}
