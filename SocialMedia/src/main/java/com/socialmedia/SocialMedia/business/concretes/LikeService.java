package com.socialmedia.SocialMedia.business.concretes;

import com.socialmedia.SocialMedia.dataAccess.abstracts.LikeRepository;
import com.socialmedia.SocialMedia.dto.responses.GetAllLikeResponse;
import com.socialmedia.SocialMedia.entitites.concretes.Like;
import com.socialmedia.SocialMedia.entitites.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeService {
    private LikeRepository likeRepository;
    private PostService postService;
    private UserService userService;

    public LikeService(LikeRepository likeRepository, PostService postService, UserService userService) {
        this.likeRepository = likeRepository;
        this.postService = postService;
        this.userService = userService;
    }

    public List<GetAllLikeResponse> getAllLikes(Optional<Long> postId, Optional<Long> userId) {
        List<Like> list;
        if (postId.isPresent() && userId.isPresent()) {
            list = likeRepository.findByUser_UserIdAndPost_PostId(postId.get(), userId.get());
        } else if (userId.isPresent()) {
            list = likeRepository.findByUser_UserId(userId.get());
        } else if (postId.isPresent()) {
            list = likeRepository.findByPost_PostId(postId.get());
        } else
            list = likeRepository.findAll();
        return list.stream().map(like -> new GetAllLikeResponse(like)).collect(Collectors.toList());
    }
}
