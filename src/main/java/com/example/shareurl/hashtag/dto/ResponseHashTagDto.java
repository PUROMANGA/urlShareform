package com.example.shareurl.hashtag.dto;

import com.example.shareurl.hashtag.entity.HashTag;
import lombok.Getter;

@Getter

public class ResponseHashTagDto {
    private Long id;
    private String hashTag;

    public ResponseHashTagDto(HashTag hashTag) {
        this.id = hashTag.getId();
        this.hashTag = hashTag.getHashTag();
    }
}
