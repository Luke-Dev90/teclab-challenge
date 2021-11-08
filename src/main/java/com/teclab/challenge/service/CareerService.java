package com.teclab.challenge.service;

import com.teclab.challenge.dto.CareerDTO;
import com.teclab.challenge.entity.Career;

import java.util.List;

public interface CareerService {
    List<CareerDTO> getAllCareer();
    CareerDTO getCareerById(Long id) throws Exception;
    Career updateCareer(Long id, CareerDTO careerDTO) throws Exception ;
    Career saveCareer(CareerDTO career);
    void deleteCareerById(Long id);
}
