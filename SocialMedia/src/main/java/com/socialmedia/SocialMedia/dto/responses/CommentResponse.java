package com.socialmedia.SocialMedia.dto.responses;

import com.socialmedia.SocialMedia.entitites.Comment;
import lombok.Data;

@Data
public class CommentResponse {
    private Long commentId;
    private Long userId;
    private String userName;
    private String text;

    public CommentResponse(Comment entity) {
        this.commentId = entity.getCommentId();
        this.userId = entity.getUser().getUserId();
        this.userName = entity.getUser().getUserName();
        this.text = entity.getText();

    }
}
