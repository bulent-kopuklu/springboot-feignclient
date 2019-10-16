package com.eve.payall.test.feignclient.backend.service.api.controllers;

import com.eve.payall.test.feignclient.backend.sdk.UserService;
import com.eve.payall.test.feignclient.backend.sdk.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserServiceResource implements UserService
{
    final UserService service;

    public UserServiceResource(UserService service)
    {
        log.info("UserServiceResource.ctor");
        this.service = service;
    }

    public List<Long> getUsers()
    {
        log.info("controller.getUsers");
        return service.getUsers();
    }

    @Override
    public Long addUser(User user)
    {
        log.info("controller.addUser. user:{}", user);
        return service.addUser(user);
    }

    //@PathVariable("id")
    @Override
    public void removeUser(long id)
    {
        log.info("controller.removeUser. userid:{}", id);
        service.removeUser(id);
    }

    @Override
    public User getUser(long id)
    {
        log.info("controller.getUser. userid:{}", id);
        return service.getUser(id);
    }
}
