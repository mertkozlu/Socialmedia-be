package com.socialmedia.SocialMedia.dataAccess.abstracts;

import com.socialmedia.SocialMedia.entitites.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
