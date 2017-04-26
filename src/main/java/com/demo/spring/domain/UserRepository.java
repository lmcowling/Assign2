package com.demo.spring.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Liam on 21/04/17.
 */

public interface UserRepository extends JpaRepository<User,Long>
{

}
