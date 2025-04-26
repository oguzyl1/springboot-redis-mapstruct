package com.oguz.redis_cache.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    @Column(name = "last_name")

    private String lastName;
    private String username;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
