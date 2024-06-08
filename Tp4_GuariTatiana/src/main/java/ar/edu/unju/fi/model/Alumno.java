package ar.edu.unju.fi.model;

public class Alumno {
	 	private int dni;
	    private String nombre;
	    private String apellido;
	    private String email;
	    private String telefono;
	    private String fechaNacimiento;
	    private String domicilio;
	    private int LU;
	    
	    public Alumno() {
			// TODO Auto-generated constructor stub
		}

		public Alumno(int dni, String nombre, String apellido, String email, String telefono, String fechaNacimiento,
				String domicilio, int lU) {
			super();
			this.dni = dni;
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.telefono = telefono;
			this.fechaNacimiento = fechaNacimiento;
			this.domicilio = domicilio;
			LU = lU;
		}

		public int getDni() {
			return dni;
		}

		public void setDni(int dni) {
			this.dni = dni;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(String fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}

		public String getDomicilio() {
			return domicilio;
		}

		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
		}

		public int getLU() {
			return LU;
		}

		public void setLU(int lU) {
			LU = lU;
		}
	    
	    
}
