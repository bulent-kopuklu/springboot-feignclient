package com.eve.payall.test.feignclient;

import com.eve.payall.test.feignclient.backend.sdk.UserServiceClient;
import com.eve.payall.test.feignclient.backend.sdk.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StopWatch;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@ComponentScan
@Slf4j
public class ClientApplication implements CommandLineRunner
{
    @Autowired
    UserServiceClient client;

    public static void main(String[] args)
    {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        StopWatch sw = new StopWatch();
        sw.start();
        client.addUser(new User("bulentk", "kopuklu", 43));
        sw.stop();
        log.info("add user: {}", sw.getLastTaskTimeMillis());

        sw.start();
        client.addUser(new User("omer", "kurucu", 34));
        sw.stop();
        log.info("add user: {}", sw.getLastTaskTimeMillis());

        sw.start();
        List<Long> lst = client.getUsers();
        sw.stop();
        log.info("get users: {}", sw.getLastTaskTimeMillis());

        for (long id: lst)
        {
            sw.start();
            client.getUser(id);
            sw.stop();
            log.info("get user({}): {}", id, sw.getLastTaskTimeMillis());
        }

        log.info("all: {}", sw.getTotalTimeMillis());
    }
}
