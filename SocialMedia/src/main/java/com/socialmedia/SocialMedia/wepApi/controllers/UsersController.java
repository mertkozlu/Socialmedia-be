package com.socialmedia.SocialMedia.wepApi.controllers;

import com.socialmedia.SocialMedia.dataAccess.abstracts.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
