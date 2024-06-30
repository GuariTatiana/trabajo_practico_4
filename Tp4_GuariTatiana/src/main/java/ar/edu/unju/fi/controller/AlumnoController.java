package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumnos;
import ar.edu.unju.fi.model.Alumno;

@Controller 

public class AlumnoController {

	@Autowired
	Alumno nuevaAlumno = new Alumno();
	

@GetMapping({"/formularioAlumno"})
	
	public ModelAndView getFormAlumno() {
	//vista
	ModelAndView modelView =new ModelAndView ("formAlumno");
	//agrega el objeto
	modelView.addObject("nuevaAlumno", nuevaAlumno);
	modelView.addObject("band", false);
	return modelView;		
	}


@PostMapping("/guardarAlumno")
public ModelAndView saveAlumno(@ModelAttribute("nuevaAlumno") Alumno alumnoParaGuardar) {
	
	//Guardar
	ListadoAlumnos.agregarAlumno(alumnoParaGuardar);
	
	//Mostrar el listado
	ModelAndView modelView = new ModelAndView("listaDeAlumnos");
	modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
	
	return modelView;		
}

@GetMapping("/borrarAlumno/{dni}")
public ModelAndView deleteAlumnoDelListado(@PathVariable(name="dni") int dni) {
	//Borrar
	ListadoAlumnos.eliminarAlumno(dni);
	//mostrar el nuevo listado
	ModelAndView modelView = new ModelAndView("listaDeAlumnos");
	modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
	
	return modelView;		
	}

@GetMapping("/modificarAlumno/{dni}")
public ModelAndView editAlumno(@PathVariable(name="dni") int dni) {
	//buscar
	Alumno alumnoParaModificar = ListadoAlumnos.buscarAlumnoPorDni(dni);
	
	//mostrar el nuevo formulario
	ModelAndView modelView = new ModelAndView("formAlumno");
	modelView.addObject("nuevaAlumno", alumnoParaModificar);	
	modelView.addObject("band", true);
	return modelView;		
	}

@PostMapping("/modificarAlumno")
public ModelAndView updateAlumno(@ModelAttribute("nuevaAlumno") Alumno alumnoModificada) {
				
	//guardar
	ListadoAlumnos.modificarAlumno(alumnoModificada);
	
	//mostrar el listado
	ModelAndView modelView = new ModelAndView("listaDeAlumnos");
	modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
	
	return modelView;		
}



}
