package com.movie.catalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.catalogue.model.Movie;
import com.movie.catalogue.model.Rental;
import com.movie.catalogue.service.MovieService;
import com.movie.catalogue.service.RentalService;

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
//	    Movie m = r.getMovie();
//	    m.getRental().add(r);
	    rservice.createRental(r);
//	    mservice.createMovie(m);
		
	}
	@GetMapping("/rent/{userid}")
	public List<Rental> getByUserId(@PathVariable int userid)
	{
		return rservice.getByUserId(userid);
	}

}
