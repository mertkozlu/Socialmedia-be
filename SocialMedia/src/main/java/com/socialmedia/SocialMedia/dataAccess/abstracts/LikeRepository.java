package com.socialmedia.SocialMedia.dataAccess.abstracts;

import com.socialmedia.SocialMedia.entitites.concretes.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByUser_UserIdAndPost_PostId(Long postId, Long userId);

    List<Like> findByUser_UserId(Long userId);

    List<Like> findByPost_PostId(Long postId);
}
