package com.eve.payall.test.feignclient.backend.service.api.exceptions;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String err)
    {
        super(err);
    }
}
