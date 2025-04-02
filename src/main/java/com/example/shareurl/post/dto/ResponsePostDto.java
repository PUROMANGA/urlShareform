package com.example.shareurl.post.dto;

import com.example.shareurl.hashtag.entity.HashTag;
import com.example.shareurl.post.entity.Post;
import lombok.Getter;

@Getter

public class ResponsePostDto {

    private Long id;
    private String title;
    private String postUrl;
    private HashTag hashTag;

    public ResponsePostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.postUrl = post.getPostUrl();
        this.hashTag = post.getHashTag();
    }
}
