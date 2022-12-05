package com.programmers.backend.domain.client.entity;

import com.programmers.backend.domain.client.dto.ClientInsertRequestDto;

import java.time.LocalDateTime;

public class Client {
    private long id;
    private String nickname;
    private int age;
    private LocalDateTime createdAt;

    public Client(long id, String nickname, int age, LocalDateTime createdAt) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
        this.createdAt = createdAt;
    }

    public Client(ClientInsertRequestDto clientInsertRequestDto) {
        this.nickname = clientInsertRequestDto.nickname();
        this.age = clientInsertRequestDto.age();
        this.createdAt = LocalDateTime.now().withNano(0);
    }

    public long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

