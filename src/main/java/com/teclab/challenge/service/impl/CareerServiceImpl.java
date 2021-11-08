package com.teclab.challenge.service.impl;

import com.teclab.challenge.dto.CareerDTO;
import com.teclab.challenge.entity.Career;
import com.teclab.challenge.mapper.CareerMapper;
import com.teclab.challenge.repository.CareerRepository;
import com.teclab.challenge.service.CareerService;
import com.teclab.challenge.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CareerServiceImpl implements CareerService {

    @Autowired
    private CareerRepository careerRepository;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CareerMapper careerMapper;

    @Override
    public List<CareerDTO> getAllCareer() {
        return careerMapper.listCareerDto(careerRepository.findAll());
    }

    @Override
    public CareerDTO getCareerById(Long id) throws Exception {
        Career careerOptional = careerRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Career not found")
        );
    return careerMapper.DTOtoCareer(careerOptional);
    }

    @Override
    public Career updateCareer(Long id, CareerDTO careerDTO)throws Exception  {
        Career career = careerRepository.findById(id).orElseThrow
                ( () -> new NoSuchElementException("Not found career"));
        careerMapper.updateFromDTO(careerDTO,career);
        return careerRepository.save(career);
    }

    @Override
    public Career saveCareer(CareerDTO career) {
        return careerRepository.save( careerMapper.careerToDto(career));
    }

    @Override
    public void deleteCareerById(Long id) {
        Career careerOptional = careerRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Career not found")
        );
        commentService.deleteCommentByCareerId(id);
        careerRepository.deleteById(id);
    }
}
