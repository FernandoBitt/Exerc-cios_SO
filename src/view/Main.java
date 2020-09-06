package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController redeControl = new RedesController();
		String sistema = redeControl.sistema();
		
		int opcao=0;
		while (opcao !=9) {	
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite - 1: para mostrar a configuração IPV4 \nDigite - 2: para receber o ping \nDigite - 9: para encerar"));
		
			switch (opcao) {
			
			case 1:	
				redeControl.ip(sistema);
				break;
			case 2:
				redeControl.ping(sistema);
				break;
				
			case 9:
				JOptionPane.showMessageDialog(null, "Fim");
				break;
			
			default:
				JOptionPane.showMessageDialog(null,"Opção Inválida");
		
		
			}
		
		
		}		
		
	}

}


//A Classe Main.java deve ter a possibilidade de o usuário escolher a ação que
//quer fazer e, dependendo da escolha, instanciar a Classe
//RedesController.java e chamar o método escolhido. A opção de finalizar a
//aplicação também deve estar disponível.