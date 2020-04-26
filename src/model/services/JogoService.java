/**
 * Interface JogoService
 * <p>Contrato respons�vel por implementar m�todos
 * de intera��o do jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package model.services;

import model.entities.Slot;

public interface JogoService {
	
	void iniciar();
	boolean isEncerrado();
	void abreSlot(int pos);
	boolean validaJogada(Slot slotA, Slot slotB);
	void proximaTentativa();

}
