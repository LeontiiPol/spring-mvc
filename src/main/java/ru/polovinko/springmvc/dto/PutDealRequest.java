package ru.polovinko.springmvc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class PutDealRequest {

    private String number;
}
