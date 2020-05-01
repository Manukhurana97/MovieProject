package com.movie.catalogue.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Movie {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String movie;
private String category;
private String director;
private int year;
private float rating;
private float rent;

@OneToMany
(cascade = CascadeType.PERSIST, mappedBy = "movie")
@JsonIgnore
private Set<Rental> rental;
public Movie(int id, String movie, String category, String director, int year, float rating, float rent) {
	super();
	this.id = id;
	this.movie = movie;
	this.category = category;
	this.director = director;
	this.year = year;
	this.rating = rating;
	this.rent = rent;

	rental = new HashSet<Rental>();
}

}
