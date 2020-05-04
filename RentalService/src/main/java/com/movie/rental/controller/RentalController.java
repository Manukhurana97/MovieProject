package com.movie.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	@PostMapping("/createrental")
	public Rental createRental(@RequestBody Rental rental) {
		return service.createRental(rental);
	}

	@GetMapping("/get/userid/{id}")
	public List<Rental> getAllById(@PathVariable int id) {
		return service.getRentalByUserId(id);
	}

	@GetMapping("/get/username/{username}")
	public List<Rental> getAllByUsername(@PathVariable String username) {
		return service.findByUsername(username);
	}

	@GetMapping("/get/moviename/{moviename}")
	public List<Rental> getAllByMoviename(@PathVariable String moviename) {
		return service.findByMoviename(moviename);
	}

	@DeleteMapping("/delete/userid/{userid}")
	public void deleteByUserid(@PathVariable int userid) {
		service.deleteByUserid(userid);
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
}
