package com.movie.rental.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rental {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private int userid;
private int movieid;
private String username;
private String moviename;
private int year;
private String director;
private Date rentaldate;
private Date duedate;
private float rent;
}
