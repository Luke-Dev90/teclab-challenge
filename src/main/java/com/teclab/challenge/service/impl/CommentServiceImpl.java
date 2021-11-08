package com.teclab.challenge.service.impl;

import com.teclab.challenge.dto.CareerDTO;
import com.teclab.challenge.dto.CommentDTO;
import com.teclab.challenge.entity.Career;
import com.teclab.challenge.entity.Comment;
import com.teclab.challenge.mapper.CommentMapper;
import com.teclab.challenge.repository.CommentsRepository;
import com.teclab.challenge.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getAllComments() {
        return commentsRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
    return commentsRepository.findById(id).orElseThrow( () -> new NoSuchElementException("Comment not found"));
    }

    @Override
    public void deleteCommentById(Long id) {
        Comment comment = commentsRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Comment not found")
        );
        commentsRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCommentByCareerId(Long id) {
        commentsRepository.getCommentByIdCareer(id);
    }

    @Override
    @Transactional
    public void deleteCommentByPupilId(Long id) {
        commentsRepository.getCommentByIdPupil(id);
    }

    @Override
    public void saveComment(CommentDTO comment) {
        commentsRepository.save( commentMapper.commentToDTO(comment));
    }

    @Override
    public Comment updateComment(Long id, CommentDTO commentDTO) throws Exception {
        Comment comment = commentsRepository.findById(id)
                .orElseThrow( () -> new NoSuchElementException("Not found comment"));
        commentMapper.updateFromDTO(commentDTO,comment);
        return commentsRepository.save(comment);
    }
}
