package com.teclab.challenge.service.impl;

import com.teclab.challenge.dto.CommentDTO;
import com.teclab.challenge.entity.Comment;
import com.teclab.challenge.mapper.CommentMapper;
import com.teclab.challenge.repository.CommentsRepository;
import com.teclab.challenge.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentDTO> getAllComments() {
        return commentMapper.listToDto( commentsRepository.findAll());
    }

    @Override
    public CommentDTO getCommentById(Long id) {
        Comment comment = commentsRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Comment not found")
        );
    return commentMapper.DTOtoComment(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        Comment comment = commentsRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Comment not found")
        );
        commentsRepository.deleteById(id);
    }

    @Override
    public void saveComment(CommentDTO comment) {
        commentsRepository.save( commentMapper.commentToDTO(comment));
    }
}
