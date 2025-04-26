package com.oguz.redis_cache.controller;

import com.oguz.redis_cache.dto.CreateUserDto;
import com.oguz.redis_cache.dto.UpdateUserDto;
import com.oguz.redis_cache.dto.UserDto;
import com.oguz.redis_cache.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {

        return ResponseEntity.ok(userService.register(createUserDto));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/id")
    public ResponseEntity<UserDto> getUserById(@RequestParam String userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(value = "userId") String userId,
                                              @RequestBody UpdateUserDto updateUserDto){
        return ResponseEntity.ok(userService.updateUser(userId,updateUserDto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "userId") String userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }

}
