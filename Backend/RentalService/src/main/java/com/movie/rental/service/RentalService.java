package com.movie.rental.service;

import java.util.List;

import com.movie.rental.model.Rental;

public interface RentalService {
public Rental createRental(Rental rent);
public List<Rental> getRentalById(Integer userid);
}
