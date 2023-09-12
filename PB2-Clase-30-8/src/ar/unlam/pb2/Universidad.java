package ar.unlam.pb2;

public class Universidad {
	private Alumno alumnos[];
	private Materia materias[];
	private Cursada cursadas[];
	private String nombre;

	public Universidad(String nombre) {
		this.alumnos = new Alumno[100];
		this.materias = new Materia[100];
		this.cursadas = new Cursada[100];
		this.nombre = nombre;
	}

	public void calificar(Integer dniAlumno, Integer codMateria, Integer nota) {
		String pruebaGit = "nueva jujuujuj";
		Alumno alumnoBuscado = buscarAlumno(dniAlumno);
		if (alumnoBuscado != null) {
			Materia buscarMateria = alumnoBuscado.buscarMateriaDeAlumno(codMateria);
			if (buscarMateria != null) {
				alumnoBuscado.setCalificacion(buscarMateria, nota);
			}
		}

	}
	
	public boolean saberSiMateriaTieneCorrelativa (Materia materia) {
		if (materia.getCantidadCorrelativas() > 0) {
			return true;
		} else return false;
	}

	public boolean asignarMateriaDeCursadaAlAlumno(Integer dniAlumno, Integer codMateria) {
		Alumno alumnoParaAsignar = buscarAlumno(dniAlumno);
		Materia materiaParaAsignar = buscarMateria(codMateria);
		boolean pudoEjecutarse = false;
		
		if (alumnoParaAsignar != null && materiaParaAsignar != null) {
			
			System.out.println("\nTodo legal");
			
			if (saberSiMateriaTieneCorrelativa(materiaParaAsignar)) {
				
				
				Integer cantidadDeCorrelativas = materiaParaAsignar.getCantidadCorrelativas();
				System.out.println(materiaParaAsignar.getNombre() + " tiene " +  cantidadDeCorrelativas + " correlativa/s");
				Materia[] correlativasDeMateria = materiaParaAsignar.getCorrelativas();
				
				int indice = 0;
				int contadorAprobadas = 0;
				while (indice < cantidadDeCorrelativas) {
					boolean saberSiAproboEstaMateria = alumnoParaAsignar.buscarAprobada(correlativasDeMateria[indice].getCodigo());
					if (saberSiAproboEstaMateria) {
						System.out.println("Si aprobó " + correlativasDeMateria[indice].getNombre());
						contadorAprobadas++;
					} else {
						System.out.println("No aprobó " + correlativasDeMateria[indice].getNombre());
					}
					indice++;
				}
				if (cantidadDeCorrelativas.equals(contadorAprobadas)) {
					System.out.println("Aprobo las materias requieridas");
					alumnoParaAsignar.asignarleMateriaAlAlumno(materiaParaAsignar);
					pudoEjecutarse = true;
				} else {
					System.out.println("\n¡No aprobo las materias requeridas!");
				}
			} else {
				System.out.println(materiaParaAsignar.getNombre() + " no tiene correlativa/s");
				alumnoParaAsignar.asignarleMateriaAlAlumno(materiaParaAsignar);
				pudoEjecutarse = true;
			}
		}
		return pudoEjecutarse;
	}

	public Alumno buscarAlumno(Integer dniAlumno) {
		Alumno buscado = null;
		int indice = 0;
		while (indice < this.alumnos.length) {
			if (this.alumnos[indice] != null && buscado == null) {
				if (this.alumnos[indice].getDni() == dniAlumno) {
					buscado = this.alumnos[indice];
				}
			}
			indice++;
		}
		return buscado;
	}

	public boolean registrarMateria(Materia materia) {
		int indice = 0;
		boolean aux = false;
		while (indice < this.materias.length && !aux) {
			if (this.materias[indice] == null) {
				this.materias[indice] = materia;
				aux = true;
				System.out.println("Cod_materia '" + materia.getCodigo() + "' registrada.");
			}
			indice++;
		}
		return aux;
	}

