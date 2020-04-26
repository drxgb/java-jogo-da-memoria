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
import model.entities.Slot;
import model.services.JogoService;
import model.services.MemoriaJogoService;
import model.services.MemoriaSlotService;

public class Main {

	public static void main(String[] args) {
		// Configurações iniciais
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Slot slotA, slotB;
		
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
				slotA = jogoService.abreSlot(UI.lerColunas(sc));
			} while(slotA == null);
			
			UI.limpaTela();
			UI.titulo();
			UI.printColunas(jogo);
			UI.printTentativas(jogo);	
			
			// Leitura da segunda coluna
			do {
				System.out.print("Escolha outra coluna de \'A\' a \'J\' => ");
				slotB = jogoService.abreSlot(UI.lerColunas(sc));
			} while(slotB == null);
			
			// Comparar se os slots são iguais
			UI.limpaTela();
			UI.titulo();
			UI.printColunas(jogo);
			if(jogoService.validaJogada(slotA, slotB)) {
				UI.msgAcerto();
			} else {
				UI.msgErro();
				jogoService.proximaTentativa();
			}
			UI.pausa(1000);
		}
		
		// Fim de jogo
		UI.fim(jogo);
		sc.close();		
	}

}
