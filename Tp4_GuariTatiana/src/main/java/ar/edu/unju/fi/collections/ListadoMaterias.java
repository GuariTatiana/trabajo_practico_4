package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Materia;

public class ListadoMaterias {

	public static List<Materia> materias =new ArrayList<Materia>();
	
	//metodo para listar materias
		public static List<Materia> listarMaterias(){
			return materias;
		}
		
	//metodo para buscar materia por codigo
		public static Materia buscarMateriaPorCodigo (String codigo) {
			for (Materia m : materias) {
				if (m.getCodigo() .equals (codigo)) {
					return m;
				}
			}
			return null;
		}
		
	//metodo para agregar una Materia
		public static void agregarMateria (Materia m) {
			//agregando el estado
			m.setEstado(true);
			materias.add(m);
		}
		
	//metodo para modificar una materia
		public static void modificarMateria (Materia materiaModificada) {
			materiaModificada.setEstado(true);
		    for (int i = 0; i < materias.size(); i++) {
		      Materia materia = materias.get(i);
		      if (materia.getCodigo().equals(materiaModificada.getCodigo())) {
		        materias.set(i, materiaModificada);
		        break;
		      }
		    }
		}
		
	//metodo para eliminar una materia 
		public static void eliminarMateria (String codigo) {
		//borrado fisico
		//carreras.removeIf(carrera -> carrera.getCodigo() .equals(codigo));
		//borrado logico
		 	for (int i = 0; i < materias.size(); i++) {
		 	Materia materia = materias.get(i); 
		 	if (materia.getCodigo().equals(codigo)) {
		 	materia.setEstado(false);; break; } }	
		}
		
}
