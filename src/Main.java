/**
 * JOGO DA MEMÓRIA
 * 
 * @author Dr.XGB
 * @version 1.0
 *
 */

public class Main {

	public static void main(String[] args) {
		// Tela de título
		UI.limpaTela();
		UI.titulo();
		
		// Iniciando jogo
		UI.iniciar();
		
		UI.titulo();
		UI.printColunas();
	}

}
