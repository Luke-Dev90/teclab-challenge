package com.teclab.challenge.mapper;

import com.teclab.challenge.dto.CommentDTO;
import com.teclab.challenge.entity.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    Comment commentToDTO(CommentDTO commentDTO);
    CommentDTO  DTOtoComment(Comment comment);
    List<CommentDTO> listToDto(List<Comment> comment);
}
