package com.oguz.redis_cache.service;

import com.oguz.redis_cache.dto.CreateUserDto;
import com.oguz.redis_cache.dto.UpdateUserDto;
import com.oguz.redis_cache.dto.UserDto;
import com.oguz.redis_cache.mapper.CreateUserMapper;
import com.oguz.redis_cache.mapper.UpdateUserMapper;
import com.oguz.redis_cache.mapper.UserMapper;
import com.oguz.redis_cache.model.User;
import com.oguz.redis_cache.repository.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CreateUserMapper createUserMapper;
    private final UpdateUserMapper updateUserMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, CreateUserMapper createUserMapper, UpdateUserMapper updateUserMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.createUserMapper = createUserMapper;
        this.updateUserMapper = updateUserMapper;
    }

    @Transactional
    @CacheEvict(value = "users", allEntries = true)
    public UserDto register(CreateUserDto createUserDto) {
        User user = createUserMapper.toEntity(createUserDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "users", key = "#root.methodName", unless = "#result==null")
    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    @Cacheable(value = "user_id", key = "#root.methodName + #userId", unless = "#result==null")
    public UserDto getUserById(String userId) {
        return userRepository.findById(userId).map(userMapper::toDto)
                .orElse(null);

    }

    @Transactional
    @CachePut(value = "user_id", key = "'getUserById' + #userId", unless = "#result==null")
    public UserDto updateUser(String userId, UpdateUserDto updateUserDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(userId + " id'li kullanıcı bulunamadı."));

        updateUserMapper.update(user, updateUserDto);
        userRepository.save(user);

        return userMapper.toDto(user);
    }


    @CacheEvict(value = {"users","user_id"} , allEntries = true)
    public String deleteUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(userId + " id'li kullanıcı bulunamadı."));

        userRepository.delete(user);
        return user.getUsername() + " kullanıcı adına sahip " + user.getId() + " id'li kullanıcı silindi.";
    }
}
