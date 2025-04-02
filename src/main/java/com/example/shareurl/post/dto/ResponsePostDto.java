package com.example.shareurl.post.dto;

import com.example.shareurl.hashtag.entity.HashTag;
import com.example.shareurl.post.entity.Post;
import lombok.Getter;

@Getter

public class ResponsePostDto {

    private Long id;
    private String postUrl;

    public ResponsePostDto(Post post) {
        this.id = post.getId();
        this.postUrl = post.getPostUrl();
    }
}
