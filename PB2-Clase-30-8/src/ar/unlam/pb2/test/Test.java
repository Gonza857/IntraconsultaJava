package ar.unlam.pb2.test;

import static org.junit.Assert.*;
import ar.unlam.pb2.Universidad;
import ar.unlam.pb2.Alumno;
import ar.unlam.pb2.Cursada;
import ar.unlam.pb2.Materia;

public class Test {

	@org.junit.Test
	public void queSeCreeUnAlumno() {
		Alumno alumno1 = new Alumno("Gonzalo", "Ramos", 40000000);
		assertNotNull(alumno1);
	}

	@org.junit.Test
	public void queSeRegistreUnAlumno() {
		Universidad unlam = new Universidad("Unlam");
		Alumno alumno1 = new Alumno("Gonzalo", "Ramos", 40000000);
		unlam.registrarAlumno(alumno1);
		assertTrue(1 == unlam.getRegistrados());
	}

	@org.junit.Test
	public void queSeCreeMateria() {
		Materia pb2 = new Materia(001, "Programacion Basica 2");
		assertNotNull(pb2);
	}

	@org.junit.Test
	public void queSeCreeCursada() {
		Materia pb2 = new Materia(001, "Programacion Basica 2");
		Cursada comision1 = new Cursada(1, pb2);
		assertNotNull(comision1);
	}
	
	@org.junit.Test
	public void queHallaUnaMateriaAgregadaEnLaUniversidad() {
		Universidad unlam = new Universidad("Unlam");
		Materia pb2 = new Materia(1000, "Programacion Basica 2");
		Cursada comision1 = new Cursada(0, pb2);
		unlam.registrarMateria(pb2);
		assertTrue(1 == unlam.getCantidadMaterias());
	}
	
	@org.junit.Test
	public void queSeCreeCursadaYAgregarMateria() {
		Materia pb2 = new Materia(001, "Programacion Basica 2");
		Cursada comision1 = new Cursada(1, pb2);
		assertNotNull(comision1.getMateriaDeCursada());
	}
	
	@org.junit.Test
	public void buscarAlumnoPorDni() {
		String nombreAlumno = "Gonzalo", apellidoAlumno = "Ramos";
		Integer dniAlumno = 45400606;
		Universidad unlam = new Universidad("Unlam");
		Alumno alumno1 = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		unlam.registrarAlumno(alumno1);
		
		Alumno paraAgregar = unlam.buscarAlumno(dniAlumno);
		
		assertNotNull(paraAgregar);
		
		
		// Materia pb2 = new Materia(001, "Programacion Basica 2");
		// Cursada comision1 = new Cursada("pb2-1", pb2);
		
		//comision1.agregarAlumnoCursada(alumno1.getDni());
		
		//assertTrue(1 == comision1.getCantidadAlumnosEnCursada());
	}
	
	@org.junit.Test
	public void crearYAsignarCursadaALaUniversidad() {
		String nombreAlumno = "Gonzalo", apellidoAlumno = "Ramos";
		Integer dniAlumno = 45400606;
		Universidad unlam = new Universidad("Unlam");
		Alumno alumno1 = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		unlam.registrarAlumno(alumno1);
		
		Materia pb2 = new Materia(001, "Programacion Basica 2");
		
		unlam.crearCursada(0, 1000);		
		
		assertTrue(1 == unlam.getCursadas());
	}
	
	@org.junit.Test
	public void crearYAsignarVariasCursadas() {
		// preparación
		Universidad unlam = new Universidad("Unlam");
		Materia pb2 = new Materia(001, "Programacion Basica 2");
		
		// asignacion
		unlam.crearCursada(0, 1000);
		unlam.crearCursada(1, 1000);
		
		// test
		assertTrue(2 == unlam.getCursadas());
	}
	
