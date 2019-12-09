package com.codingdojo.lookify.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.model.Song;
import com.codingdojo.lookify.service.SongService;

@Controller
public class SongController {
	
	private final SongService songService;
	
	@Autowired
	public SongController(SongService service) {
		this.songService = service;
	}
	
	@RequestMapping("/")
	public String index() {
		return "/songs/index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String songs(Model model) {
		List<Object[]> songAndArtist = songService.getAllSongsWithArtists();
		model.addAttribute("songs", songAndArtist);
		return "/songs/songs.jsp";
	}
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", songService.findSong(id));
		return "/songs/show.jsp";
	}
	@RequestMapping("/songs/search")
	public String search(@RequestParam("artist") String artist, Model model) {
		//model.addAttribute("songs",	songService.songsContainingArtist(artist));
		model.addAttribute("artist", artist);
		return "/songs/searched.jsp";
	}
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "/songs/new.jsp";
	}
	@RequestMapping(value="/songs", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors())
			return "/songs/new.jsp";
		songService.createSong(song);
		return "redirect:/dashboard";
	}
	@RequestMapping("/songs/topTen")
	public String topTen(Model model) {
		model.addAttribute("songs", songService.topTenByRating());
		return "/songs/topTen.jsp";
	}
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/songs";
	}
	
}
