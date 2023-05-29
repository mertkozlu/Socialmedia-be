package com.socialmedia.SocialMedia.dataAccess.abstracts;

import com.socialmedia.SocialMedia.entitites.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByUser_UserIdAndPost_PostId(Long userId, Long postId);

    List<Comment> findByUser_UserId(Long userId);

    List<Comment> findByPost_PostId(Long postId);
    @Query(value = "select * from comment where post_id in : postIds limit 5", nativeQuery = true)
    List<Comment> findUserCommentByPostId(@Param("postIds") List<Long> postIds);

}
