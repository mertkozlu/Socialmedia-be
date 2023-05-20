package com.socialmedia.SocialMedia.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLikesResponse {
    private Long likesId;
    private Long postId;
    private Long userId;
}
