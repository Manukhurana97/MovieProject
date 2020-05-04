package com.movie.rental.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.rental.client.CatalogueClient;
import com.movie.rental.dao.RentalRepository;
import com.movie.rental.model.Movie;
import com.movie.rental.model.Rental;

@Service
public class RentalServiceImpl implements RentalService {
	@Autowired
	private RentalRepository repo;
	@Autowired
	private CatalogueClient client;
	private static final Logger log = LoggerFactory.getLogger(RentalService.class);
	@Override
	public Rental createRental(Rental rent) {
		System.out.println(rent.getId());
		Optional<Movie> m = client.getMovieById(rent.getMovieid());
		if(m.isEmpty()) log.error("No such movie");
		Movie movie = m.get();
		Rental rental = new Rental();
		Date curr = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(curr);
		c.add(Calendar.DATE, 7); // Setting return date after 7 days
		Date duedate = c.getTime();
		log.debug(duedate.toString());
		rental.setUserid(rent.getUserid());
		rental.setMovieid(rent.getMovieid());
		rental.setUsername(rent.getUsername());

		rental.setMoviename(movie.getMovie());
		rental.setYear(movie.getYear());
		rental.setDirector(movie.getDirector());
		rental.setRentaldate(curr);
		rental.setDuedate(duedate);
		rental.setRent(movie.getRent());

		return repo.save(rental);
	}

	@Override
	public List<Rental> getRentalByUserId(Integer userid) {
		return repo.findByUserid(userid);
	}

	@Override
	public List<Rental> findByMoviename(String movie) {
		return repo.findByMoviename(movie);
	}

	@Override
	public List<Rental> findByUsername(String user) {
		return repo.findByUsername(user);
	}

	@Override
	public void deleteByUserid(Integer userid) {
		repo.deleteAll(getRentalByUserId(userid));
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

}
