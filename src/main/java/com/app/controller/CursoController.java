package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.entities.Alumno;
import com.app.entities.Curso;
import com.app.service.CursoService;

@Controller
@RequestMapping(value = "/curso")
public class CursoController {
	
	@Autowired
	CursoService cursoService;
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView guardar() {
		ModelAndView model = new ModelAndView("views/curso/cursosave");

		return model;
	}

	@RequestMapping(value = "/saveCurso", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> guardarCurso(HttpServletRequest r) {
		Map<String, Object> map = new HashMap<String, Object>();
		//System.out.println("123");
		
		String nombrecurso = r.getParameter("nombrecurso");
		String sigla = r.getParameter("sigla");
		
		Curso curso = new Curso();
		curso.setNombrecurso(nombrecurso);
		curso.setSigla(sigla);
		
		cursoService.saveCurso(curso);
		
		
		System.out.println(nombrecurso);
		
		map.put("status", "1");

		return map;
	}
}
