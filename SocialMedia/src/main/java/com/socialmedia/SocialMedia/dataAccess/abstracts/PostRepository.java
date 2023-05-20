package com.socialmedia.SocialMedia.dataAccess.abstracts;

import com.socialmedia.SocialMedia.entitites.concretes.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
