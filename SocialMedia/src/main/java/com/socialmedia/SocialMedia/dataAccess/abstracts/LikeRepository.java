package com.socialmedia.SocialMedia.dataAccess.abstracts;

import com.socialmedia.SocialMedia.entitites.concretes.Comment;
import com.socialmedia.SocialMedia.entitites.concretes.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByUser_UserIdAndPost_PostId(Long postId, Long userId);

    List<Like> findByUser_UserId(Long userId);

    List<Like> findByPost_PostId(Long postId);

    @Query(value = "select * from likes where post_id in : postIds limit 5", nativeQuery = true)
    List<Like> findUserLikeByPostId(@Param("postIds") List<Long> postIds);


}
