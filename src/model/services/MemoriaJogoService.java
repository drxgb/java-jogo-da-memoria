/**
 * Classe MemoriaJogoService
 * <p>Classe que implementa JogoService para
 * controlar as interaões do jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 * @see JogoService
 */

package model.services;

import java.util.Random;

import model.entities.Jogo;
import model.entities.Slot;

public class MemoriaJogoService implements JogoService {
	
	private SlotService slotService;
	private Jogo jogo;
	
	private static final Random random = new Random();
	
	public MemoriaJogoService(SlotService slotService) {
		this.setJogo(new Jogo());
		
		// Gerar 10 slots vazios
		for(int i = 0; i < 10; i++) {
			this.getJogo().getSlots().add(new Slot());
		}
		
		this.defineSlots();	
		this.slotService = slotService;
		this.getJogo().setTempoInicial(System.currentTimeMillis());
	}

	@Override
	public boolean isEncerrado() {
		for(Slot slot : this.getJogo().getSlots()) {
			if(!slot.isRevelado())
				return false;
		}
		return true;
	}

	@Override
	public Slot abreSlot(int pos) {
		// Verifica se é uma coluna válida
		if(pos < 0 || pos >= this.getJogo().getSlots().size())
			return null;
		// Instancia um slot
		Slot slot = this.getJogo().getSlots().get(pos);
		
		// Verifica se o slot já foi aberto
		if(!this.getSlotService().revela(slot))
			return null;
		
		// Se o slot não estava aberto antes, retorne um slot
		return slot;
	}

	@Override
	public boolean validaJogada(Slot slotA, Slot slotB) {
		if(!this.getSlotService().compara(slotA, slotB)) {
			slotService.esconde(slotA);
			slotService.esconde(slotB);
			return false;
		}
		return true;
	}

	@Override
	public void proximaTentativa() {
		this.getJogo().setTentativas(this.getJogo().getTentativas() + 1);
	}

	public SlotService getSlotService() {
		return slotService;
	}

	public void setSlotService(SlotService slotService) {
		this.slotService = slotService;
	}

	public Jogo getJogo() {
		return jogo;
	}

	private void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	
	/**
	 * <p>Guarda valores em um par de slots</p>
	 */
	private void defineSlots() {
		int nums[] = this.gerarNumerosAleatorios();
		for(int i = 0; i < nums.length; i++) {			
			this.insereValorSlot(nums[i]);
			this.insereValorSlot(nums[i]);
		}
	}
	
	/**
	 * <p>Gera um arranjo de números aleatórios
	 * não-repetitivos</p>
	 * @return -> um array de números aleatórios
	 */
	private int[] gerarNumerosAleatorios() {
		final int MAX = 20;
		int nums[] = new int[5];
		for(int i = 0; i < nums.length; i++) {
			int aux;
			boolean repetido;
			do {
				repetido = false;
				aux = random.nextInt(MAX) + 1;
				for(int j = 0; j < nums.length; j++) {
					if(aux == nums[j]) {
						repetido = true;
						break;
					}
				}
			} while(repetido);
			nums[i] = aux;
		}
		return nums;
	}
	
	/**
	 * <p>Guarda um valor em um slot vazio</p>
	 * @param valor -> um número inteiro
	 */
	private void insereValorSlot(int valor) {
		int i;
		do {
			i = random.nextInt(10);
		} while(this.getJogo().getSlots().get(i).getNumero() != null);
		this.getJogo().getSlots().get(i).setNumero(valor);
	}

}
