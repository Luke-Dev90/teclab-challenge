package com.teclab.challenge.dto;

import javax.validation.constraints.NotEmpty;

public class PupilDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastName;
}
