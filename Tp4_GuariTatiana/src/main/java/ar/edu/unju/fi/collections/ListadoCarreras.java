package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {

	public static List<Carrera> carreras =new ArrayList<Carrera>();
	
//metodo para listar carreras 
	public static List<Carrera> listarCarreras(){
		return carreras;
	}
	
//metodo para buscar carrera por codigo
	public static Carrera buscarCarreraPorCodigo (String codigo) {
		for (Carrera c : carreras) {
			if (c.getCodigo() .equals (codigo)) {
				return c;
			}
		}
		return null;
	}
	
//metodo para agregar una carrera
	public static void agregarCarrera (Carrera c) {
		//agregando el estado
		c.setEstado(true);
		carreras.add(c);
	}
	
//metodo para modificar una carrera
	public static void modificarCarrera (Carrera carreraModificada) {
		carreraModificada.setEstado(true);
	    for (int i = 0; i < carreras.size(); i++) {
	      Carrera carrera = carreras.get(i);
	      if (carrera.getCodigo().equals(carreraModificada.getCodigo())) {
	        carreras.set(i, carreraModificada);
	        break;
	      }
	    }
	}
	
//metodo para eliminar una materia 
	public static void eliminarCarrera (String codigo) {
	//borrado fisico
	//carreras.removeIf(carrera -> carrera.getCodigo() .equals(codigo));
	//borrado logico
	 	for (int i = 0; i < carreras.size(); i++) { Carrera carrera =
	 	carreras.get(i); if (carrera.getCodigo().equals(codigo)) {
	 	carrera.setEstado(false);; break; } }	
	}
	
}
