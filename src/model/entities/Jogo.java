/**
 * Classe Jogo
 * <p>Classe responsável por instanciar o jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
	
	private Integer tentativas;
	private Long tempoInicial;
	private List<Slot> slots = new ArrayList<>();
	
	public Jogo() {
		this.tentativas = 0;
		this.tempoInicial = 0L;
	}

	public Integer getTentativas() {
		return tentativas;
	}

	public List<Slot> getSlots() {
		return slots;
	}
	
	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public void setTentativas(Integer tentativas) {
		this.tentativas = tentativas;
	}

	public Long getTempoInicial() {
		return tempoInicial;
	}

	public void setTempoInicial(Long tempoInicial) {
		this.tempoInicial = tempoInicial;
	}
	
}
