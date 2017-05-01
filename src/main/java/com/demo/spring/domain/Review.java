package com.demo.spring.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by web on 28/04/17.
 */
@Entity
public class Review
{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty
    String reviewText;

    @ManyToOne
    @JoinColumn(name = "film_id")
    Film film;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
