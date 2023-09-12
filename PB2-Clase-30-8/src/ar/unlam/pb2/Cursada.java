package ar.unlam.pb2;

public class Cursada {

	private Materia materiaAsignada;
	private Alumno alumnosCursada[];
	private Nota nota;
	private Integer comision;
	
	

	public Cursada(Integer comision, Materia materia) {
		this.alumnosCursada = new Alumno[100];
		this.materiaAsignada = materia;
		this.comision = comision;
	}
	
	public Integer getComision () {
		return this.comision;
	}



	public void calificar(Integer valor) {
		nota.setNota(valor);
	}
	
	public Materia getMateriaDeCursada () {
		return this.materiaAsignada;
	}
	
	public Integer getCantidadAlumnosEnCursada () {
		int indice = 0;
		Integer alumnosCursando = 0;
		while (indice < this.alumnosCursada.length) {
			if (this.alumnosCursada[indice] != null) {
				alumnosCursando++;
			}
			indice++;
		}
		System.out.println("Alumnos de la comision '" + this.comision + "' son: " + alumnosCursando);
		return alumnosCursando;
	}
	
	public boolean agregarAlumnoCursada (Alumno nuevoAlumno) {
		boolean pudoAgregarse = false;
		int indice = 0;
		while (indice < this.alumnosCursada.length && !pudoAgregarse) {
			if (this.alumnosCursada[indice] == null) {
				this.alumnosCursada[indice] = nuevoAlumno;
				pudoAgregarse = true;
			}
			indice++;
		}
		return pudoAgregarse;
	}
}
