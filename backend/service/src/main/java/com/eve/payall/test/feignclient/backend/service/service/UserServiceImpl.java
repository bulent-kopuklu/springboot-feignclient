package com.eve.payall.test.feignclient.backend.service.service;

import com.eve.payall.test.feignclient.backend.sdk.UserService;
import com.eve.payall.test.feignclient.backend.sdk.models.User;
import com.eve.payall.test.feignclient.backend.service.api.exceptions.UserNotFoundException;
import com.eve.payall.test.feignclient.backend.service.service.dao.UserRepository;
import com.eve.payall.test.feignclient.backend.service.service.dao.entities.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService
{
    final UserRepository repository;

    public UserServiceImpl(UserRepository repository)
    {
        this.repository = repository;
    }

    public List<Long> getUsers()
    {
        log.info("service.getUsers");
        return repository.getAllIds();
    }

    @Override
    public Long addUser(User user)
    {
        log.info("service.addUser user:{}", user);
        return repository.save(Converter.convert(user)).getId();
    }

    @Override
    public void removeUser(@PathVariable("id") long id)
    {
        log.info("service.removeUser. userid:{}", id);
        repository.deleteById(id);
    }

    @Override
    public User getUser(@PathVariable("id") long id)
    {
        log.info("service.getUser. userid:{}", id);
        return Converter.convert(repository.findById(id).orElseThrow(() ->
                new UserNotFoundException(id)
        ));
    }
}
