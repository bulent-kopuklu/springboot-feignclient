package com.eve.payall.test.feignclient.backend.service.service.dao.entities;

import com.eve.payall.test.feignclient.backend.sdk.models.User;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class Converter
{
    public static UserDto convert(User user)
    {
        log.info("user:{}", user);

        UserDto dto = new UserDto();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setAge(user.getAge());
        dto.setCreatedAt(LocalDateTime.now());
        return dto;
    }

    public static User convert(UserDto dto)
    {
        log.info("dto:{}", dto);
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setAge(dto.getAge());
        return user;
    }
}
