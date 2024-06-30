package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {

	public static List<Docente> docentes =new ArrayList<Docente>();
	
	//metodo para listar docentes
		public static List<Docente> listarDocentes(){
			return docentes;
		}
		
	//metodo para buscar docente por legajo
		public static Docente buscarDocentePorLegajo (String legajo) {
			for (Docente d : docentes) {
				if (d.getLegajo() .equals (legajo)) {
					return d;
				}
			}
			return null;
		}
		
	//metodo para agregar un docente
		public static void agregarDocente (Docente d) {
			//agregando el estado
			d.setEstado(true);
			docentes.add(d);
		}
		
	//metodo para modificar un docente
		public static void modificarDocente (Docente docenteModificada) {
			docenteModificada.setEstado(true);
		    for (int i = 0; i < docentes.size(); i++) {
		      Docente docente = docentes.get(i);
		      if (docente.getLegajo().equals(docenteModificada.getLegajo())) {
		        docentes.set(i, docenteModificada);
		        break;
		      }
		    }
		}
		
	//metodo para eliminar un docente
		public static void eliminarDocente (String legajo) {
		//borrado fisico
		//carreras.removeIf(carrera -> carrera.getCodigo() .equals(codigo));
		//borrado logico
		 	for (int i = 0; i < docentes.size(); i++) {
		 	Docente docente = docentes.get(i); if (docente.getLegajo().equals(legajo)) {
		 	docente.setEstado(false);; break; } }	
		}
		
}


