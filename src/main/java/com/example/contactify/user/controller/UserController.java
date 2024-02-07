package com.example.contactify.user.controller;

import com.example.contactify.user.service.UserService;
import com.example.contactify.user.dto.UserDetailDto;
import com.example.contactify.user.dto.UserEditDto;
import com.example.contactify.user.dto.UserListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDetailDto create(@RequestBody UserEditDto dto) {
        return userService.save(dto);
    }

    @GetMapping
    public Iterable<UserListDto> getAll() { return userService.getAll(); }

    @GetMapping("/{id}")
    public UserDetailDto get(@PathVariable Long id) { return userService.get(id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { userService.delete(id); }
}