package com.socialmedia.SocialMedia.business.concretes;

import com.socialmedia.SocialMedia.business.abstracts.CommentService;
import com.socialmedia.SocialMedia.dto.responses.GetAllCommentsResponse;
import com.socialmedia.SocialMedia.dto.responses.GetByIdCommentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentManager implements CommentService {
    @Override
    public List<GetAllCommentsResponse> getAll() {
        return null;
    }

    @Override
    public GetByIdCommentResponse getById(long commentId) {
        return null;
    }
}
