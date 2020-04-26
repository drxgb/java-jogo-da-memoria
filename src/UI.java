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

public abstract class UI {
	
	public static void titulo() {
		System.out.println("==========================================================");
		System.out.println("\t\tJOGO DA MEMORIA");
		System.out.println("==========================================================");
		System.out.println();
	}
	
	public static void limpaTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
}
