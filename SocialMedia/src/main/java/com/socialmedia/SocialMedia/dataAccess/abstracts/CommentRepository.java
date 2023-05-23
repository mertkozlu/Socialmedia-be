package com.socialmedia.SocialMedia.dataAccess.abstracts;

import com.socialmedia.SocialMedia.entitites.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByUser_UserIdAndPost_PostId(Long userId, Long postId);

    List<Comment> findByUser_UserId(Long userId);

    List<Comment> findByPost_PostId(Long postId);

}
