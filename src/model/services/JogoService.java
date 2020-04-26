/**
 * Interface JogoService
 * <p>Contrato respons�vel por implementar m�todos
 * de intera��o do jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package model.services;

import model.entities.Jogo;
import model.entities.Slot;

public interface JogoService {
	
	/**
	 * <p>Verifica se o jogo terminou</p>
	 * @return o valor booleano que determina se o jogo acabou</p>
	 */
	boolean isEncerrado();
	
	/**
	 * <p>Abre o slot solicitado de acordo com a
	 * posi��o da coluna.</p>
	 * @param pos -> posi��o da coluna de slots
	 */
	boolean abreSlot(int pos);
	
	/**
	 * <p>Verifica se os dois slots s�o iguais</p>
	 * @param slotA -> inst�ncia do slot
	 * @param slotB -> outra inst�ncia do slot
	 * @return o valor booleano que compara os dois slots.
	 */
	boolean validaJogada(Slot slotA, Slot slotB);
	
	/**
	 * <p>Incrementa a quantidade de tentativas</p>
	 */
	void proximaTentativa();
	
	/**
	 * <p>Recupera a inst�ncia do jogo</p>
	 * @return a inst�ncia do jogo
	 */
	Jogo getJogo();
	
	/**
	 * <p>Recupera a inst�ncia do servi�o dos slots.</p>
	 * @return o servi�o dos slots
	 */
	SlotService getSlotService();

}
