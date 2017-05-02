package com.demo.spring.service;

import com.demo.spring.domain.Review;
import com.demo.spring.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liam on 30/04/17.
 */

@Service
public class ReviewService
{
    @Autowired
    ReviewRepository reviewRepository;

    public Review save(Review review)
    {

        return reviewRepository.save(review);
    }

    public List<Review> findAll()
    {
        return reviewRepository.findAll();
    }

    public void delete(Review review)
    {
        reviewRepository.delete(review);
    }



}
