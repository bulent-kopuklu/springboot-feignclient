package com.eve.payall.test.feignclient.backend.service.service.dao;

import com.eve.payall.test.feignclient.backend.service.service.dao.entities.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long>
{
    @Query("select p.id from #{#entityName} p")
    List<Long> getAllIds();
}
