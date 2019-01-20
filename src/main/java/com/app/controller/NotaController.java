package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.AlumnoService;

@Controller
@RequestMapping(value = "/nota")
public class NotaController {
	
	@Autowired
	AlumnoService alumnoService;
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView guardar() {
		ModelAndView model = new ModelAndView("views/nota/notasave");
		System.out.println(alumnoService.listarAlumnos().size());
		
		if(alumnoService.listarAlumnos()!=null) {
			System.out.println("hizo la consulta");
		} else {
			System.out.println("error!!");
		}
		
		try {
			model.addObject("listaalumnos", alumnoService.listarAlumnos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return model;
	}
	
	

}
