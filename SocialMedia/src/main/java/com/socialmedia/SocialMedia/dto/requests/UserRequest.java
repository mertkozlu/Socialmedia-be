package com.socialmedia.SocialMedia.dto.requests;

import com.socialmedia.SocialMedia.dto.responses.UserResponse;
import com.socialmedia.SocialMedia.entitites.User;
import lombok.Data;

@Data
public class UserRequest {
    String userName;
    String password;
}
