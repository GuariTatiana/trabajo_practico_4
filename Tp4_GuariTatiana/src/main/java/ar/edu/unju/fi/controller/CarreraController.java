package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;

@Controller 

public class CarreraController {
	
	@Autowired
	Carrera nuevaCarrera = new Carrera();
	

@GetMapping({"/formularioCarrera"})
	
/*
 * //necesitamos que pase los objetos de un lado a otro //ModelAndView es una
 * clase que trabaja en el paquete que gestiona vista
 */
	public ModelAndView getFormCarrera() {
	//vista
	ModelAndView modelView =new ModelAndView ("formCarrera");
	//agrega el objeto
	modelView.addObject("nuevaCarrera", nuevaCarrera);
	modelView.addObject("band", false);
	return modelView;		
	}


@PostMapping("/guardarCarrera")
public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraParaGuardar) {
	
	//Guardar
	ListadoCarreras.agregarCarrera(carreraParaGuardar);
	
	//Mostrar el listado
	ModelAndView modelView = new ModelAndView("listaDeCarreras");
	modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());	
	
	return modelView;		
}

@GetMapping("/borrarCarrera/{codigo}")
public ModelAndView deleteCarreraDelListado(@PathVariable(name="codigo") String codigo) {
	//Borrar
	ListadoCarreras.eliminarCarrera(codigo);
	//mostrar el nuevo listado
	ModelAndView modelView = new ModelAndView("listaDeCarreras");
	modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());	
	
	return modelView;		
	}

@GetMapping("/modificarCarrera/{codigo}")
public ModelAndView editCarrera(@PathVariable(name="codigo") String codigo) {
	//buscar
	Carrera carreraParaModificar = ListadoCarreras.buscarCarreraPorCodigo(codigo);
	
	//mostrar el nuevo formulario
	ModelAndView modelView = new ModelAndView("formCarrera");
	modelView.addObject("nuevaCarrera", carreraParaModificar);	
	modelView.addObject("band", true);
	return modelView;		
	}

@PostMapping("/modificarCarrera")
public ModelAndView updateCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraModificada) {
				
	//guardar
	ListadoCarreras.modificarCarrera(carreraModificada);
	
	//mostrar el listado
	ModelAndView modelView = new ModelAndView("listaDeCarreras");
	modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());	
	
	return modelView;		
}



}
