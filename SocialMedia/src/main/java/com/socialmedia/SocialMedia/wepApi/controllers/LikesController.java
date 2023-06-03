package com.socialmedia.SocialMedia.wepApi.controllers;

import com.socialmedia.SocialMedia.business.LikeService;
import com.socialmedia.SocialMedia.dto.requests.CreateLikeRequest;
import com.socialmedia.SocialMedia.dto.responses.LikeResponse;
import com.socialmedia.SocialMedia.entitites.Like;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikesController {
    private final LikeService likeService;

    public LikesController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<LikeResponse> getAllLikes(@RequestParam Optional<Long> userId,
                                          @RequestParam Optional<Long> postId) {
        return likeService.getAllLikes(postId, userId);
    }

    @PostMapping("/add/{likeId}")
    public Like createOneLike(@RequestBody CreateLikeRequest createLikeRequest) {
        return likeService.createOneLike(createLikeRequest);
    }

    @GetMapping("/getById/{likeId}")
    public Like getOneLike(@PathVariable Long likeId) {
        return likeService.getOneLike(likeId);
    }

    @DeleteMapping("/delete/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId) {
        this.likeService.deleteOneLikeById(likeId);
    }
}
