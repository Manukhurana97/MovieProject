package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.model.Rental;
import com.example.demo.service.MovieService;
import com.example.demo.service.RentalService;

@RestController
@RequestMapping("/rental")
public class RentalController {
	@Autowired
	private RentalService rservice;
	@Autowired
	private MovieService mservice;
	@PostMapping("/create")
	public void createRental(@RequestBody Rental rental)
	{
		Rental r = new Rental(rental.getUserid(),rental.getMovie());
	    Movie m = r.getMovie();
	    m.getRental().add(r);
	    rservice.createRental(r);
	    mservice.createMovie(m);
		
	}

}
