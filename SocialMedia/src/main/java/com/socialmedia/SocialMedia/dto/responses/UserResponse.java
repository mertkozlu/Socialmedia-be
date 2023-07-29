package com.socialmedia.SocialMedia.dto.responses;

import com.socialmedia.SocialMedia.entitites.User;
import lombok.Data;

@Data
public class UserResponse {
    private Long userId;
    private String userName;

    public UserResponse(User entity) {
        this.userName = entity.getUserName();
        this.userId = entity.getUserId();

    }
}
