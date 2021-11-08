package com.teclab.challenge.service;

import com.teclab.challenge.dto.PupilDTO;
import com.teclab.challenge.entity.Pupil;

import java.util.List;

public interface PupilService {
    PupilDTO getPupil(Long id);
    PupilDTO getPupilByName(String name);
    List<PupilDTO> getAllPupil();
    void savePupil(PupilDTO pupil);
    void deletePupil(Long id);
}
