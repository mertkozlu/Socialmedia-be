package com.socialmedia.SocialMedia.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCommentResponse {
    private Long commentId;
    private Long postId;
    private Long userId;
    private String text;
}
