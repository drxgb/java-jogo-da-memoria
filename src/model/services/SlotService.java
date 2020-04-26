/**
 * Interface SlotService
 * <p>Contrato responsável em implementar ações dos
 * slots do jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package model.services;

import model.entities.Slot;

public interface SlotService {

	/**
	 * <p>Revela o valor do slot</p>
	 * @param slot -> instância do slot
	 */
	void revela(Slot slot);
	
	/**
	 * <p>Esconde o valor do slot</p>
	 * @param slot -> instância do slot
	 */
	void esconde(Slot slot);
	
	/**
	 * <p>Compara os valores entre dois slots</p>
	 * @param slotA -> instância do slot
	 * @param slotB -> instância do outro slot
	 */
	boolean compara(Slot slotA, Slot slotB);
	
}
