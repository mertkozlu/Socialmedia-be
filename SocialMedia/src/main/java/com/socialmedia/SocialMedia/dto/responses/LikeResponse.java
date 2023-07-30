package com.socialmedia.SocialMedia.dto.responses;

import com.socialmedia.SocialMedia.entitites.Like;
import lombok.Data;

@Data
public class LikeResponse {
    private Long likeId;
    private Long userId;
    private Long postId;

    public LikeResponse(Like entity) {
        this.likeId = entity.getLikeId();
        this.userId = entity.getUser().getUserId();
        this.postId = entity.getPost().getPostId();
    }
}
