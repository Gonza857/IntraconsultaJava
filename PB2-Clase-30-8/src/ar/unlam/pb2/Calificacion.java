package ar.unlam.pb2;

public class Calificacion {
	private Integer codMateria;
	private Integer nota;

	public Calificacion (Integer codMateria, Integer nota) {
		this.codMateria = codMateria;
		this.nota = nota;
	}
	
	public Integer getNota () {
		return this.nota;
	}
	
	public Integer getCodigo () {
		return this.codMateria;
	}
}
