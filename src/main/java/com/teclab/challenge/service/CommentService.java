package com.teclab.challenge.service;

import com.teclab.challenge.dto.CommentDTO;
import com.teclab.challenge.entity.Comment;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getAllComments();
    CommentDTO getCommentById(Long id);
    void deleteCommentById(Long id);
    void saveComment(CommentDTO comment);
}
