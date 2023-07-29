package com.socialmedia.SocialMedia.dto.requests;

import lombok.Data;

@Data
public class CreateUserRequest {
    String userName;
    String password;
}
