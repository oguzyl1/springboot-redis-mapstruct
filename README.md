# springboot-redis-mapstruct-demo

> A demo Spring Boot microservice showcasing Redis caching and MapStruct-based DTO ↔ Entity mapping.

---

## ❓ About

Demonstrates caching JPA user data in Redis for performance and using MapStruct for zero-boilerplate, compile-safe DTO ↔ Entity mapping in a Spring Boot service.  

---

## 🚀 Features

- **CRUD** operations on User entities 
- **Redis Cache** for `getUsers()` and `getUserById(...)` with `@Cacheable`, `@CachePut`, `@CacheEvict` 
- **MapStruct** mappers for `CreateUserDto`, `UpdateUserDto`, `UserDto` ↔ `User` entity 
- **Docker Compose** setup for Redis, PostgreSQL & Adminer 
- YAML-based configuration 

---

## 🛠️ Tech Stack 

| Layer       | Tech                          |  
| ----------- | ----------------------------- |  
| Language    | Java 17                        |  
| Framework   | Spring Boot 3, Spring Data JPA, Cache |  
| Cache Store | Redis                         |  
| Mapping     | MapStruct                     |  
| Database    | PostgreSQL                    |  
| Container   | Docker & Docker Compose       |  
| Build Tool  | Maven                         |  


