package com.socialmedia.SocialMedia.dto.responses;

import com.socialmedia.SocialMedia.entitites.concretes.User;
import lombok.Data;

@Data
public class GetAllUserResponse {
    private Long userId;
    private int avatarId;
    private String userName;

    public GetAllUserResponse(User entity) {
        this.userId = entity.getUserId();
        this.userName = entity.getUserName();
    }
}
