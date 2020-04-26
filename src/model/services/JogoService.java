/**
 * Interface JogoService
 * <p>Contrato responsável por implementar métodos
 * de interação do jogo</p>
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
	 * posição da coluna.</p>
	 * @param pos -> posição da coluna de slots
	 */
	boolean abreSlot(int pos);
	
	/**
	 * <p>Verifica se os dois slots são iguais</p>
	 * @param slotA -> instância do slot
	 * @param slotB -> outra instância do slot
	 * @return o valor booleano que compara os dois slots.
	 */
	boolean validaJogada(Slot slotA, Slot slotB);
	
	/**
	 * <p>Incrementa a quantidade de tentativas</p>
	 */
	void proximaTentativa();
	
	/**
	 * <p>Recupera a instância do jogo</p>
	 * @return a instância do jogo
	 */
	Jogo getJogo();
	
	/**
	 * <p>Recupera a instância do serviço dos slots.</p>
	 * @return o serviço dos slots
	 */
	SlotService getSlotService();

}
