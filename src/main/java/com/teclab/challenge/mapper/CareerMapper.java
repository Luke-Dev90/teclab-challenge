package com.teclab.challenge.mapper;

import com.teclab.challenge.dto.CareerDTO;
import com.teclab.challenge.entity.Career;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CareerMapper {
    Career careerToDto(CareerDTO careerDTO);
    CareerDTO DTOtoCareer(Career career);
    List<CareerDTO> listCareerDto(List<Career> list);
}
