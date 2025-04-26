package com.oguz.redis_cache.mapper;


import com.oguz.redis_cache.dto.UserDto;
import com.oguz.redis_cache.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> userList);
}
