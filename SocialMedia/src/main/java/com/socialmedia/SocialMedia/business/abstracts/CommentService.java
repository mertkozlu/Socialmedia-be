package com.socialmedia.SocialMedia.business.abstracts;

import com.socialmedia.SocialMedia.dto.responses.GetAllCommentsResponse;
import com.socialmedia.SocialMedia.dto.responses.GetByIdCommentResponse;

import java.util.List;

public interface CommentService {
    List<GetAllCommentsResponse> getAll();
    GetByIdCommentResponse getById(long commentId);
}
