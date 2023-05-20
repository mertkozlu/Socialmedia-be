package com.socialmedia.SocialMedia.business.concretes;

import com.socialmedia.SocialMedia.business.abstracts.PostService;
import com.socialmedia.SocialMedia.dto.responses.GetAllPostsResponse;
import com.socialmedia.SocialMedia.dto.responses.GetByIdPostResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostManager implements PostService {
    @Override
    public List<GetAllPostsResponse> getAll() {
        return null;
    }

    @Override
    public GetByIdPostResponse getById(long postId) {
        return null;
    }
}
