package com.demo.spring.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Liam on 30/04/17.
 */

public interface ReviewRepository extends JpaRepository<Review,Long>
{
//    List<Review> findByTitleAndYear(String title, String year);
}
