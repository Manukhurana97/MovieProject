package com.movie.catalogue.model;


import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Rental {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private int userid;
private Date duedate;

@ManyToOne
private Movie movie;
public Rental(int userid,Movie movie) {
	super();
	Date curr = new Date();
	Calendar c = Calendar.getInstance();
	c.setTime(curr);
	c.add(Calendar.DATE, 7); //Setting return date after 7 days
	duedate = c.getTime();
	this.userid = userid;
	this.movie = movie;
}

}
