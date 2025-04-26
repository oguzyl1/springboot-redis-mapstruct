package com.oguz.redis_cache.mapper;

import com.oguz.redis_cache.dto.CreateUserDto;
import com.oguz.redis_cache.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateUserMapper {

    CreateUserDto toDto(User user);
    User toEntity(CreateUserDto createUserDto);

}
