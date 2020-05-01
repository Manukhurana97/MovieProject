package com.movie.catalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.catalogue.dao.RentalRepository;
import com.movie.catalogue.model.Rental;
@Service
public class RentalServiceImpl implements RentalService {
	@Autowired
	private RentalRepository repo;
	@Override
	public void createRental(Rental rental) {
		repo.save(rental);

	}
	@Override
	public List<Rental> getByUserId(Integer userid) {
		return repo.findByUserid(userid);
	}

}
