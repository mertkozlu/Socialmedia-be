package com.socialmedia.SocialMedia.business;

import com.socialmedia.SocialMedia.dataAccess.PostRepository;
import com.socialmedia.SocialMedia.dto.requests.CreatePostRequest;
import com.socialmedia.SocialMedia.dto.requests.UpdatePostRequest;
import com.socialmedia.SocialMedia.dto.responses.PostResponse;
import com.socialmedia.SocialMedia.entitites.Post;
import com.socialmedia.SocialMedia.entitites.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }


    public List<PostResponse> getAllPosts(Optional<Long> userId) {
        List<Post> list;
        if (userId.isPresent()) {
            list = postRepository.findByUser_UserId(userId.get());
        } else
            list = postRepository.findAll();
        return list.stream().map(post -> new PostResponse(post)).collect(Collectors.toList());
    }

    public Post getOnePost(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(CreatePostRequest createPostRequest) {
        User user = userService.getOneUser(createPostRequest.getUserId());
        if (user == null)
            return null;
        Post toSave = new Post();
        toSave.setPostId(createPostRequest.getPostId());
        toSave.setText(createPostRequest.getText());
        toSave.setTitle(createPostRequest.getTitle());
        toSave.setUser(user);
        toSave.setCreateDate(new Date());
        return postRepository.save(toSave);
    }

    public Post updateOnePostById(Long postId, UpdatePostRequest updatePostRequest) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setText(updatePostRequest.getText());
            toUpdate.setTitle(updatePostRequest.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deleteOnePostById(Long postId) {
        this.postRepository.deleteById(postId);
    }
}
