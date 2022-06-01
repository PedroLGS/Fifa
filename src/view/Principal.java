package view;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import controller.FifaController;

public interface Principal{
	public static void main(String[]args) {
		FifaController fifc = new FifaController();
		String caminho = "C:\\TEMP";
		String arq = "data.csv";
		try {
			System.out.println("Jogadores brasileiros com Overall acima de 80");
			Stack<String> pil = new Stack<String>();
			pil = fifc.empilhaBrasileiros(caminho, arq);
			fifc.desmpilhaBonsBrasileiros(pil);
			System.out.println("Jogadores menores de 20 anos com Overall acima de 80");
			List<String> obl = new LinkedList<String>();
			obl = fifc.listaRevelacoes(caminho, arq);
			fifc.buscaListaBonsJovens(obl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}