package com.socialmedia.SocialMedia.business.concretes;

import com.socialmedia.SocialMedia.business.abstracts.LikeService;
import com.socialmedia.SocialMedia.dto.responses.GetAllLikesResponse;
import com.socialmedia.SocialMedia.dto.responses.GetByIdLikeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LikeManager implements LikeService {
    @Override
    public List<GetAllLikesResponse> getAll() {
        return null;
    }

    @Override
    public GetByIdLikeResponse getById(long likeId) {
        return null;
    }
}
