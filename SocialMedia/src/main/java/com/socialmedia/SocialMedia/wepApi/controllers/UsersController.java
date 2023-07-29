package com.socialmedia.SocialMedia.wepApi.controllers;

import com.socialmedia.SocialMedia.business.UserService;
import com.socialmedia.SocialMedia.dto.requests.CreateUserRequest;
import com.socialmedia.SocialMedia.dto.requests.UpdateUserRequest;
import com.socialmedia.SocialMedia.dto.responses.UserResponse;
import com.socialmedia.SocialMedia.entitites.User;
import com.socialmedia.SocialMedia.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public User createUser(@RequestBody CreateUserRequest newUser) {
        return userService.saveOneUser(newUser);
    }

    @GetMapping("/{userId}")
    public UserResponse getOneUser(@PathVariable Long userId) {
        User user = userService.getOneUser(userId);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return new UserResponse(user);
    }

    @PutMapping("/update/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody UpdateUserRequest newUser) {
        return userService.updateOneUser(userId, newUser);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
        this.userService.deleteOneUser(userId);
    }

    @GetMapping("/activity/{userId}")
    public List<Object> getUserActivity(@PathVariable Long userId) {
        return userService.getUserActivity(userId);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    private void handleUserNotFound() {

    }




}
