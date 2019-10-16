package com.eve.payall.test.feignclient.backend.service.service.dao.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@ToString
public class UserDto
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private int age;

    @Column(name = "create_at")
    private LocalDateTime createdAt;
}
