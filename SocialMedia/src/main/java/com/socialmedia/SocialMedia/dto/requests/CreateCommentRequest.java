package com.socialmedia.SocialMedia.dto.requests;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private Long commentId;
    private Long postId;
    private Long userId;
    private String text;

}
