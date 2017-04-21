package com.demo.spring.service;

import com.demo.spring.domain.User;
import com.demo.spring.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liam on 21/04/17.
 */
@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public User save(User u)
    {
        return userRepository.save(u);
    }

    public List<User> findAll()
    {
        return userRepository.findAll();
    }
}
