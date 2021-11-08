package com.teclab.challenge.dto;

import javax.validation.constraints.NotEmpty;

public class CommentDTO {
    @NotEmpty
    private String comment;
    private Long pupil;
    private Long career;
}
