package com.skilldistillery.film.controllers;

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
	
}
