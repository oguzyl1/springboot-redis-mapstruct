package com.oguz.redis_cache.mapper;

import com.oguz.redis_cache.dto.UpdateUserDto;
import com.oguz.redis_cache.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UpdateUserMapper {

    void update(@MappingTarget User entity, UpdateUserDto dto);

}
