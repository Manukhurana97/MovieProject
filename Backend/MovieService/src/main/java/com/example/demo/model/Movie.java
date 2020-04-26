package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
@OneToMany
(cascade = CascadeType.PERSIST, mappedBy = "movie")
private Set<Rental> rental;
public Movie(int id, String movie, String category, String director, int year, float rating) {
	super();
	this.id = id;
	this.movie = movie;
	this.category = category;
	this.director = director;
	this.year = year;
	this.rating = rating;
	rental = new HashSet<Rental>();
}

}
