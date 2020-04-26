/**
 * Classe MemoriaSlotService
 * <p>Classe que implementa SlotService para
 * controlar as ações dos slots do jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see SlotService
 */

package model.services;

import model.entities.Slot;

public class MemoriaSlotService implements SlotService {
	
	public MemoriaSlotService() {}
	
	@Override
	public boolean revela(Slot slot) {
		if(slot.isRevelado())
			return false;
		slot.setRevelado(true);
		return true;
	}
	
	@Override
	public void esconde(Slot slot) {
		slot.setRevelado(false);		
	}
	
	@Override
	public boolean compara(Slot slotA, Slot slotB) {
		return slotA.equals(slotB);
	}	
	
}
