package com.socialmedia.SocialMedia.business.concretes;

import com.socialmedia.SocialMedia.business.abstracts.LikeService;
import com.socialmedia.SocialMedia.core.utilities.mappers.ModelMapperService;
import com.socialmedia.SocialMedia.dataAccess.abstracts.LikeRepository;
import com.socialmedia.SocialMedia.dto.responses.GetAllLikesResponse;
import com.socialmedia.SocialMedia.dto.responses.GetByIdLikeResponse;
import com.socialmedia.SocialMedia.entitites.concretes.Like;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LikeManager implements LikeService {
    private LikeRepository likeRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllLikesResponse> getAll() {
        List<Like> likes = likeRepository.findAll();

        List<GetAllLikesResponse> likesResponse = likes.stream()
                .map(like -> this.modelMapperService.forResponse()
                        .map(like, GetAllLikesResponse.class)).collect(Collectors.toList());
        return likesResponse;
    }

    @Override
    public GetByIdLikeResponse getById(long likeId) {
        return null;
    }
}
