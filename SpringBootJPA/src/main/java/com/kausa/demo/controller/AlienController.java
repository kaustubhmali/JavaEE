package com.kausa.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kausa.demo.dao.AlienRepo;
import com.kausa.demo.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}
	
	@GetMapping(path="/aliens")
	public List<Alien> getAliens() {
		
		return repo.findAll();
	}
	
	
	@RequestMapping("/alien/{aid}")
	public Optional<Alien> getAlienByID(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
	@RequestMapping("/updateAlien")
	public String updateAlien(Alien alien) {
		repo.save(alien);
		return "updateAlien.jsp";
	}
	
	@RequestMapping("/deleteAlien")
	public String deleteAlien(@RequestParam int aid) {
		Alien alien = repo.findById(aid).orElse(new Alien());
		repo.delete(alien);
		return "home.jsp";
		
	}
}
