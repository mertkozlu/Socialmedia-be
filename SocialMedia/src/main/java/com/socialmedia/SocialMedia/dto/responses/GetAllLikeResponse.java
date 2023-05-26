package com.socialmedia.SocialMedia.dto.responses;

import com.socialmedia.SocialMedia.entitites.concretes.Like;
import lombok.Data;

import java.util.List;

@Data
public class GetAllLikeResponse {
    private Long likeId;
    private Long userId;
    private Long postId;

    public GetAllLikeResponse(Like entity) {
        this.likeId = entity.getLikeId();
        this.userId = entity.getUser().getUserId();
        this.postId = entity.getUser().getUserId();
    }
}
