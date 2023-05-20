package com.socialmedia.SocialMedia.wepApi.controllers;

import com.socialmedia.SocialMedia.dataAccess.abstracts.PostRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
    private PostRepository postRepository;

    public PostsController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
