package com.socialmedia.SocialMedia.dataAccess.abstracts;

import com.socialmedia.SocialMedia.entitites.concretes.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
