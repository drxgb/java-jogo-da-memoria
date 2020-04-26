package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
	
	private Integer tentativas;
	private List<Slot> slots = new ArrayList<>();
	
	public Jogo() {
		
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
	
}
