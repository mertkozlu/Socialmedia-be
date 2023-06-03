package com.socialmedia.SocialMedia.dto.responses;

import com.socialmedia.SocialMedia.entitites.Post;
import lombok.Data;

@Data
public class PostResponse {
    private Long postId;
    private Long userId;
    private String userName;
    private String title;
    private String text;

    public PostResponse(Post entity) {
        this.postId = entity.getPostId();
        this.userId = entity.getUser().getUserId();
        this.userName = entity.getUser().getUserName();
        this.title = entity.getTitle();
        this.text = entity.getText();

    }
}
