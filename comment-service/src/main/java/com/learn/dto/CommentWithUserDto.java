package com.learn.dto;

import com.learn.entity.Comment;

public class CommentWithUserDto {

    private Comment comment;
    private UserDto user;

    public CommentWithUserDto() {}

    public CommentWithUserDto(Comment comment, UserDto user) {
        this.comment = comment;
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
