package com.teclab.challenge.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
@Data
@NoArgsConstructor
public class CareerDTO {
    @NotEmpty
    private String name;
}
