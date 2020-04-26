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
	
	public Jogo(List<Slot> slots) {
		this.tentativas = 0;
		this.tempoInicial = System.currentTimeMillis();
		this.slots = slots;
	}

	public Integer getTentativas() {
		return tentativas;
	}

	public List<Slot> getSlots() {
		return slots;
	}
	
	public Slot getSlot(int pos) {
		return this.slots.get(pos);
	}

	public void setTentativas(Integer tentativas) {
		this.tentativas = tentativas;
	}

	public Long getTempoInicial() {
		return tempoInicial;
	}
}
