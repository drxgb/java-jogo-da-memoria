/**
 * JOGO DA MEM�RIA
 * 
 * @author Dr.XGB
 * @version 1.0
 *
 */

import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		// Tela de t�tulo
		UI.limpaTela();
		UI.titulo();
		
		// Iniciando jogo
		UI.iniciar();
	}

}
