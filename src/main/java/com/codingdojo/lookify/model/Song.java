package com.codingdojo.lookify.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="songs")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Artist artist;
	
	@Transient
	private String artistString;
	
	@Size(min = 1 ,max= 200)
	private String name;
	
	@Range(min = 1, max = 10)
	private int rating;

	public Song() {
	}

	public Song(Long id, Artist artist, @Size(min = 1, max = 200) String name,
			@Range(min = 1, max = 10) int rating) {
		this.id = id;
		this.artist = artist;
		this.name = name;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getArtistString() {
		return artistString;
	}

	public void setArtistString(String artistString) {
		this.artistString = artistString;
	}
	
	
	

}
