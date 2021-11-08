package com.teclab.challenge.service;

import com.teclab.challenge.dto.CommentDTO;
import com.teclab.challenge.dto.PupilDTO;
import com.teclab.challenge.entity.Comment;
import com.teclab.challenge.entity.Pupil;

import java.util.List;

public interface PupilService {
    PupilDTO getPupil(Long id);
    Pupil getPupilByName(String name);
    Pupil updatePupil(Long id, PupilDTO pupilDTO) throws Exception;
    List<PupilDTO> getAllPupil();
    void savePupil(PupilDTO pupil);
    void deletePupil(Long id);
}
