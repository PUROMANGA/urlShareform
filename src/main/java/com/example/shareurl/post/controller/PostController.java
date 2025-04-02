package com.example.shareurl.post.controller;

import com.example.shareurl.hashtag.dto.RequestHashTagDto;
import com.example.shareurl.hashtag.dto.ResponseHashTagDto;
import org.springframework.ui.Model;
import java.util.List;
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
@RequestMapping("/postForm")

public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public String creatPost(@ModelAttribute RequestPostDto requestPostDto, Model model) {
        postService.savePost(requestPostDto);
        return "redirect:/post/page";
    }

    @PostMapping
    public String creatHashTag(@ModelAttribute RequestHashTagDto requestHashTagDto, Model model) {
        postService.postHashTag(requestHashTagDto);
        return "redirect:/post/page";
    }

    @GetMapping("/page") //취소를 눌렀을 때 이걸로 이동시켜야됨
    public String getPage(@PageableDefault(size = 10, direction = Sort.Direction.DESC) Pageable pageable, Model model) throws Exception {
        Page<ResponsePostDto> posts = postService.getPage(pageable);
        model.addAttribute("posts", posts);
        return "redirect:/post/page";
    }

    @PutMapping("/{id}")
    public String putPost(
            @PathVariable Long id,
            @ModelAttribute RequestPostDto requestPostDto, Model model) {
        postService.updatePost(id, requestPostDto);
        return "redirect:/post/page";
    }
}
