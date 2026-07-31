package com.grp.graphle.service;

import com.grp.graphle.dto.CommentRequest;
import com.grp.graphle.entity.Comment;
import com.grp.graphle.entity.Post;
import com.grp.graphle.entity.User;
import com.grp.graphle.repository.CommentRepository;
import com.grp.graphle.repository.PostRepository;
import com.grp.graphle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Comment> getCommentsByPost(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public Comment addComment(CommentRequest request) {
        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new RuntimeException("Post tidak ditemukan"));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan"));

        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setPost(post);
        comment.setUser(user);

        return commentRepository.save(comment);
    }
}