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

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> postId ){
        return commentService.getAllComments(postId);
    }

    @PostMapping
    public Comment createOnePost(@RequestBody CreateCommentRequest createCommentRequest) {
        return commentService.createOnePost(createCommentRequest);
    }

    @GetMapping("/{id}")
    public Comment getOneComment(@PathVariable Long id) {
        return commentService.getOneComment(id);
    }

    @PutMapping("/{id}")
    public Comment updateOneComment(@PathVariable Long id, @RequestBody UpdateCommentRequest updateCommentRequest) {
        return commentService.updateOneCommentById(id, updateCommentRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteOneComment(@PathVariable Long id) {
        this.commentService.deleteOneComment(id);
    }
}
