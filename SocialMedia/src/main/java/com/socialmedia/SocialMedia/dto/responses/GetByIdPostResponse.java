package com.socialmedia.SocialMedia.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdPostResponse {
    private long postId;
    private Long userId;
    private String title;
    private String text;
}
