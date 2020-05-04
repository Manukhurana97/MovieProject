package com.movie.rental.service;

import java.util.List;

import com.movie.rental.model.Rental;

public interface RentalService {
	public Rental createRental(Rental rent);

	public List<Rental> getRentalByUserId(Integer userid);

	public List<Rental> findByMoviename(String movie);

	public List<Rental> findByUsername(String user);

	public void deleteByUserid(Integer userid);

	public void deleteById(Integer id);
}
