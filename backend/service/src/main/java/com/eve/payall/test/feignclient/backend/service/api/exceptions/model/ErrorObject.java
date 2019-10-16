package com.eve.payall.test.feignclient.backend.service.api.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorObject
{
    private Integer status;
    private String message;
    private LocalDateTime timestamp;
}
