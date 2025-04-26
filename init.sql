-- Veritabanı oluşturuluyor
CREATE DATABASE redis_cache;

-- Oluşturulan veritabanına bağlanılıyor
\c redis_cache;

-- users tablosu oluşturuluyor
CREATE TABLE users (
                       id UUID PRIMARY KEY,
                       name VARCHAR(255),
                       last_name VARCHAR(255),
                       username VARCHAR(255),
                       password VARCHAR(255),
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP
);
