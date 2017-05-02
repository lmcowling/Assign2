package com.demo.spring.domain;

import
        org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Liam on 27/04/17.
 */
@Entity
public class Film
{
    Long id;

    @NotEmpty
    String title;

    @NotEmpty
    String year;

    private Set<Review> reviews;

    public Film()
    {

    }

    public Film(String title)
    {
        this.title = title;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    public Set<Review> getReviews()
    {
        return reviews;
    }

    public void setReviews(Set<Review> reviews)
    {
        this.reviews = reviews;
    }
}
