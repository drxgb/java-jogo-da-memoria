/**
 * Classe Slot
 * <p>Respresenta cada espaço ocupado por um número
 * onde o jogador terá que memoriza-los e
 * encontrar os pares</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package model.entities;

public class Slot {
	
	private Integer numero;
	private Boolean revelado;	

	public Slot() {
		this.numero = null;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slot other = (Slot) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}	
}
