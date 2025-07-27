package com.learn.service;

import com.learn.dto.CommentWithUserDto;
import com.learn.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {


    public Comment addComment(Comment comment);

    public List<Comment> getAllComments();

    public Optional<Comment> getCommentById(Long id);

    public void deleteComment(Long id);

    public CommentWithUserDto getCommentWithUser(Long commentId);
}
