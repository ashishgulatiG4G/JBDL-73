package com.major.user_service.controller;

import com.major.user_service.dto.CreateUserRequest;
import com.major.user_service.dto.GetUserResponse;
import com.major.user_service.models.User;
import com.major.user_service.service.UserService;
import com.major.user_service.utils.Utils;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Sign-up API
     */
    @PostMapping("/create")
    public void createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        userService.create(Utils.convertUserCreateRequest(createUserRequest));
    }

    /**
    Profile information
     */
    @GetMapping("/profile-info")
    public GetUserResponse getProfile() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user = userService.getById(user.getId());
        return Utils.convertToGetUserResponse(user);
    }


    /**
        To be used by other services for authentication
     */
    @GetMapping(value = "/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetails getUserByUsername(@PathVariable("username") String username) {
         return userService.loadUserByUsername(username);
    }


}
