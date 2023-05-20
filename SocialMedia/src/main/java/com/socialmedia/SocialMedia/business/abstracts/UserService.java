package com.socialmedia.SocialMedia.business.abstracts;

import com.socialmedia.SocialMedia.dto.responses.GetAllLikesResponse;
import com.socialmedia.SocialMedia.dto.responses.GetByIdUserResponse;

import java.util.List;

public interface UserService {
    List<GetAllLikesResponse> getAll();
    GetByIdUserResponse getById(long userId);
}
