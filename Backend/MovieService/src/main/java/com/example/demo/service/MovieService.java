package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Movie;
import com.example.demo.model.Rental;

public interface MovieService {
public void createMovie(Movie movie);
public List<Movie> getAllMovies();
public Optional<Movie> getMovie(int id);
public List<Movie> getMovieByMovie(String movie);
public List<Movie> getMovieByDirector(String director);
public List<Movie> getMovieByYear(Integer year);
public void updateMovieById(Movie movie);
public void deleteMovieById(int id);

}
