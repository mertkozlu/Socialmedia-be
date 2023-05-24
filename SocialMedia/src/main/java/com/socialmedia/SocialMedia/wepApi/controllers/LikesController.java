package com.socialmedia.SocialMedia.wepApi.controllers;

import com.socialmedia.SocialMedia.business.concretes.LikeService;
import com.socialmedia.SocialMedia.dto.responses.GetAllLikeResponse;
import com.socialmedia.SocialMedia.entitites.concretes.Like;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikesController {
    private LikeService likeService;
    public LikesController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<GetAllLikeResponse> getAllLikes(@RequestParam Optional<Long> userId,
                                                @RequestParam Optional<Long> postId) {
        return likeService.getAllLikes(postId,userId);
    }
}
