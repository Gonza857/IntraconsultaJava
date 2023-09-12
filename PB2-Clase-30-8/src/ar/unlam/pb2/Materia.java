package ar.unlam.pb2;

public class Materia {
	
	private Integer codMateria;
	private String nombre;
	private Materia correlativas[];
	
	public Materia (Integer codMateria, String nombre) {
		this.codMateria = codMateria;
		this.nombre = nombre;
		this.correlativas = new Materia[10];		
	}
	
	public void agregarCorrelativa (Materia materia) {
		boolean aux = false;
		int indice = 0;
		while (indice < this.correlativas.length && !aux) {
			if (this.correlativas[indice] == null) {
				this.correlativas[indice] = materia;
				aux = true;
				System.out.println("\nCorrelativa registrada correctamente.\n");
			}
			indice++;
		}
	}
	
	public void verElementos () {
		int indice = 0;
		while (indice < this.correlativas.length) {
			System.out.println(indice + ")" + this.correlativas[indice]);
			indice++;
		}
	}
	
	public Integer getCantidadCorrelativas () {
		int indice = 0;
		Integer contadorCorrelativas = 0;
		while (indice < this.correlativas.length) {
			if (this.correlativas[indice] != null) {
				contadorCorrelativas++;
			}
			indice++;
		}
		return contadorCorrelativas;
	}

	public Materia[] getCorrelativas () {
		return this.correlativas;
	}
	
	public Integer getCodigo() {
		return this.codMateria;
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
