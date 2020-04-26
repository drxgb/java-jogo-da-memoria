/**
 * Classe MemoriaSlotService
 * <p>Classe que implementa SlotService para
 * controlar as a��es dos slots do jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see SlotService
 */

package model.services;

import model.entities.Slot;

public class MemoriaSlotService implements SlotService {
	
	@Override
	public void revela(Slot slot) {
		slot.setRevelado(true);
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
