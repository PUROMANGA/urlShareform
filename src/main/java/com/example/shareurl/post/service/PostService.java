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
    private final HashTagRepository hashTagRepository;

    public PostService(PostRepository postRepository, HashTagRepository hashTagRepository) {
        this.postRepository = postRepository;
        this.hashTagRepository = hashTagRepository;
    }

    public void savePost(RequestPostDto requestPostDto) {
        Post post = new Post(requestPostDto);
        postRepository.save(post);
    }

    public Page<ResponsePostDto> getPage(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);
        return posts.map(ResponsePostDto::new);
    }

    public void postHashTag(RequestHashTagDto requestHashTagDto) {
        HashTag madeHashTag = new HashTag(requestHashTagDto);
        hashTagRepository.save(madeHashTag);
    }

    public void updatePost(Long id, RequestPostDto requestPostDto) {
        Post findPost = postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        findPost.update(requestPostDto);
    }
}
