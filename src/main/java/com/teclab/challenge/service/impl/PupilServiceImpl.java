package com.teclab.challenge.service.impl;

import com.teclab.challenge.dto.PupilDTO;
import com.teclab.challenge.entity.Pupil;
import com.teclab.challenge.mapper.PupilMapper;
import com.teclab.challenge.repository.PupilRepository;
import com.teclab.challenge.service.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PupilServiceImpl implements PupilService {

    @Autowired
    private PupilRepository pupilRepository;

    @Autowired
    private PupilMapper pupilMapper;

    @Override
    public PupilDTO getPupil(Long id) {
        Pupil pupil = pupilRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Pupil not fount")
        );
        return pupilMapper.toDTO(pupil);
    }

    @Override
    public PupilDTO getPupilByName(String name) {
    return pupilRepository.getByName(name);
    }

    @Override
    public List<PupilDTO> getAllPupil() {
    return pupilMapper.listDTO(pupilRepository.findAll());
    }

    @Override
    public void savePupil(PupilDTO pupil) {
        pupilRepository.save( pupilMapper.pupilToDTO(pupil));
    }

    @Override
    public void deletePupil(Long id) {
        Pupil pupil = pupilRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Pupil not fount")
        );
        pupilRepository.deleteById(pupil.getId());
    }
}
