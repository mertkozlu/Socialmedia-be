package com.socialmedia.SocialMedia.wepApi.controllers;

import com.socialmedia.SocialMedia.dataAccess.abstracts.LikeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/likes")
public class LikesController {
    private LikeRepository likeRepository;
    public LikesController(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }
}
