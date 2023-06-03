package com.socialmedia.SocialMedia.dataAccess;

import com.socialmedia.SocialMedia.entitites.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    RefreshToken findByUser_UserId(Long userId);
}
