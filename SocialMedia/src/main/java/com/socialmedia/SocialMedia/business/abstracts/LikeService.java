package com.socialmedia.SocialMedia.business.abstracts;

import com.socialmedia.SocialMedia.dto.responses.GetAllLikesResponse;
import com.socialmedia.SocialMedia.dto.responses.GetByIdLikeResponse;

import java.util.List;

public interface LikeService {
    List<GetAllLikesResponse> getAll();
    GetByIdLikeResponse getById(long likeId);
}
