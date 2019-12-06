package com.codingdojo.lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.lookify.model.Song;

public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	List<Song> findTop10ByOrderByRatingDesc();
	List<Song> findByArtistContaining(String artist);
}
