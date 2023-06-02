package com.socialmedia.SocialMedia.dataAccess;

import com.socialmedia.SocialMedia.entitites.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByUser_UserIdAndPost_PostId(Long postId, Long userId);

    List<Like> findByUser_UserId(Long userId);

    List<Like> findByPost_PostId(Long postId);

    @Query(value = "select 'liked', l.post_id, u.avatar, u.user_name from"
            + "p_like l left join user u on u.id = l.user_id"
            + "where l.post_id ind :postIds limit 5", nativeQuery = true)
    List<Object> findUserLikeByPostId(@Param("postIds") List<Long> postIds);


}
