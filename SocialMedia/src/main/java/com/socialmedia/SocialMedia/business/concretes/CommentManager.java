package com.socialmedia.SocialMedia.business.concretes;

import com.socialmedia.SocialMedia.business.abstracts.CommentService;
import com.socialmedia.SocialMedia.dataAccess.abstracts.CommentRepository;
import com.socialmedia.SocialMedia.dto.responses.GetAllCommentsResponse;
import com.socialmedia.SocialMedia.dto.responses.GetByIdCommentResponse;
import com.socialmedia.SocialMedia.entitites.concretes.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentManager implements CommentService {
    private CommentRepository commentRepository;

    @Override
    public List<GetAllCommentsResponse> getAll() {
        List<Comment> comments = commentRepository.findAll();

        List<GetAllCommentsResponse> commentsResponses = new ArrayList<GetAllCommentsResponse>();
        for (Comment comment : comments) {
            GetByIdCommentResponse responseItem = new GetByIdCommentResponse();
            responseItem.setCommentId(comment.getCommentId());
            responseItem.setPostId(comment.getPostId());
            responseItem.setUserId(comment.getUserId());
            responseItem.setText(comment.getText());
        }
        return commentsResponses;
    }

    @Override
    public GetByIdCommentResponse getById(long commentId) {
        return null;
    }
}
