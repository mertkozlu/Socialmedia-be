package com.socialmedia.SocialMedia.dto.requests;

import lombok.Data;

@Data
public class CreatePostRequest {
    private String text;
    private String title;
    private Long userId;
}
