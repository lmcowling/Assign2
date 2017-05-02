package com.demo.spring.domain;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;

/**
 * Created by Liam on 28/04/17.
 */

@Entity
public class Review
{
    Long id;

    @NotEmpty
    String reviewText;

    private Film film;

    public Review()
    {

    }

    public Review(String reviewText)
    {
        this.reviewText = reviewText;
    }

    public Review(String reviewText, Film film)
    {
        this.reviewText = reviewText;
        this.film = film;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId()
    {
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

    @ManyToOne
    @JoinColumn(name = "film_id")
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
