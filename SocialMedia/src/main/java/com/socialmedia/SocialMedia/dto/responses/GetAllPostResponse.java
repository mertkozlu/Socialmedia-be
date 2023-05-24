package com.socialmedia.SocialMedia.dto.responses;

import com.socialmedia.SocialMedia.entitites.concretes.Post;
import lombok.Data;

@Data
public class GetAllPostResponse {
    private Long postId;
    private Long userId;
    private String userName;
    private String title;
    private String text;

    public GetAllPostResponse(Post entity) {
        this.postId = entity.getPostId();
        this.userId = entity.getUser().getUserId();
        this.userName = entity.getUser().getUserName();
        this.title = entity.getTitle();
        this.text = entity.getText();
    }
}
