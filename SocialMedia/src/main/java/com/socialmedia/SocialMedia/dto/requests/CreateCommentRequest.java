package com.socialmedia.SocialMedia.dto.requests;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private Long id;
    private String text;
    private Long postId;
    private Long userId;
}
