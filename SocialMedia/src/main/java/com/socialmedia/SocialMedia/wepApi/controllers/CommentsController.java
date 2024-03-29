package com.socialmedia.SocialMedia.wepApi.controllers;

import com.socialmedia.SocialMedia.business.CommentService;
import com.socialmedia.SocialMedia.dto.requests.CreateCommentRequest;
import com.socialmedia.SocialMedia.dto.requests.UpdateCommentRequest;
import com.socialmedia.SocialMedia.dto.responses.CommentResponse;
import com.socialmedia.SocialMedia.entitites.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    private final CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/getAll")
    public List<CommentResponse> getAllComments(@RequestParam Optional<Long> userId,
                                                @RequestParam Optional<Long> postId) {
        return commentService.getAllComments(userId, postId);
    }

    @PostMapping("/add")
    public Comment createOneComment(@RequestBody CreateCommentRequest createCommentRequest) {
        return commentService.createOneComment(createCommentRequest);
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
        this.commentService.deleteOneCommentById(commentId);
    }
}
