package com.demo.spring.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Liam on 27/04/17.
 */

public interface FilmRepository extends JpaRepository<Film,Long>
{
    List<Film> findByTitleAndYear(String title, String year);

    @Query("SELECT f FROM Film f WHERE f.title LIKE ?1 and f.year LIKE ?2")
    List<Film> searchFilms(String title, String year);
}
