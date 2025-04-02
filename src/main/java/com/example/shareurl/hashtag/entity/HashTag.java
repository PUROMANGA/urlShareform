package com.example.shareurl.hashtag.entity;

import com.example.shareurl.hashtag.dto.RequestHashTagDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class HashTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String hashTag;

    public HashTag(RequestHashTagDto requestHashTagDto) {
        this.hashTag = requestHashTagDto.getHashTag();
    }
}
