package ru.polovinko.springmvc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ErrorDto {

    private Integer code;
    private String description;
}
