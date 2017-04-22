package com.demo.spring.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Liam on 21/04/17.
 */

public interface UserRepository extends JpaRepository<User,Long>
{
    List<User> findByForenameAndPassword(String forename, String password);
}
