package com.demo.spring.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Liam on 27/04/17.
 */
@Entity
public class Film
{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty
    String title;
    @NotEmpty
    String year;

    @OneToMany(targetEntity = Review.class, mappedBy = "film", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Review> reviews;


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
}
