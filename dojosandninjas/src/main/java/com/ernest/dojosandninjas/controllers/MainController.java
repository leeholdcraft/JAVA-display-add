package com.ernest.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ernest.dojosandninjas.models.Dojo;
import com.ernest.dojosandninjas.models.Ninja;
import com.ernest.dojosandninjas.services.DojoService;
import com.ernest.dojosandninjas.services.NinjaService;
@Controller
public class MainController {
	@Autowired
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	public MainController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	
	@RequestMapping("/")
	public String index() {
		return "test.jsp";
	}
	
	//==========================================================================
	//add new dojo
	//==========================================================================
	
	@RequestMapping("dojos/new")
	public String newDojo(@ModelAttribute("dojos") Dojo dojo) {
		return "/dojoninja/newdojo.jsp";
	}
	
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
	public String dojoCreate(@Valid @ModelAttribute("dojos") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojoninja/newdojo.jsp";
		}
		else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	//===============================================================================
	//add new ninja
	//===============================================================================
	
	@RequestMapping("/ninjas/new")
	public String newNinja(Model model) {
		model.addAttribute("ninjas", new Ninja());
		
		Iterable <Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "/dojoninja/newninja.jsp";
	}
	
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String ninjaCreate(@Valid @ModelAttribute("ninjas") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojoninja/newninja.jsp";
		}
		else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
	//==============================================================================
	//display dojo with all of its ninjas
	//==============================================================================
	
	@RequestMapping("dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojos = dojoService.findDojos(id);
		model.addAttribute("dojos", dojos);
		
		return "/dojoninja/showAll.jsp";
	}
	
//	@RequestMapping("dojos/{id}")
//	public String show(@PathVariable("id") Long id, Model model) {
//		Ninja ninjas = ninjaService.findNinja(id);
//		model.addAttribute("ninjas", ninjas);
//		
//		return "/dojoninja/showAll.jsp";
//	}
}
	
	
	
	
	
	
	
	

