package com.demo.spring.service;


import com.demo.spring.domain.Film;
import com.demo.spring.domain.FilmForm;
import com.demo.spring.domain.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liam on 27/04/17.
 */
@Service
public class FilmService
{
    @Autowired
    FilmRepository filmRepository;

    public Film save(Film film)
    {
        return filmRepository.save(film);
    }

    public List<Film> findAll()
    {
        return filmRepository.findAll();
    }

    public void delete(Film film)
    {
        filmRepository.delete(film);
    }

    public List<Film> searchFilms(FilmForm film)
    {
        return filmRepository.searchFilms(film.getTitle(), film.getYear());
    }
}
