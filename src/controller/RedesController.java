package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}
	
	public String sistema() {
		String sistema = System.getProperty("os.name");
		return sistema;
	}
	
	
	
	public void ip(String sistema) {
		String nome = "";
		try {
			Process p = Runtime.getRuntime().exec("ipconfig");
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				if (linha.contains("Adaptador")) {
					nome = linha;
				}
				if (linha.contains("IPv4")) {
					System.out.println(nome);
					System.out.println(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
		



//O primeiro, chamado ip, que recebe o nome do Sistema Operacional como
//par�metro e, de acordo com o S.O., faz a chamada de configura��o de IP e
//filtra a sa�da do processo, retornando um String com o nome do Adaptador
//Ethernet e o IPv4 apenas (N�o importa o n�mero de adaptadores ethernet,
//devem aparecer todos). Os adaptadores que n�o tiverem IPv4 n�o devem
//ser mostrados. 


	public void ping(String sistema) {
//		C:\Users\fbitt>ping -n 10 google.com.br
		try {
			
			Process t = Runtime.getRuntime().exec("ping -n 10 www.google.com.br");
			InputStream tela = t.getInputStream();
			InputStreamReader leitor = new InputStreamReader(tela);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while (linha!=null) {
				linha = buffer.readLine();
				if(linha !=null && linha.contains("tempo")) {
					int mediaI = linha.indexOf("tempo=");
					int mediaF = linha.lastIndexOf("ms");
					String mostra = linha.substring(mediaI, mediaF);
					System.out.println(mostra);
				}else {
					if (linha!=null && linha.contains("ximo")) {
						System.out.println(linha);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

//O segundo, chamado ping, que recebe o nome do Sistema Operacional
//como par�metro e, de acordo com o S.O., faz a chamada de ping com 10
//itera��es, filtra a sa�da, pegando apenas o tempo e d� a sa�da, em ms, do
//tempo m�dio do ping. (O endere�o para ping, pode ser o
//www.google.com.br) 