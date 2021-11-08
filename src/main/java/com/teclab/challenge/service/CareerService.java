package com.teclab.challenge.service;

import com.teclab.challenge.dto.CareerDTO;
import com.teclab.challenge.entity.Career;

import java.util.List;

public interface CareerService {
    List<CareerDTO> getAllCareer();
    CareerDTO getCareerById(Long id) throws Exception;
    void saveCareer(CareerDTO career);
    void deleteCareerById(Long id);
}
