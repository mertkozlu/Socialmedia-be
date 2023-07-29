package com.socialmedia.SocialMedia.dto.requests;

import lombok.Data;

@Data
public class UpdateUserRequest {
    String userName;
    String password;
}
