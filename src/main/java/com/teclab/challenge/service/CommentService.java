package com.teclab.challenge.service;

import com.teclab.challenge.dto.CareerDTO;
import com.teclab.challenge.dto.CommentDTO;
import com.teclab.challenge.entity.Career;
import com.teclab.challenge.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    Comment getCommentById(Long id);
    void deleteCommentById(Long id);
    void deleteCommentByCareerId(Long id);
    void deleteCommentByPupilId(Long id);
    void saveComment(CommentDTO comment);
    Comment updateComment(Long id, CommentDTO commentDTO) throws Exception;
}
