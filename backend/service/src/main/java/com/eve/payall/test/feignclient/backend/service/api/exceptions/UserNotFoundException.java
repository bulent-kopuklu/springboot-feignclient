package com.eve.payall.test.feignclient.backend.service.api.exceptions;

public class UserNotFoundException extends ResourceNotFoundException
{
    public UserNotFoundException(Long id)
    {
        super("Could not found user. id:" + id);
    }
}
