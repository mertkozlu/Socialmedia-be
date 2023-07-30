package com.socialmedia.SocialMedia.dto.requests;

import lombok.Data;

@Data
public class CreatePostRequest {
    private Long userId;
    private String text;
    private String title;

}
