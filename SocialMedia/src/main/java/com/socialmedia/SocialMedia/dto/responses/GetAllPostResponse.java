package com.socialmedia.SocialMedia.dto.responses;

import com.socialmedia.SocialMedia.entitites.concretes.Post;
import lombok.Data;

import java.util.List;

@Data
public class GetAllPostResponse {
    private Long postId;
    private Long userId;
    private String userName;
    private String title;
    private String text;
    List<GetAllLikeResponse> postLikes;

    public GetAllPostResponse(Post entity, List<GetAllLikeResponse> likes) {
        this.postId = entity.getPostId();
        this.userId = entity.getUser().getUserId();
        this.userName = entity.getUser().getUserName();
        this.title = entity.getTitle();
        this.text = entity.getText();
        this.postLikes = likes;
    }
}
