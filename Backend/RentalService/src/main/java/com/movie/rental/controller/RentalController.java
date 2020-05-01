package com.movie.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.rental.model.Rental;
import com.movie.rental.service.RentalService;

@RestController
public class RentalController {
@Autowired
private RentalService service;
@PostMapping("/rental/create")
public Rental createRental(@RequestBody Rental rental)
{
	return service.createRental(rental);
}
@GetMapping("/rental/get/{id}")
public List<Rental> getAllById(@PathVariable int id)
{
	return service.getRentalById(id);
}
}
