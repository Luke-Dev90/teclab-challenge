package com.teclab.challenge.mapper;

import com.teclab.challenge.dto.CareerDTO;
import com.teclab.challenge.dto.CommentDTO;
import com.teclab.challenge.entity.Career;
import com.teclab.challenge.entity.Comment;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment commentToDTO(CommentDTO commentDTO);
    CommentDTO  DTOtoComment(Comment comment);
    @Mapping(target = "pupil",source = "pupilId")
    @Mapping(target = "career", source = "careerId")
    List<CommentDTO> listToDto(List<Comment> comment);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDTO(CommentDTO commentDTO, @MappingTarget Comment comment);
}
