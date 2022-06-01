package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FifaController implements IFifaController{

	@Override
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		File dir = new File(caminho);
		File file = new File(caminho,nome);
		Stack<String> pilha = new Stack<String>();
		if(dir.exists() && dir.isDirectory()) {
			if(file.exists() && file.isFile()) {
				FileInputStream fileinput = new FileInputStream(file);
				InputStreamReader inputstream = new InputStreamReader(fileinput);
				BufferedReader buffered = new BufferedReader(inputstream);
				String valor = buffered.readLine();
				valor = buffered.readLine();
				while(valor != null){
					String[] sv = valor.split(",");
					if(sv[5].equalsIgnoreCase("Brazil")) {
						pilha.push(valor);
					}
					valor = buffered.readLine();
					}
				}else {
					throw new IOException("Não é diretório");
			}
		}else {
			throw new IOException("Não é arquivo");
		}
		return pilha;
	}
	@Override
	public void desmpilhaBonsBrasileiros(Stack<String> pilha) throws IOException {
		while(pilha.size()!=0){
			String player = pilha.pop();
			String[] sp = player.split(",");
			if(Integer.parseInt(sp[7]) > 80) {
				System.out.println("Nome do jogador: " +sp[2]+ " - Overall: " +sp[7]);
			}
		}
		
	}

	@Override
	public  List<String> listaRevelacoes(String caminho, String nome) throws IOException {
		File dir = new File(caminho);
		File file = new File(caminho,nome);
		List<String> li = new LinkedList<String>();
		if(dir.exists() &&dir.isDirectory()) {
			if(file.exists() && file.isFile()) {
				FileInputStream fileinput = new FileInputStream(file);
				InputStreamReader inputstream = new InputStreamReader(fileinput);
				BufferedReader buffered = new BufferedReader(inputstream);
				buffered.readLine();
				String valor = buffered.readLine();
				while(valor != null) {
					String[] sp = valor.split(",");
					if(Integer.parseInt(sp[3]) <= 20) {
						li.add(valor);
				}
					valor = buffered.readLine();
			}
			}
			
		}else {
			throw new IOException("Não é dir");
		}
		return li;
		
	}
	@Override
	public void buscaListaBonsJovens(List<String> lista) throws IOException {
		Iterator<String> it = lista.iterator();
		while(it.hasNext()) {
			String gp = it.next();
			String[] sp = gp.split(",");
			if(Integer.parseInt(sp[7]) > 80) {
				System.out.println("Nome do jogador: " +sp[2]+ " - Idade: "+sp[3]+" - Overall: " +sp[7]);
			}
		}
		
	}

}