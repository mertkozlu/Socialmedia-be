package com.socialmedia.SocialMedia.wepApi.controllers;

import com.socialmedia.SocialMedia.business.concretes.CommentService;
import com.socialmedia.SocialMedia.dto.requests.CreateCommentRequest;
import com.socialmedia.SocialMedia.dto.requests.UpdateCommentRequest;
import com.socialmedia.SocialMedia.entitites.concretes.Comment;
import com.socialmedia.SocialMedia.entitites.concretes.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    private CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/getAll")
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,
                                        @RequestParam Optional<Long> postId ) {
        return commentService.getAllComments(userId, postId);
    }

    @PostMapping("/add/{commentId}")
    public Comment createOnePost(@RequestBody CreateCommentRequest createCommentRequest) {
        return commentService.createOnePost(createCommentRequest);
    }

    @GetMapping("/getById/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId) {
        return commentService.getOneComment(commentId);
    }

    @PutMapping("/update/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId,
                                    @RequestBody UpdateCommentRequest updateCommentRequest) {
        return commentService.updateOneCommentById(commentId, updateCommentRequest);
    }

    @DeleteMapping("/delete/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId) {
        this.commentService.deleteOneComment(commentId);
    }
}
