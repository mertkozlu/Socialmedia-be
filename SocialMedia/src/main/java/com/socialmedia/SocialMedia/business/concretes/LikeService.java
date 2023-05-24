package com.socialmedia.SocialMedia.business.concretes;

import com.socialmedia.SocialMedia.dataAccess.abstracts.LikeRepository;
import com.socialmedia.SocialMedia.dto.requests.CreateLikeRequest;
import com.socialmedia.SocialMedia.dto.requests.UpdateLikeRequest;
import com.socialmedia.SocialMedia.dto.responses.GetAllLikeResponse;
import com.socialmedia.SocialMedia.entitites.concretes.Like;
import com.socialmedia.SocialMedia.entitites.concretes.Post;
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

    public Like createOneLike(CreateLikeRequest createLikeRequest) {
        User user = userService.getOneUser(createLikeRequest.getUserId());
        Post post = postService.getOnePost(createLikeRequest.getPostId());
        if (user == null && post == null)
            return null;
        Like toSave = new Like();
        toSave.setLikeId(createLikeRequest.getLikeId());
        toSave.setUser(user);
        toSave.setPost(post);
        return likeRepository.save(toSave);
    }

    public Like getOneLike(Long likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }

    public Like updateOneLikeById(Long likeId, UpdateLikeRequest updateLikeRequest) {
        Optional<Like> like = likeRepository.findById(likeId);
        if (like.isPresent()) {
            Like toUpdate = like.get();
            return likeRepository.save(toUpdate);
        }
        return null;
    }

    public void deleteOneLikeById(Long likeId) {
        this.likeRepository.deleteById(likeId);
    }
}
