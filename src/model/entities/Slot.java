package model.entities;

public class Slot {
	
	private Integer numero;
	private Boolean revelado;	

	public Slot(Integer numero) {
		this.numero = numero;
		this.revelado = false;
	}

	public Integer getNumero() {
		return numero;
	}

	public Boolean isRevelado() {
		return revelado;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setRevelado(Boolean revelado) {
		this.revelado = revelado;
	}	
}
