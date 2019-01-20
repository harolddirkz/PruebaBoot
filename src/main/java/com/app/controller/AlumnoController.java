package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.entities.Alumno;
import com.app.service.AlumnoService;

@Controller
@RequestMapping(value = "/alumno")
public class AlumnoController {

	@Autowired
	AlumnoService alumnoService;

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView vistaAlumnoGuardar() {
		ModelAndView model = new ModelAndView("views/alumno/alumnosave");

		return model;
	}

	@RequestMapping(value = "/saveAlumno", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> guardarAlumno() {
		Map<String, Object> map = new HashMap<String, Object>();

		Alumno alumno = new Alumno();
		Alumno alumno2 = new Alumno();

		alumno.setNombre("Pablillo");
		alumno.setApellido("cacinero");
		alumno.setDni("70265695");

		alumno2 = alumnoService.saveAlumno(alumno);

		System.out.println(alumno2.getIdalumno());

		// System.out.println("hola!");

		map.put("status", "1");

		return map;
	}

}
