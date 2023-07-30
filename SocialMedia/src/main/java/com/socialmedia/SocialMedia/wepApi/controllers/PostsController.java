package com.socialmedia.SocialMedia.wepApi.controllers;

import com.socialmedia.SocialMedia.business.PostService;
import com.socialmedia.SocialMedia.dto.requests.CreatePostRequest;
import com.socialmedia.SocialMedia.dto.requests.UpdatePostRequest;
import com.socialmedia.SocialMedia.dto.responses.PostResponse;
import com.socialmedia.SocialMedia.entitites.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostsController {
    private final PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getAll")
    public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @PostMapping("/add")
    public Post createOnePost(@RequestBody CreatePostRequest createPostRequest) {
        return postService.createOnePost(createPostRequest);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId) {
        return postService.getOnePost(postId);
    }

    @PutMapping("/update/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody UpdatePostRequest updatePostRequest) {
        return postService.updateOnePostById(postId, updatePostRequest);
    }

    @DeleteMapping("/delete/{postId}")
    public void deleteOnePost(@PathVariable Long postId) {
        this.postService.deleteOnePostById(postId);
    }


}
