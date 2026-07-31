package com.grp.graphle.controller;

import com.grp.graphle.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/{postId}/like")
    public Map<String, Object> toggleLike(@PathVariable Long postId, @RequestBody Map<String, Long> body) {
        Long userId = body.get("userId");
        String status = likeService.toggleLike(postId, userId);
        long count = likeService.getLikeCount(postId);

        return Map.of("status", status, "likeCount", count);
    }
}