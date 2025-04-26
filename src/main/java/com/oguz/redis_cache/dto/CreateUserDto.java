package com.oguz.redis_cache.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto implements Serializable {
    private String name;
    private String lastName;
    private String username;
    private String password;
}
