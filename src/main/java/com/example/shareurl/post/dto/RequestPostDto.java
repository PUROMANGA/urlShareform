package com.example.shareurl.post.dto;

import com.example.shareurl.hashtag.entity.HashTag;
import lombok.Getter;

@Getter

public class RequestPostDto {
    private String title;
    private String postUrl;
    private HashTag hashTag;
}
