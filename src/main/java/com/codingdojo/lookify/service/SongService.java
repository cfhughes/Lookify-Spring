package com.codingdojo.lookify.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.model.Artist;
import com.codingdojo.lookify.model.Song;
import com.codingdojo.lookify.repository.ArtistRepository;
import com.codingdojo.lookify.repository.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepo;
	private final ArtistRepository artistRepo;
	
	public SongService(SongRepository repo, ArtistRepository artistRepo) {
		this.artistRepo = artistRepo;
		this.songRepo = repo;
	}
	
	public List<Song> allSongs() {
		return songRepo.findAll();
	}
	public Song findSong(Long id) {
		Song song = songRepo.findById(id).orElse(null);
		song.setArtistString(song.getArtist().getName());
		return song;
	}
	public List<Song> topTenByRating() {
		return songRepo.findTop10ByOrderByRatingDesc();
	}
//	public List<Song> songsContainingArtist(String artist) {
//		return songRepo.findByArtistContaining(artist);
//	}
	public Song createSong(Song song) {
		Artist artist = artistRepo.findOneByName(song.getArtistString());
		if (artist == null) {
			artist = new Artist();
			artist.setName(song.getArtistString());
			artistRepo.save(artist);
		}
		song.setArtist(artist);
		return songRepo.save(song);
	}
//	public Song updateSong(Song song) {
//		return songRepo.save(song);
//	}
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	public List<Object[]> getAllSongsWithArtists(){
		return songRepo.songAndArtistJoin();
	}
	
}