	@org.junit.Test
	public void asignarAlumnoACursada() {
		// preparación
		Universidad unlam = new Universidad("Unlam");
		Materia pb2 = new Materia(001, "Programacion Basica 2");
		unlam.registrarMateria(pb2);
		unlam.crearCursada(0, 1000);
		
		String nombreAlumno = "Gonzalo", apellidoAlumno = "Ramos";
		Integer dniAlumno = 45400606;
		Alumno alumno1 = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		unlam.registrarAlumno(alumno1);
		
		
		// asignacion
		Cursada resultado = unlam.buscarCursada(0);
		unlam.asignarAlumnoCursada(dniAlumno, 0);
		
		// test
		assertTrue(1 == resultado.getCantidadAlumnosEnCursada());
	}
	
	@org.junit.Test
	public void asignarVariosAlumnosALaCursada() {
		// preparación
		Universidad unlam = new Universidad("Unlam");
		Materia pb2 = new Materia(001, "Programacion Basica 2");
		unlam.crearCursada(0, 1000);
		
		String nombreAlumno = "Gonzalo", apellidoAlumno = "Ramos";
		Integer dniAlumno = 45400606;
		Alumno alumno1 = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		unlam.registrarAlumno(alumno1);
		
		String nombreAlumno2 = "Leonel", apellidoAlumn2 = "Ramos";
		Integer dniAlumno2 = 20444777;
		Alumno alumno2 = new Alumno(nombreAlumno2, apellidoAlumn2, dniAlumno2);
		unlam.registrarAlumno(alumno2);
		
		// asignacion
		unlam.crearCursada(0, 1000);
		Cursada resultado = unlam.buscarCursada(0);
		unlam.asignarAlumnoCursada(dniAlumno, 0);
		unlam.asignarAlumnoCursada(dniAlumno2, 0);
		
		// test
		assertTrue(2 == resultado.getCantidadAlumnosEnCursada());
	}
	
	@org.junit.Test
	public void aisgnarMateriaAlAlumno() {
		// preparación
		Universidad unlam = new Universidad("Unlam");
		Materia pb2 = new Materia(1000, "Programacion Basica 2");
		unlam.registrarMateria(pb2);
		
		// assertTrue(1 == unlam.getCantidadMaterias());
		
		String nombreAlumno = "Gonzalo", apellidoAlumno = "Ramos";
		Integer dniAlumno = 45400606;
		Alumno alumno1 = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		unlam.registrarAlumno(alumno1);
		
		// asignacion
		unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, 1000);
		
