package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {
	
	@Autowired
	Materia nuevaMateria = new Materia();
	

@GetMapping({"/formularioMateria"})
	
	public ModelAndView getFormMateria() {
	//vista
	ModelAndView modelView =new ModelAndView ("formMateria");
	//agrega el objeto
	modelView.addObject("nuevaMateria", nuevaMateria);
	
	//agregando objetos que usaremos
	modelView.addObject("listadoDocentes",ListadoDocentes.listarDocentes());
	modelView.addObject("listadoCarreras",ListadoCarreras.listarCarreras());
	
	modelView.addObject("band", false);
	return modelView;		
	}


@PostMapping("/guardarMateria")
public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia materiaParaGuardar) {
	
	//Guardar
	ListadoMaterias.agregarMateria(materiaParaGuardar);
	
	//Mostrar el listado
	ModelAndView modelView = new ModelAndView("listaDeMaterias");
	modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());	
	
	return modelView;		
}

@GetMapping("/borrarMateria/{codigo}")
public ModelAndView deleteMateriaDelListado(@PathVariable(name="codigo") String codigo) {
	//Borrar
	ListadoMaterias.eliminarMateria(codigo);
	//mostrar el nuevo listado
	ModelAndView modelView = new ModelAndView("listaDeMaterias");
	modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());	
	
	return modelView;		
	}

@GetMapping("/modificarMateria/{codigo}")
public ModelAndView editMateria(@PathVariable(name="codigo") String codigo) {
	//buscar
	Materia materiaParaModificar = ListadoMaterias.buscarMateriaPorCodigo(codigo);
	
	//mostrar el nuevo formulario
	ModelAndView modelView = new ModelAndView("formMateria");
	modelView.addObject("nuevaMateria", materiaParaModificar);	
	modelView.addObject("band", true);
	return modelView;		
	}

@PostMapping("/modificarMateria")
public ModelAndView updateMateria(@ModelAttribute("nuevaMateria") Materia materiaModificada) {
				
	//guardar
	ListadoMaterias.modificarMateria(materiaModificada);
	
	//mostrar el listado
	ModelAndView modelView = new ModelAndView("listaDeMaterias");
	modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());	
	
	return modelView;		
}




}
