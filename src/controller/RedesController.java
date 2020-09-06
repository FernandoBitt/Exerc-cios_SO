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
//parâmetro e, de acordo com o S.O., faz a chamada de configuração de IP e
//filtra a saída do processo, retornando um String com o nome do Adaptador
//Ethernet e o IPv4 apenas (Não importa o número de adaptadores ethernet,
//devem aparecer todos). Os adaptadores que não tiverem IPv4 não devem
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
//como parâmetro e, de acordo com o S.O., faz a chamada de ping com 10
//iterações, filtra a saída, pegando apenas o tempo e dá a saída, em ms, do
//tempo médio do ping. (O endereço para ping, pode ser o
//www.google.com.br) 