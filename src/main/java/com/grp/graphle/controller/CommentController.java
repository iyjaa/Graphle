package com.grp.graphle.controller;

import com.grp.graphle.dto.CommentRequest;
import com.grp.graphle.entity.Comment;
import com.grp.graphle.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{postId}/comments")
    public List<Comment> getComments(@PathVariable Long postId) {
        return commentService.getCommentsByPost(postId);
    }

    @PostMapping("/{postId}/comments")
    public Comment addComment(@PathVariable Long postId, @RequestBody CommentRequest request) {
        request.setPostId(postId);
        return commentService.addComment(request);
    }
}