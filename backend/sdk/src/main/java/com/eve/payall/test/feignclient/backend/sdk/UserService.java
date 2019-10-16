package com.eve.payall.test.feignclient.backend.sdk;

import com.eve.payall.test.feignclient.backend.sdk.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserService
{

    @RequestMapping(method = RequestMethod.GET, value ="/users")
    List<Long> getUsers();

    @RequestMapping(method = RequestMethod.POST, value ="/users")
    Long addUser(@RequestBody User user);

    @RequestMapping(method = RequestMethod.DELETE, value ="/users/{id}")
    void removeUser(@PathVariable("id") long id);

    @RequestMapping(method = RequestMethod.GET, value ="/users/{id}")
    User getUser(@PathVariable("id") long id);



}
