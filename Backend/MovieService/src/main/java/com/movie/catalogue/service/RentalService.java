package com.movie.catalogue.service;

import java.util.List;

import com.movie.catalogue.model.Rental;

public interface RentalService {
	public void createRental(Rental rental);
	public List<Rental> getByUserId(Integer userid);
}
