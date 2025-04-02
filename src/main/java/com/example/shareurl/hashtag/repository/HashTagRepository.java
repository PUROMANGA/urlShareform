package com.example.shareurl.hashtag.repository;


import com.example.shareurl.hashtag.entity.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HashTagRepository extends JpaRepository<HashTag, Long> {
}
