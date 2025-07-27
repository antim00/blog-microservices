package com.learn.service.impl;

import com.learn.client.UserClient;
import com.learn.dto.CommentWithUserDto;
import com.learn.dto.UserDto;
import com.learn.entity.Comment;
import com.learn.repository.CommentRepository;
import com.learn.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    private UserClient userClient;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment addComment(Comment comment) {
        UserDto user = userClient.getUserById(comment.getUserId());
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentWithUserDto getCommentWithUser(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        UserDto userDto = userClient.getUserById(comment.getUserId());

        return new CommentWithUserDto(comment, userDto);
    }
}