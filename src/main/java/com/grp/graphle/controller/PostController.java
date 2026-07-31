package com.grp.graphle.controller;

import com.grp.graphle.dto.PostRequest;
import com.grp.graphle.entity.Post;
import com.grp.graphle.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public Post createPost(@RequestBody PostRequest request) {
        return postService.createPost(request);
    }
}