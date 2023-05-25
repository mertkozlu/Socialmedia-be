package com.socialmedia.SocialMedia.wepApi.controllers;

import com.socialmedia.SocialMedia.business.concretes.LikeService;
import com.socialmedia.SocialMedia.dto.requests.CreateLikeRequest;
import com.socialmedia.SocialMedia.dto.requests.UpdateLikeRequest;
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
        return likeService.getAllLikesWithParam(postId, userId);
    }

    @PostMapping("/add/{likeId}")
    public Like createOneLike(@RequestBody CreateLikeRequest createLikeRequest) {
        return likeService.createOneLike(createLikeRequest);
    }

    @GetMapping("/getById/{likeId}")
    public Like getOneLike(@PathVariable Long likeId) {
        return likeService.getOneLike(likeId);
    }

    @PutMapping("/update/{likeId}")
    public Like updateOneLike(@PathVariable Long likeId, @RequestBody UpdateLikeRequest updateLikeRequest) {
        return likeService.updateOneLikeById(likeId, updateLikeRequest);
    }

    @DeleteMapping("/delete/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId) {
        this.likeService.deleteOneLikeById(likeId);
    }
}
