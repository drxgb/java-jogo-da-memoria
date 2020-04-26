/**
 * Classe UI
 * 
 * @author Dr.XGB
 * @version 1.0
 * 
 * <p>Classe respons�vel pela interface
 * gr�fica do jogo.</p>
 *
 */

public abstract class UI {
	
	/**
	 * <p>Apaga todo o conte�do da tela</p>
	 * @version 1.0
	 */
	public static void limpaTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	/**
	 * <p>Mostra o t�tulo do jogo</p>
	 * @version 1.0
	 */
	public static void titulo() {
		System.out.println("==========================================================");
		System.out.println("\t\tJOGO DA MEMORIA");
		System.out.println("==========================================================");
		System.out.println();
	}
	
	/**
	 *<p>Mostra mensagem de inicializa��o do jogo</p>
	 * @version 1.0	 
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
	 * @version 1.0
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
	 * <p>Mostra o layout das colunas onde est�o
	 * os n�meros armazenados em slots</p>
	 * @version 1.0
	 */
	public static void printColunas() {
		// Cabe�alho das colunas
		System.out.print("\t");
		for(char c = 'A'; c <= 'J'; c++) {
			System.out.print(c);
			System.out.print("    ");
		}
		System.out.println();
		System.out.println("\t--------------------------------------------------");
		
		// Escreva os Slots em cada coluna
	}
	
}
