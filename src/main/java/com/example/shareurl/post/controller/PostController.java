package com.example.shareurl.post.controller;

import org.springframework.ui.Model;
import com.example.shareurl.post.dto.RequestPostDto;
import com.example.shareurl.post.dto.ResponsePostDto;
import com.example.shareurl.post.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shareurl")

public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public String createPost(@ModelAttribute RequestPostDto requestPostDto) {
        postService.savePost(requestPostDto);
        return "redirect:/main";
    }

    @PutMapping("/{id}")
    public String putPost(
            @PathVariable Long id,
            @ModelAttribute RequestPostDto requestPostDto) {
        postService.updatePost(id, requestPostDto);
        return "redirect:/main";
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id, @ModelAttribute RequestPostDto requestPostDto) {
        postService.deletePostService(id, requestPostDto);
        return "redirect:/main";
    }

}
