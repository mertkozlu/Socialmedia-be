package com.socialmedia.SocialMedia.dto.requests;

import lombok.Data;

@Data
public class CreateLikeRequest {
    private Long likeId;
    private Long userId;
    private Long postId;
}
