package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Docente;

@Controller 

public class DocenteController {
		
		@Autowired
		Docente nuevaDocente = new Docente();
		

	@GetMapping({"/formularioDocente"})
		
		public ModelAndView getFormDocente() {
		//vista
		ModelAndView modelView =new ModelAndView ("formDocente");
		//agrega el objeto
		modelView.addObject("nuevaDocente", nuevaDocente);
		modelView.addObject("band", false);
		return modelView;		
		}


	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute("nuevaDocente") Docente docenteParaGuardar) {
		
		//Guardar
		ListadoDocentes.agregarDocente(docenteParaGuardar);
		
		//Mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());	
		
		return modelView;		
	}

	@GetMapping("/borrarDocente/{legajo}")
	public ModelAndView deleteDocenteDelListado(@PathVariable(name="legajo") String legajo) {
		//Borrar
		ListadoDocentes.eliminarDocente(legajo);
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());	
		
		return modelView;		
		}

	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView editDocente(@PathVariable(name="legajo") String legajo) {
		//buscar
		Docente docenteParaModificar = ListadoDocentes.buscarDocentePorLegajo(legajo);
		
		//mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject("nuevaDocente", docenteParaModificar);	
		modelView.addObject("band", true);
		return modelView;		
		}

	@PostMapping("/modificarDocente")
	public ModelAndView updateDocente(@ModelAttribute("nuevaDocente") Docente docenteModificada) {
					
		//guardar
		ListadoDocentes.modificarDocente(docenteModificada);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());	
		
		return modelView;		
	}


}
