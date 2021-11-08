package com.teclab.challenge.mapper;

import com.teclab.challenge.dto.CommentDTO;
import com.teclab.challenge.dto.PupilDTO;
import com.teclab.challenge.entity.Comment;
import com.teclab.challenge.entity.Pupil;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PupilMapper {
    Pupil pupilToDTO(PupilDTO pupilDTO);
    PupilDTO toDTO(Pupil pupil);
    List<PupilDTO> listDTO(List<Pupil>list);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDTO(PupilDTO pupilDTO, @MappingTarget Pupil pupil);
}
