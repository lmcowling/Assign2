package com.demo.spring.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Liam on 21/04/17.
 */

public interface UserRepository extends JpaRepository<User,Long>
{
    List<User> findByForenameAndPassword(String username, String password);

    @Query("SELECT u FROM User u WHERE u.forename=?1 AND u.password=?2")
    List<User> checkUserInput(String username, String password);

    @Query("SELECT u FROM User u WHERE u.forename LIKE ?1 OR u.surname LIKE ?2")
    List<User> searchUsers(String username, String surname);
}
