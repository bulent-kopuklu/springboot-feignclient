package com.eve.payall.test.feignclient.backend.sdk;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "users", url = "localhost:8080")
public interface UserServiceClient extends UserService
{
}