	public void asignarCorrelativaAUnaMateria(Integer codMateria, Integer codMateriaCorrelativa) {
		Materia materiaBuscada = buscarMateria(codMateria);
		Materia correlativa = buscarMateria(codMateriaCorrelativa);
		if (materiaBuscada != null) {
			materiaBuscada.agregarCorrelativa(correlativa);
		}
	}

	public Materia buscarMateria(Integer codMateria) {
		Materia buscada = null;
		int indice = 0;

		while (indice < this.materias.length && buscada == null) {
			if (this.materias[indice] != null) {
				if (this.materias[indice].getCodigo().equals(codMateria)) {
					buscada = this.materias[indice];
					System.out.println("Materia encontrada");
				}
			}
			indice++;
		}
		return buscada;
	}

	public Integer getCantidadMaterias() {
		Integer contador = 0;
		int indice = 0;
		while (indice < this.materias.length) {
			if (this.materias[indice] != null) {
				contador++;
			}
			indice++;
		}
		return contador;
	}

	public void verMaterias() {
		System.out.println("\n---Registradas:");
		int indice = 0;
		while (indice < this.materias.length) {
			if (this.materias[indice] != null) {
				System.out.println("Codigo: " + this.materias[indice].getCodigo());
			}
			indice++;
		}
		System.out.println("---Fin registradas.\n");
	}

	public boolean registrarAlumno(Alumno alumnoParaRegistrar) {
		boolean pudoRegistrase = false;
		int indice = 0;
		while (indice < this.alumnos.length && !pudoRegistrase) {
			if (this.alumnos[indice] == null) {
				this.alumnos[indice] = alumnoParaRegistrar;
				pudoRegistrase = true;
				System.out.println(alumnoParaRegistrar.getDni() + " registrado.\n");
			}
			indice++;
		}
		return pudoRegistrase;
	}

	public Integer getRegistrados() {
		Integer registrados = 0;
		int indice = 0;
		while (indice < this.alumnos.length) {
			if (this.alumnos[indice] != null) {
				registrados++;
			}
			indice++;
		}
		return registrados;
	}

	public void asignarAlumnoCursada(Integer dni, Integer comision) {
		Alumno alumnoParaAgregar = buscarAlumno(dni);
		if (alumnoParaAgregar != null) {
			Cursada cursadaParaAgregar = buscarCursada(comision);
			if (cursadaParaAgregar != null) {
				cursadaParaAgregar.agregarAlumnoCursada(alumnoParaAgregar);
			}
		}
	}

	public Cursada buscarCursada(Integer comision) {
		Cursada buscada = null;
		int indice = 0;
		while (indice < this.cursadas.length && buscada == null) {
			if (this.cursadas[indice].getComision() == comision) {
				buscada = this.cursadas[indice];
				System.out.println("\n---Cursada agregada.");
			}
			indice++;
		}
		return buscada;
	}

	public void crearCursada(Integer comision, Integer codMateria) {
		Materia buscarMateria = buscarMateria(codMateria);
		Cursada nueva = new Cursada(comision, buscarMateria);
		if (!comprobarSiExisteCursada(comision)) {
			agregarCursada(nueva);
		}
	}

	private void agregarCursada(Cursada nuevaCursada) {
		boolean aux = false;
		int indice = 0;
		while (indice < this.cursadas.length && !aux) {
			if (this.cursadas[indice] == null) {
				this.cursadas[indice] = nuevaCursada;
				aux = true;
				System.out.println("\n---Cursada registrada.");
			}
			indice++;
		}
	}

	private boolean comprobarSiExisteCursada(Integer comision) {
		boolean existe = false;
		int indice = 0;
		while (indice < this.cursadas.length) {
			if (this.cursadas[indice] != null) {
				if (this.cursadas[indice].getComision() == comision) {
					existe = true;
				}
			}
			indice++;
		}
		return existe;
	}

	public Integer getCursadas() {
		int indice = 0;
		Integer contador = 0;
		while (indice < this.cursadas.length) {
			if (this.cursadas[indice] != null) {
				contador++;
			}
			indice++;
		}
		return contador;
	}
}
