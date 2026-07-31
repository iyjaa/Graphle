package com.grp.graphle.service;

import com.grp.graphle.entity.Like;
import com.grp.graphle.entity.Post;
import com.grp.graphle.entity.User;
import com.grp.graphle.repository.LikeRepository;
import com.grp.graphle.repository.PostRepository;
import com.grp.graphle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public String toggleLike(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post tidak ditemukan"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan"));

        Optional<Like> existingLike = likeRepository.findByPostIdAndUserId(postId, userId);

        if (existingLike.isPresent()) {
            likeRepository.delete(existingLike.get());
            return "unliked";
        } else {
            Like like = new Like();
            like.setPost(post);
            like.setUser(user);
            likeRepository.save(like);
            return "liked";
        }
    }

    public long getLikeCount(Long postId) {
        return likeRepository.countByPostId(postId);
    }
}