		// test
		assertTrue(1 ==  alumno1.getMateriasAsignadas());
	}
	
	@org.junit.Test
	public void asignarDosMateriaslAlAlumno() {
		// preparación
		Universidad unlam = new Universidad("Unlam");
		Materia pb2 = new Materia(1000, "Programacion Basica 2");
		unlam.registrarMateria(pb2);
		
		Materia pw1 = new Materia(1010, "Programacion Web 1");
		unlam.registrarMateria(pw1);
		
		String nombreAlumno = "Gonzalo", apellidoAlumno = "Ramos";
		Integer dniAlumno = 45400606;
		Alumno alumno1 = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		unlam.registrarAlumno(alumno1);
		
		// asignacion
		unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, 1000);
		unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, 1010);
		
		// test
		assertTrue(2 ==  alumno1.getMateriasAsignadas());
	}
	
	@org.junit.Test
	public void queElAlumnoTengaUnaCalificacion() {
		// preparación
		Universidad unlam = new Universidad("Unlam");
		Materia pb2 = new Materia(1000, "Programacion Basica 2");
		unlam.registrarMateria(pb2);
		
		String nombreAlumno = "Gonzalo", apellidoAlumno = "Ramos";
		Integer dniAlumno = 45400606;
		Alumno alumno1 = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		unlam.registrarAlumno(alumno1);
		
		// asignacion
		unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, 1000);
		unlam.calificar(dniAlumno, 1000, 10);
		
		// test
		assertTrue(1 ==  alumno1.getCantidadCalificaciones());
	}
	
	@org.junit.Test
	public void queElAlumnoTengaDosCalificaciones() {
		// preparación
		Universidad unlam = new Universidad("Unlam");
		Materia pb2 = new Materia(1000, "Programacion Basica 2");
		unlam.registrarMateria(pb2);
		
		String nombreAlumno = "Gonzalo", apellidoAlumno = "Ramos";
		Integer dniAlumno = 45400606;
		Alumno alumno1 = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		unlam.registrarAlumno(alumno1);
		
		// asignacion
		unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, 1000);
		
		unlam.calificar(dniAlumno, 1000, 10);
		unlam.calificar(dniAlumno, 1000, 7);
		
		System.out.println("Promedio: " + alumno1.getPromedioCalificaciones());
		
		// test
		assertTrue(2 ==  alumno1.getCantidadCalificaciones());
	}
	
	@org.junit.Test
	public void queElPromedioSeaDiez() {
		// preparación
		Universidad unlam = new Universidad("Unlam");
		Materia pb2 = new Materia(1000, "Programacion Basica 2");
		unlam.registrarMateria(pb2);
		
		String nombreAlumno = "Gonzalo", apellidoAlumno = "Ramos";
		Integer dniAlumno = 45400606;
		Alumno alumno1 = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		unlam.registrarAlumno(alumno1);
		
		// asignacion
		unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, 1000);
		
		unlam.calificar(dniAlumno, 1000, 10);
		unlam.calificar(dniAlumno, 1000, 10);
		
		// test
		assertTrue(10 ==  alumno1.getPromedioCalificaciones());
	}
	
	@org.junit.Test
	public void agregarCorrelativaEnUnaMateria() {
		// preparación
		Universidad unlam = new Universidad("Unlam");
		
		Integer codigoPb1 = 2619;
		Integer codigoPb2 = 2623;
		
		Materia pb1 = new Materia(codigoPb1, "Programacion Basica 1");
		Materia pb2 = new Materia(codigoPb2, "Programacion Basica 2");
		
		unlam.registrarMateria(pb1);
		unlam.registrarMateria(pb2);
		
		unlam.asignarCorrelativaAUnaMateria(codigoPb2, codigoPb1);
		
		// test
		assertTrue(1 == pb2.getCantidadCorrelativas());
		// METODO OKEY
	}
	
	@org.junit.Test
	public void agregarDosCorrelativasEnUnaMateria() {
		// preparación
		Universidad unlam = new Universidad("Unlam");
		
		Integer codigoPb1 = 2619;
		Integer codigoIg = 2620;
		Integer codigoPw1 = 2624;
	
		Materia pw1 = new Materia(codigoPw1, "Programacion Web 1");
		Materia pb1 = new Materia(codigoPb1, "Programacion Basica 1");
		Materia ig = new Materia(codigoIg, "Informatica General");
		
		unlam.registrarMateria(pb1);
		unlam.registrarMateria(pw1);
		unlam.registrarMateria(ig);
		
		unlam.asignarCorrelativaAUnaMateria(codigoPw1, codigoPb1);
		unlam.asignarCorrelativaAUnaMateria(codigoPw1, codigoIg);
		
		// test
		assertTrue(2 == pw1.getCantidadCorrelativas());
		// METODO OKEY
	}
	
	@org.junit.Test
	public void obtenerMateriasAprobadasDeUnAlumno() {
		// preparación
		Integer codigoPb1 = 2619;
		Integer codigoIg = 2620;
		Integer codigoPw1 = 2624;
		
		Universidad unlam = new Universidad("Unlam");
		
		Materia pw1 = new Materia(codigoPw1, "Programacion Web 1");
		Materia pb1 = new Materia(codigoPb1, "Programacion Basica 1");
		Materia ig = new Materia(codigoIg, "Informatica General");
		
		unlam.registrarMateria(pb1);
		unlam.registrarMateria(pw1);
		unlam.registrarMateria(ig);
		
		unlam.asignarCorrelativaAUnaMateria(codigoPw1, codigoPb1);
		unlam.asignarCorrelativaAUnaMateria(codigoPw1, codigoIg);
		
		String nombreAlumno = "Gonzalo", apellidoAlumno = "Ramos";
		Integer dniAlumno = 45400606;
		Alumno alumno1 = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		
		unlam.registrarAlumno(alumno1);
		
		unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, codigoPw1);
		unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, codigoPb1);
		unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, codigoIg);
		
		unlam.verMaterias();
		
		unlam.calificar(dniAlumno, codigoIg, 7);
		unlam.calificar(dniAlumno, codigoPb1, 7);
		unlam.calificar(dniAlumno, codigoPw1, 7);
		
		// test
		assertTrue(3 == alumno1.getCantidadMateriasAprobadas());
	}
	
	@org.junit.Test
	public void aprobarMateriaTeniendoLaCorrelativaAprobada() {
		// preparación
		Integer codigoPb1 = 2619;
		Integer codigoIg = 2620;
		Integer codigoPw1 = 2624;
		
		Universidad unlam = new Universidad("Unlam");
		
		Materia pw1 = new Materia(codigoPw1, "Programacion Web 1");
		Materia pb1 = new Materia(codigoPb1, "Programacion Basica 1");
		Materia ig = new Materia(codigoIg, "Informatica General");
		
		unlam.registrarMateria(pb1);
		unlam.registrarMateria(pw1);
		unlam.registrarMateria(ig);
		
		unlam.asignarCorrelativaAUnaMateria(codigoPw1, codigoPb1);
		unlam.asignarCorrelativaAUnaMateria(codigoPw1, codigoIg);
		
		String nombreAlumno = "Gonzalo", apellidoAlumno = "Ramos";
		Integer dniAlumno = 45400606;
		Alumno alumno1 = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		
		unlam.registrarAlumno(alumno1);
		
		boolean ejecucion = false;
		
		ejecucion = unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, codigoPb1);
		ejecucion = unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, codigoIg);
		
		unlam.calificar(dniAlumno, codigoIg, 7);
		unlam.calificar(dniAlumno, codigoPb1, 7);
		
		ejecucion = unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, codigoPw1);

		// test
		assertTrue(ejecucion);
	}
	
	@org.junit.Test
	public void aprobarMateriaTeniendoLasTresCorrelativaAprobadas() {
		// preparación
		Integer codigoBd1 = 2623;
		Integer codigoPw1 = 2624;
		Integer codigoPb2 = 2625;
		Integer codigoTw1 = 2631;
		
		Universidad unlam = new Universidad("Unlam");
		
		Materia bd1 = new Materia(codigoBd1, "Base de datos 1");
		Materia pw1 = new Materia(codigoPw1, "Programacion Web 1");
		Materia pb2 = new Materia(codigoPb2, "Programación Básica 2");
		Materia tw1 = new Materia(codigoTw1, "Taller web 1");
		
		unlam.registrarMateria(bd1);
		unlam.registrarMateria(pw1);
		unlam.registrarMateria(pb2);
		unlam.registrarMateria(tw1);
		
		unlam.asignarCorrelativaAUnaMateria(codigoTw1, codigoBd1);
		unlam.asignarCorrelativaAUnaMateria(codigoTw1, codigoPw1);
		unlam.asignarCorrelativaAUnaMateria(codigoTw1, codigoPb2);
		
		String nombreAlumno = "Gonzalo", apellidoAlumno = "Ramos";
		Integer dniAlumno = 45400606;
		Alumno alumno1 = new Alumno(nombreAlumno, apellidoAlumno, dniAlumno);
		
		unlam.registrarAlumno(alumno1);
		
		boolean ejecucion = false;
		
		ejecucion = unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, codigoBd1);
		ejecucion = unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, codigoPw1);
		ejecucion = unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, codigoPb2);
		
		unlam.calificar(dniAlumno, codigoBd1, 7);
		unlam.calificar(dniAlumno, codigoPw1, 7);
		unlam.calificar(dniAlumno, codigoPb2, 7);
		
		ejecucion = unlam.asignarMateriaDeCursadaAlAlumno(dniAlumno, codigoTw1);

		// test
		assertTrue(ejecucion);
	}
	
	
	// materias del alumons
	
	// proimedio de las calificaciones
	
	// obtener amterias aprobadas
	
	// que alumno no se pueda inscribir si no tiene las correlativas aprobadas
	// metodo que reciba (cod-materia, dni alumno) si est apromocionado o no, 7 + true sino false
	// 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
