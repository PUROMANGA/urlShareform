package com.example.shareurl.post.service;

import com.example.shareurl.hashtag.dto.RequestHashTagDto;
import com.example.shareurl.hashtag.dto.ResponseHashTagDto;
import com.example.shareurl.hashtag.entity.HashTag;
import com.example.shareurl.hashtag.repository.HashTagRepository;
import com.example.shareurl.post.dto.RequestPostDto;
import com.example.shareurl.post.dto.ResponsePostDto;
import com.example.shareurl.post.entity.Post;
import com.example.shareurl.post.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void savePost(RequestPostDto requestPostDto) {
        postRepository.save(new Post(requestPostDto));
    }

    public void updatePost(Long id, RequestPostDto requestPostDto) {
        Post findPost = postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        findPost.update(requestPostDto);
    }

    public void deletePostService(Long id, RequestPostDto requestPostDto) {
        Post findPost = postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        postRepository.delete(findPost);
    }
}
