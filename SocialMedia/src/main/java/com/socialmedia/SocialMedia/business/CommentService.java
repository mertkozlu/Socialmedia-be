package com.socialmedia.SocialMedia.business;

import com.socialmedia.SocialMedia.dataAccess.CommentRepository;
import com.socialmedia.SocialMedia.dto.requests.CreateCommentRequest;
import com.socialmedia.SocialMedia.dto.requests.UpdateCommentRequest;
import com.socialmedia.SocialMedia.dto.responses.GetAllCommentResponse;
import com.socialmedia.SocialMedia.entitites.Comment;
import com.socialmedia.SocialMedia.entitites.Post;
import com.socialmedia.SocialMedia.entitites.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private PostService postService;
    private UserService userService;

    public CommentService(CommentRepository commentRepository, PostService postService, UserService userService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.userService = userService;
    }

    public List<GetAllCommentResponse> getAllComments(Optional<Long> postId, Optional<Long> userId) {
        List<Comment> list;
        if (userId.isPresent() && postId.isPresent()) {
            list = commentRepository.findByUser_UserIdAndPost_PostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            list = commentRepository.findByUser_UserId(userId.get());
        } else if (postId.isPresent()) {
            list = commentRepository.findByPost_PostId(postId.get());
        } else
            list = commentRepository.findAll();
        return list.stream().map(comment -> new GetAllCommentResponse(comment)).collect(Collectors.toList());
    }

    public Comment createOnePost(CreateCommentRequest createCommentRequest) {
        User user = userService.getOneUser(createCommentRequest.getUserId());
        Post post = postService.getOnePost(createCommentRequest.getPostId());
        if (user == null && post == null)
            return null;
        Comment toSave = new Comment();
        toSave.setCommentId(createCommentRequest.getCommentId());
        toSave.setText(createCommentRequest.getText());
        toSave.setUser(user);
        toSave.setPost(post);
        toSave.setCreateDate(new Date());
        return commentRepository.save(toSave);
    }

    public Comment getOneComment(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment updateOneCommentById(Long commentId, UpdateCommentRequest updateCommentRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            Comment toUpdate = comment.get();
            toUpdate.setText(updateCommentRequest.getText());
            commentRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deleteOneCommentById(Long commentId) {
        this.commentRepository.deleteById(commentId);
    }

}
