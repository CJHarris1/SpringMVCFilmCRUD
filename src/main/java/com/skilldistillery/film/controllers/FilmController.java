package com.skilldistillery.film.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
	private FilmDAO filmDao;
	
	
	@RequestMapping({"/", "home.do"})
	public String home(Model model) {
		model.addAttribute("TEST", "Hello, Spring MVC!");
		return "home";
		
	}
	
	@RequestMapping(path = "GetFilmId.do", params = "ID", method = RequestMethod.GET)
	public String getFilmId(Model model, int ID) {
		Film film = filmDao.findFilmById(ID);
		model.addAttribute("ID", film);
		return "getFilmId";
		
	}
	
	@RequestMapping(path = "createNewFilm.do",  method = RequestMethod.POST)

	public String createNewFilm(Model model, String title, String description, int releaseYear, String languageId, String rating ) {
		
		Film film = new Film();
		film.setTitle(title);
		film.setDescription(description);
		film.setReleaseYear(releaseYear);
		film.setLanguageId(convertLangId(languageId));
		film.setRating(rating);
		System.out.println(rating);
		filmDao.createFilm(film);
		model.addAttribute("createID", film);
		return "createNewFilm";
		
	}
	
	public int convertLangId(String langId) {
		int newLanguageId = 0;
		switch(langId) {
		case "English":
			newLanguageId = 1;
			break;
		case "Italian":
			newLanguageId = 2;
			break;
		case "Japanese":
			newLanguageId = 3;
			break;
		case "Mandarin":
			newLanguageId = 4;
			break;
		case "French":
			newLanguageId = 5;
			break;
		case "German":
			newLanguageId = 6;
			break;
		}
		return newLanguageId;
	}
	
	public String convertRating(String rating) {
		return null;
	}
}
