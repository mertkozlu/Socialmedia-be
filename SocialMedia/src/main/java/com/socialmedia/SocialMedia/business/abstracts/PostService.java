package com.socialmedia.SocialMedia.business.abstracts;

import com.socialmedia.SocialMedia.dto.responses.GetAllPostsResponse;
import com.socialmedia.SocialMedia.dto.responses.GetByIdPostResponse;

import java.util.List;

public interface PostService {
    List<GetAllPostsResponse> getAll();
    GetByIdPostResponse getById(long postId);
}
