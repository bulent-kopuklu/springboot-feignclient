package com.eve.payall.test.feignclient.backend.sdk.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    private String firstName;
    private String lastName;
    private int age;
}
