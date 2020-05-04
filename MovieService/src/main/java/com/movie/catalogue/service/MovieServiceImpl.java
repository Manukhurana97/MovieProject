package com.movie.catalogue.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.catalogue.dao.MovieRepository;
import com.movie.catalogue.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository repo;

	@Override
	public void createMovie(Movie movie) {
		repo.saveAndFlush(movie);

	}

	@Override
	public Optional<Movie> getMovie(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Movie> getMovieByMovie(String movie) {
		return repo.findByMovie(movie);
	}

	@Override
	public List<Movie> getMovieByDirector(String director) {
		return repo.findByDirector(director);
	}

	@Override
	public List<Movie> getMovieByYear(Integer year) {
		return repo.findByYear(year);
	}

	@Override
	public void updateMovieById(Movie movie) {
		repo.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		return repo.findAll();
	}

	@Override
	public void deleteMovieById(int id) {

		repo.deleteById(id);
	}

}
