package ar.unlam.pb2;

public class Alumno {

	private Integer dni;
	private String nombre;
	private String apellido;
	private Calificacion calificaciones[];
	private Materia historiaMaterias[];
	private Materia materiasAprobadas[];
	
	public Alumno (String nombre, String apellido, Integer dni) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.calificaciones = new Calificacion[100];
		this.historiaMaterias = new Materia[100];
		this.materiasAprobadas = new Materia[100];
	}
	
	public boolean saberSiAproboLaMateria (Materia materia) {
		boolean fueAprobada = false;
		int indice = 0;
		while (indice < this.materiasAprobadas.length && !fueAprobada) {
			if (this.materiasAprobadas[indice] != null) {
				if (this.materiasAprobadas[indice].getCodigo().equals(materia.getCodigo())) {
					System.out.println("Materia para saber: " + materia.getCodigo());
					System.out.println("Materia aprobada por el alumno: " + this.materiasAprobadas[indice].getCodigo());
					fueAprobada = true;
				}
			}
			
			indice++;
		}
		
		
		return fueAprobada;
	}
	
	public Double getPromedioCalificaciones () {
		Double conteoNotas = 0d;
		Double conteoMaterias = 0d;
		int indice = 0;
		while (indice < this.calificaciones.length) {
			if (this.calificaciones[indice] != null) {
				conteoNotas += this.calificaciones[indice].getNota();
				conteoMaterias++;
			}
			indice++;
		}
		return conteoNotas/conteoMaterias;
	}
	
	public Materia[] getNOSEMateriasAprobadas () {
		int indice = 0;
		Materia[] aprobadas = new Materia[getCantidadMateriasAprobadas()];
		while (indice < aprobadas.length) {
			if (this.calificaciones[indice] != null) {
				if (this.calificaciones[indice].getNota() >= 7) {
					aprobadas[indice] = buscarMateriaDeAlumno(this.calificaciones[indice].getCodigo());
				}
			}
			indice++;
		}
		for (int i = 0;i<aprobadas.length;i++) {
			System.out.println(aprobadas[i].getCodigo() + " aprobada");
		}
		return aprobadas;
	}
	
	public Integer getCantidadMateriasAprobadas () {
		Integer aprobadas = 0;
		int indice = 0;
		while (indice < this.materiasAprobadas.length ) {
			if (this.materiasAprobadas[indice] != null) {
				aprobadas++;
			}
			indice++;
		}
		return aprobadas;
	}
	
	public Integer getCantidadCalificaciones () {
		Integer cantidadDeCalificaciones = 0;
		int indice = 0;
		while (indice < this.calificaciones.length) {
			if (this.calificaciones[indice] != null) {
				cantidadDeCalificaciones++;
			}
			indice++;
		}
		return cantidadDeCalificaciones;
	}
	
	public Materia buscarMateriaDeAlumno (Integer codigo) {
		Materia buscada = null;
		int indice = 0;
		while (indice < this.historiaMaterias.length && buscada == null) {
			if (this.historiaMaterias[indice] != null ) {
				if (this.historiaMaterias[indice].getCodigo().equals(codigo)) {
					buscada = this.historiaMaterias[indice];
				}
			}
			indice++;
		}
		return buscada;
	}
	
	public void setCalificacion (Materia materia, Integer nota) {
		Calificacion calificacion = new Calificacion(materia.getCodigo(), nota);
		guardarCalificacion(calificacion);
		if (nota >= 7) {
			agregarMateriaAprobada(materia.getCodigo());
		}
	}
	
	public void agregarMateriaAprobada (Integer codigo) {
		Materia buscada = buscarMateriaDeAlumno(codigo);
		int indice = 0;
		boolean fueAgregada = false;
		while (indice < this.materiasAprobadas.length && !fueAgregada) {
			if (this.materiasAprobadas[indice] == null) {
				this.materiasAprobadas[indice] = buscada;
				fueAgregada = true;
				System.out.println("---¡Aprobaste " + this.materiasAprobadas[indice].getNombre() + "!");
			}
			indice++;
		}
	}
	
	public Materia[] getMateriasAprobadas () {
		return this.materiasAprobadas;
	}
	
	public void guardarCalificacion (Calificacion calificacion) {
		boolean aux = false;
		int indice = 0;
		while (indice < this.calificaciones.length && !aux) {
			if (this.calificaciones[indice] == null) {
				this.calificaciones[indice] = calificacion;
				aux = true;
				System.out.println("\nCalificación guardada correctamente.\n");
			}
			indice++;
		}
	}
	
	public boolean asignarleMateriaAlAlumno (Materia materia) {
		int indice = 0;
		boolean asignado = false;
		while (indice < this.historiaMaterias.length && !asignado) {
			if (this.historiaMaterias[indice] == null) {
				this.historiaMaterias[indice] = materia;
				asignado = true;
				System.out.println(materia.getNombre() + " asignada a " +  this.dni);
			}
			indice++;
		}
		return asignado;
	}
	
	public Integer getMateriasAsignadas () {
		Integer materias = 0;
		int indice = 0;
		while (indice < this.historiaMaterias.length) {
			if (this.historiaMaterias[indice] != null) {
				materias++;
			}
			indice++;
		}
		return materias;
	}
	
	public Integer[] getCodigosHistorialMateriasAprobadas () {
		Integer[] codigosAprobadas = new Integer[25];
		int indice = 0;
		//while (indice < this.historiaMaterias.length) {
		//	if (this.historiaMaterias[indice] != null) {
		//		if (this.historiaMaterias[indice].g)
		//	}
		//	indice++;
		//}
		
		return codigosAprobadas;
	}
	
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
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

	public boolean buscarAprobada(Integer codigo) {
		Integer indice = 0;
		boolean estaAprobada = false;
		while (indice < this.materiasAprobadas.length && !estaAprobada) {
			if (this.materiasAprobadas[indice] != null) {
				if (materiasAprobadas[indice].getCodigo().equals(codigo)) {
					estaAprobada = true;
					System.out.println("--- Encontre una aprobada ---");
				}
			}
			indice++;
		}
		return estaAprobada;
	}
	

	

}
