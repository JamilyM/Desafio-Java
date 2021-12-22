package Java;

import java.io.File;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivo {
	
	public static void main(String[] args) throws Exception {
		GlobalSales();
	}
	
	public static void GlobalSales() throws Exception{
		
		String nome = "";
		String ano = "";
		Double globalSales = 0.0;
		String linha = "";
		Double soma = 0.0;
		Double media = 0.0;
		Integer valores = 0;
		Double somaDesvio = 0.0;
		List<VendasJogos> lista = new ArrayList<>(); 
		List<Double> list = new ArrayList<>(); 
		String text = "";

		
//		aqui eu leio o arquivo e guardo no objeto scanner
		Scanner scanner = new Scanner(new File("vgsales.csv"));
//		pulo o cabeçalho
		scanner.nextLine();
		
		PrintWriter salvar = new PrintWriter(new File("nomes.txt"));
//		
		while(scanner.hasNextLine()) {
			linha = scanner.nextLine();
			String[] vect = linha.split(",");
			globalSales = Double.parseDouble(vect[10]);
			ano = vect[3];
			nome = vect[1];
			soma += globalSales;
			valores++;
			media = soma / valores;
			
			lista.add(new VendasJogos(nome, ano, globalSales));
			list.add(globalSales);
			
		}
		
		 for (double elemento : list) {
		        double desvio = Math.pow(elemento - media, 2);
		        somaDesvio += desvio;
		}
		
		
		for(VendasJogos linhas : lista) {
			
			text = linhas.getAno().replaceAll("[^0-9.]", "");
			if(text.length() == 4) {
				int listInt = Integer.parseInt(text);
				if (listInt > 2000 && linhas.getGlobalSales() > 2f ) {
					System.out.println("Após o ano 2000: " + linhas.getNome());
					salvar.println(linhas.getNome());
				}
							   
			}
		}
		System.out.format("Média: " + NumberFormat.getIntegerInstance().format(media * 1000000) + "\n");
		System.out.println("Desvio padrão: " + NumberFormat.getIntegerInstance().format(Math.sqrt(somaDesvio/valores) * 1000000));
		salvar.close();
	}
}
