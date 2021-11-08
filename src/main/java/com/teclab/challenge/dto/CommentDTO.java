package com.teclab.challenge.dto;


import com.teclab.challenge.entity.Pupil;
import lombok.*;


import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    @NotEmpty
    private String comment;
    private Long pupilId;
    private Long careerId;
}
