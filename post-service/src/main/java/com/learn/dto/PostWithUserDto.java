package com.learn.dto;

import com.learn.entity.Post;

public class PostWithUserDto {

    private Long postId;
    private String title;
    private String content;

    private Long userId;
    private String userName;
    private String userEmail;

    public PostWithUserDto() {}

    public PostWithUserDto(Post post, UserDto userDto) {
        this.postId = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.userId = userDto.getId();
        this.userName = userDto.getName();
        this.userEmail = userDto.getEmail();
    }

    // Getters and Setters
    public Long getPostId() { return postId; }
    public void setPostId(Long postId) { this.postId = postId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
}
