package com.codingdojo.lookify.repository;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.lookify.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long>{

	Artist findOneByName(String name);
}
