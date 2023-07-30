package com.socialmedia.SocialMedia.dto.requests;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private Long userId;
    private Long postId;
    private String text;

}
