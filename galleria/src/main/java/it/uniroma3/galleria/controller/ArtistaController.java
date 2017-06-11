package it.uniroma3.galleria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.service.ArtistaService;

@Controller
public class ArtistaController {
	
	@Autowired
	private ArtistaService artistaservice;
	
	@GetMapping("/artista.jsp")
	public String showForm(Artista artista){
		return "/form.jsp";
	}
	
	@PostMapping("/artista.jsp")
	public String checkArtistaInfo(@Valid  @ModelAttribute Artista artista, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
	      return "/form.jsp";
	    }
	    else {
	      model.addAttribute(artista);
	      artistaservice.add(artista);
	    }
		
		return "/results.jsp";
	}

}
