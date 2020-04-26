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

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.InputColunaException;
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
		limpaTela();
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
			System.out.print(slot.getNumero());
			System.out.print("    ");
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
		try {
			char coluna = sc.nextLine().charAt(0);
			if(coluna < 'A' || coluna > 'J') throw new InputColunaException("");
			return ((int) coluna) - 65;
		} catch(InputColunaException e) {
			throw new InputMismatchException("Erro ao ler posição: Escolha uma letra de \'A\' a \'J\'");
		}
	}
	
	/**
	 * <p>Mostra uma mensagem de que o jogador acertou os pares</p>
	 */
	public static void msgAcerto() {
		System.out.println("\tVocê acertou!");
		System.out.println();
	}
	
	/**
	 * <p>Mostra uma mensagem de que o jogador errou os pares</p>
	 */
	public static void msgErro() {
		System.out.println("\tVocê errou!");
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
			System.out.println("INCRÍVEL!");
		} else if(jogo.getTentativas() <= BOM) {
			System.out.println("MUITO BEM!");
		} else if(jogo.getTentativas() <= MEDIO) {
			System.out.println("OK");
		} else if(jogo.getTentativas() <= RUIM) {
			System.out.println("Fim de jogo");
		} else if(jogo.getTentativas() <= PESSIMO) {
			System.out.println("QUE BOSTA, HEIN!");
		}
		
		// Mostra quantidade de tentativas
		System.out.print("Você concluiu o jogo em ");
		System.out.print(jogo.getTentativas());
		System.out.print(" tentativas.");
		
		// Feedback
		if(jogo.getTentativas() <= EXCELENTE) {
			System.out.println("Cê é o bixão mesmo, hein doido?!");
		} else if(jogo.getTentativas() <= BOM) {
			System.out.println("Você é realmente bom de memória!");
		} else if(jogo.getTentativas() <= MEDIO) {
			System.out.println("Você foi... eh... mais ou menos, mais ou menos...");
		} else if(jogo.getTentativas() <= RUIM) {
			System.out.println("Ainda não está bom. Você precisa praticar mais!");
		} else if(jogo.getTentativas() <= PESSIMO) {
			System.out.println("Você é ruim de memória. Se aposenta!");
		}
		
		// Duração da partida
		long millis = System.currentTimeMillis() - jogo.getTempoInicial();
		double segundos = ((double) millis) / 1000.0;
		System.out.println();
		System.out.print("Duração da Partida: ");
		System.out.print(segundos);
		System.out.println(" segundos");
		
		// Finalizar jogo
		System.out.println();
		System.out.println("Obrigado por jogar!");
		pausa(10000);
	}
	
}
