package com.skilldistillery.film.controllers;

import java.time.LocalDateTime;
import java.util.List;

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
	public String home() {
		return "home";
		
	}
	
	@RequestMapping("updateMenu.do")
	public String updateMenu(Model model, Integer film) {
		System.out.println(film + "**********");
		Film movie = filmDao.findFilmById(film);
		System.out.println(movie + "********");
		model.addAttribute("Id", movie);
		return "updateFilm";
	}
	
	@RequestMapping(path = "GetFilmId.do", method = RequestMethod.GET)
	public String getFilmId(Model model, int ID) {
		Film film = filmDao.findFilmById(ID);
		model.addAttribute("Id", film);
		return "getFilmId";
		
	}
	
	@RequestMapping(path = "GetFilmByKeyword.do", method = RequestMethod.GET)
	public String getFilmByKeyword(Model model, String keyword) {
		List<Film> film = filmDao.findFilmByKeyword(keyword);
		model.addAttribute("films", film);
		return "searchByKeyword";
		
	}
	
	@RequestMapping(path = "delete.do", method = RequestMethod.POST)
	public String deleteFilm(Integer film) {
		boolean deleteWorks = filmDao.deleteFilm(film);
		if (deleteWorks) {
			return "home";
		}
		else {
			return "error";
		}
	}
	
	@RequestMapping(path="updateFilm.do" , method=RequestMethod.POST)
	public String updateFilm(Model model, Integer film, String title, String description, int releaseYear, String languageId, String rating ) {
		Film movie = filmDao.findFilmById(film);
		movie.setTitle(title);
		movie.setDescription(description);
		movie.setReleaseYear(releaseYear);
		movie.setLanguageId(convertLangId(languageId, movie));
		movie.setRating(rating);
		boolean updateWorks = filmDao.updateFilm(movie);
		model.addAttribute("Id", movie);
		if(updateWorks) {
			return "home";
		}
		return "error";
	}
	

	@RequestMapping(path = "CreateNewFilm.do", method = RequestMethod.POST)
	public String createNewFilm(Model model, String title, String description, int releaseYear, String languageId, String rating ) {
		Film film = new Film();
		film.setTitle(title);
		film.setDescription(description);
		film.setReleaseYear(releaseYear);
		film.setLanguageId(convertLangId(languageId, film));
		film.setRating(rating);
		filmDao.createFilm(film);
		model.addAttribute("createID", film);
		return "createNewFilm";
		
	}
	

	
	public int convertLangId(String langId, Film film) {
		int newLanguageId = 0;
		switch(langId) {
		case "English":
			newLanguageId = 1;
			film.setLanguageName("English");
			break;
		case "Italian":
			newLanguageId = 2;
			film.setLanguageName("Italian");
			break;
		case "Japanese":
			newLanguageId = 3;
			film.setLanguageName("Japanese");
			break;
		case "Mandarin":
			newLanguageId = 4;
			film.setLanguageName("Mandarin");
			break;
		case "French":
			newLanguageId = 5;
			film.setLanguageName("French");
			break;
		case "German":
			newLanguageId = 6;
			film.setLanguageName("German");
			break;
		}
		return newLanguageId;
	}
	
}
