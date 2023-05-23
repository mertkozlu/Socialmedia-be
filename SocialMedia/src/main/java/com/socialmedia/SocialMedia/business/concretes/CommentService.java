package com.socialmedia.SocialMedia.business.concretes;

import com.socialmedia.SocialMedia.dataAccess.abstracts.CommentRepository;
import com.socialmedia.SocialMedia.dto.requests.CreateCommentRequest;
import com.socialmedia.SocialMedia.dto.requests.UpdateCommentRequest;
import com.socialmedia.SocialMedia.entitites.concretes.Comment;
import com.socialmedia.SocialMedia.entitites.concretes.Post;
import com.socialmedia.SocialMedia.entitites.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Comment> getAllComments(Optional<Long> postId) {
        if (postId.isPresent())
            return commentRepository.findByPost_PostId(postId.get());
        return commentRepository.findAll();
    }

    public Comment createOnePost(CreateCommentRequest createCommentRequest) {
        User user = userService.getOneUser(createCommentRequest.getUserId());
        Post post = postService.getOnePost(createCommentRequest.getPostId());
        if (user == null && post == null)
            return null;
        Comment toSave = new Comment();
        toSave.setId(createCommentRequest.getId());
        toSave.setText(createCommentRequest.getText());
        toSave.setUser(user);
        toSave.setPost(post);
        return commentRepository.save(toSave);
    }

    public Comment getOneComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment updateOneCommentById(Long id, UpdateCommentRequest updateCommentRequest) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            Comment toUpdate = comment.get();
            toUpdate.setText(updateCommentRequest.getText());
            commentRepository.save(toUpdate);
            return toUpdate;
        }
            return null;
    }

    public void deleteOneComment(Long id) {
        this.commentRepository.deleteById(id);
    }

}
