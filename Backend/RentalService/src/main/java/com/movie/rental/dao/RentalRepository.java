package com.movie.rental.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.rental.model.Rental;
@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
public List<Rental> findByUserid(Integer userid);
}
