package com.example.shareurl.post.entity;

import com.example.shareurl.BaseEntity.BaseEntity;
import com.example.shareurl.post.dto.RequestPostDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter

public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(
            regexp = "^(https?|ftp)://[^\\s/$.?#].\\S*$",
            message = "유효한 URL 형식이어야 합니다."
    )
    @Column(nullable = false)
    private String postUrl;

    public Post(RequestPostDto requestPostDto) {
        this.postUrl = requestPostDto.getPostUrl();
    }

    public void update(RequestPostDto requestPostDto) {
        this.postUrl = requestPostDto.getPostUrl();
    }
}