package com.socialmedia.SocialMedia.wepApi.controllers;

import com.socialmedia.SocialMedia.dataAccess.abstracts.CommentRepository;
import com.socialmedia.SocialMedia.entitites.concretes.Comment;
import com.socialmedia.SocialMedia.entitites.concretes.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    private CommentRepository commentRepository;

    public CommentsController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @PostMapping
    public Comment add(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @GetMapping("/{commentId}")
    public Comment getById(@PathVariable long commentId){
        return commentRepository.getById(commentId);
    }

    @PutMapping
    public Comment update(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

}
