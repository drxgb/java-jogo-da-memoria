/**
 * Classe UI
 * 
 * @author Dr.XGB
 * @version 1.0
 * 
 * <p>Classe responsável pela interface
 * gráfica do jogo.</p>
 *
 */

import java.util.Scanner;

import model.entities.Jogo;
import model.entities.Slot;

public abstract class UI {
	
	/**
	 * <p>Apaga todo o conteúdo da tela</p>
	 */
	public static void limpaTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	/**
	 * <p>Mostra o título do jogo</p>
	 */
	public static void titulo() {
		System.out.println("==========================================================");
		System.out.println("\t\tJOGO DA MEMORIA");
		System.out.println("==========================================================");
		System.out.println();
	}
	
	/**
	 *<p>Mostra mensagem de inicialização do jogo</p>
	 */
	public static void iniciar() {
		System.out.println("O jogo ja vai comecar...");
		System.out.println("Estou sorteando os numeros...");
		pausa(3000);
		System.out.println("\nPronto!");
		pausa(1000);
	}	
	
	/**
	 *<p>Pausa o terminal por um tempo</p>
	 * @param millis -> quantidade de milisegundos para pausar	 
	 */
	public static void pausa(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>Mostra o layout das colunas onde estão
	 * os números armazenados em slots</p>
	 * @param jogo -> a instância do jogo
	 */
	public static void printColunas(Jogo jogo) {
		// Cabeçalho das colunas
		System.out.print("\t");
		for(char c = 'A'; c <= 'J'; c++) {
			System.out.print(c);
			System.out.print("    ");
		}
		System.out.println();
		System.out.println("\t--------------------------------------------------");
		
		// Escreva os Slots em cada coluna
		System.out.print("\t");
		for(Slot slot : jogo.getSlots()) {
			if(slot.isRevelado()) {
				String slotChar = slot.getNumero().toString();
				System.out.print(slotChar);
				for(int i = 0; i < 5 - slotChar.length(); i++) {
					System.out.print(" ");
				}
			} else {
				System.out.print("#    ");
			}
		}
		System.out.println("\n");
	}
	
	/**
	 * <p>Mostra na tela a quantidade de tentativas
	 * que o jogador tem na partida</p>
	 * @param jogo
	 */
	public static void printTentativas(Jogo jogo) {
		System.out.println("Tentativas: " + jogo.getTentativas());
		System.out.println();
	}
	
	public static int lerColunas(Scanner sc) {
		char coluna = sc.nextLine().charAt(0);
		return ((int) coluna) - 65;
	}
	
	/**
	 * <p>Mostra uma mensagem de que o jogador acertou os pares</p>
	 */
	public static void msgAcerto() {
		System.out.println("\tVoce acertou!");
		System.out.println();
	}
	
	/**
	 * <p>Mostra uma mensagem de que o jogador errou os pares</p>
	 */
	public static void msgErro() {
		System.out.println("\tVoce errou!");
		System.out.println();
	}
	
	/**
	 * <p>Encerra o jogo e mostra as
	 * estatísticas da partida</p>
	 * @param jogo -> a instância do jogo
	 */
	public static void fim(Jogo jogo) {
		final byte EXCELENTE = 1;
		final byte BOM = 3;
		final byte MEDIO = 7;
		final byte RUIM = 10;
		final byte PESSIMO = 15;
		
		// Mensagem de congratulação (ou não kkkk)
		if(jogo.getTentativas() <= EXCELENTE) {
			System.out.println("INCRIVEL!");
		} else if(jogo.getTentativas() <= BOM) {
			System.out.println("MUITO BEM!");
		} else if(jogo.getTentativas() <= MEDIO) {
			System.out.println("OK");
		} else if(jogo.getTentativas() <= RUIM) {
			System.out.println("FIM DE JOGO");
		} else if(jogo.getTentativas() <= PESSIMO) {
			System.out.println("QUE BOSTA, HEIN!");
		}
		
		// Mostra quantidade de tentativas
		System.out.print("Voce concluiu o jogo em ");
		System.out.print(jogo.getTentativas());
		System.out.println(" tentativas.");
		
		// Feedback
		if(jogo.getTentativas() <= EXCELENTE) {
			System.out.println("Ce eh o bixao mesmo, hein doido?!");
		} else if(jogo.getTentativas() <= BOM) {
			System.out.println("Voce e realmente bom de memoria!");
		} else if(jogo.getTentativas() <= MEDIO) {
			System.out.println("Voce foi... eh... mais ou menos, mais ou menos...");
		} else if(jogo.getTentativas() <= RUIM) {
			System.out.println("Ainda nao esta bom. Voce precisa praticar mais!");
		} else if(jogo.getTentativas() <= PESSIMO) {
			System.out.println("Voce eh ruim de memoria. Se aposenta, PQP!");
		}
		
		// Duração da partida
		long millis = System.currentTimeMillis() - jogo.getTempoInicial();
		double segundos = ((double) millis) / 1000.0;
		System.out.println();
		System.out.print("Duracao da Partida: ");
		System.out.print(segundos);
		System.out.println(" segundos");
		
		// Finalizar jogo
		System.out.println();
		System.out.println("Obrigado por jogar!");
		pausa(5000);
	}
	
}
