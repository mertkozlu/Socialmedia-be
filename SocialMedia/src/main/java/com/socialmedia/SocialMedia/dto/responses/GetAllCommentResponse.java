package com.socialmedia.SocialMedia.dto.responses;

import com.socialmedia.SocialMedia.entitites.concretes.Comment;
import lombok.Data;

@Data
public class GetAllCommentResponse {
    private Long commentId;
    private String text;

    public GetAllCommentResponse(Comment entity) {
        this.commentId = entity.getCommentId();
        this.text = entity.getText();;
    }
}
