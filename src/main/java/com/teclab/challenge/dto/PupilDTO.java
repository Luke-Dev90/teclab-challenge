package com.teclab.challenge.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class PupilDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastName;
}
