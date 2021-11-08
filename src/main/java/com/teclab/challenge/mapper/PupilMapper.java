package com.teclab.challenge.mapper;

import com.teclab.challenge.dto.PupilDTO;
import com.teclab.challenge.entity.Pupil;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PupilMapper {
    Pupil pupilToDTO(PupilDTO pupilDTO);
    PupilDTO toDTO(Pupil pupil);
    List<PupilDTO> listDTO(List<Pupil>list);
}
