package ar.unlam.pb2;

public class Nota {
	
	private Integer valor;
	
	public Nota () {
		this.valor = 0;
	}
	
	public Nota (Integer valor) {
		this.valor = valor;
	}
	
	public Integer getNota () {
		return this.valor;
	}
	
	public void setNota (Integer notaNueva) {
		if(valor >=1 && valor<=10)
		     this.valor=valor;
	}

}
