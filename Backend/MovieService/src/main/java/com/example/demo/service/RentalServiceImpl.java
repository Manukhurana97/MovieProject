package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RentalRepository;
import com.example.demo.model.Rental;
@Service
public class RentalServiceImpl implements RentalService {
	@Autowired
	private RentalRepository repo;
	@Override
	public void createRental(Rental rental) {
		repo.save(rental);

	}

}
