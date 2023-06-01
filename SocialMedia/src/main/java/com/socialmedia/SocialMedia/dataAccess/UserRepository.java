package com.socialmedia.SocialMedia.dataAccess;

import com.socialmedia.SocialMedia.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);

}
