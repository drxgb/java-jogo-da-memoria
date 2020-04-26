/**
 * JOGO DA MEMÓRIA
 * 
 * @author Dr.XGB
 * @version 1.0
 *
 */

import java.util.Locale;
import java.util.Scanner;

import model.entities.Jogo;
import model.services.JogoService;
import model.services.MemoriaJogoService;
import model.services.MemoriaSlotService;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// Tela de título
		UI.limpaTela();
		UI.titulo();
		
		// Iniciando jogo
		JogoService jogoService = new MemoriaJogoService(new MemoriaSlotService());
		Jogo jogo = jogoService.getJogo();
		UI.iniciar();
		
		// Loop Principal
		while(!jogoService.isEncerrado()) {
			UI.limpaTela();
			UI.titulo();
			UI.printColunas(jogo);
			UI.printTentativas(jogo);				
			
			// Leitura da primeira coluna
			do {
				System.out.print("Escolha uma coluna de \'A\' a \'J\' => ");
			} while(!jogoService.abreSlot(UI.lerColunas(sc)));
			break;
		}
		
		sc.close();
		
	}

}
