package com.socialmedia.SocialMedia.business.concretes;

import com.socialmedia.SocialMedia.business.abstracts.UserService;
import com.socialmedia.SocialMedia.dto.responses.GetAllLikesResponse;
import com.socialmedia.SocialMedia.dto.responses.GetByIdUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    @Override
    public List<GetAllLikesResponse> getAll() {
        return null;
    }

    @Override
    public GetByIdUserResponse getById(long userId) {
        return null;
    }
}
