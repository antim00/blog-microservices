package com.learn.service.impl;

import com.learn.dto.PostWithUserDto;
import com.learn.dto.UserDto;
import com.learn.entity.Post;
import com.learn.client.UserClient;
import com.learn.repository.PostRepository;
import com.learn.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserClient userClient;

    public PostServiceImpl(PostRepository postRepository,UserClient userClient) {
        this.postRepository = postRepository;
        this.userClient = userClient;
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public PostWithUserDto getPostWithUser(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        UserDto userDto = userClient.getUserById(post.getUserId());

        return new PostWithUserDto(post, userDto);
    }
}
