package com.learn.service;

import com.learn.dto.PostWithUserDto;
import com.learn.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post createPost(Post post) ;

    public List<Post> getAllPosts();

    public Optional<Post> getPostById(Long id);

    public void deletePost(Long id);

    PostWithUserDto getPostWithUser(Long postId);

}
