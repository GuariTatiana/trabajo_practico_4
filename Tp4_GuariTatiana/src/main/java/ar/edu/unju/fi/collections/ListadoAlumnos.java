package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumnos {

	public static List<Alumno> alumnos =new ArrayList<Alumno>();
	
	//metodo para listar alumnos 
		public static List<Alumno> listarAlumnos(){
			return alumnos;
		}
		
	//metodo para buscar alumno con dni
		public static Alumno buscarAlumnoPorDni (int dni) {
			for (Alumno a : alumnos) {
				if (a.getDni() == (dni)) {
					return a;
				}
			}
			return null;
		}
		
	//metodo para agregar un alumno
		public static void agregarAlumno (Alumno a) {
			//agregando el estado
			a.setEstado(true);
			alumnos.add(a);
		}
		
	//metodo para modificar un alumno
		public static void modificarAlumno (Alumno alumnoModificada) {
			alumnoModificada.setEstado(true);
		    for (int i = 0; i < alumnos.size(); i++) {
		      Alumno alumno = alumnos.get(i);
		      if (alumno.getDni() == (alumnoModificada.getDni())) {
		        alumnos.set(i, alumnoModificada);
		        break;
		      }
		    }
		}
		
	//metodo para eliminar un alumno
		public static void eliminarAlumno (int dni) {
		//borrado fisico
		//carreras.removeIf(carrera -> carrera.getCodigo() .equals(codigo));
		//borrado logico
		 	for (int i = 0; i < alumnos.size(); i++)
		 	{ Alumno alumno = alumnos.get(i); 
		 	if (alumno.getDni() == (dni)) {
		 	alumno.setEstado(false);; break; } }	
		}

}
