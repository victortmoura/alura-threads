package br.com.alura.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaNome implements Runnable {

	private String nomeArquivo;
	private String nomeProcurado;

	public TarefaBuscaNome(String nomeArquivo, String nomeProcurado) {
		this.nomeArquivo = nomeArquivo;
		this.nomeProcurado = nomeProcurado;
	}

	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(new File("autores.txt"));
			
			int numeroLinha = 1;
			
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				
				if(linha.toLowerCase().contains(nomeProcurado.toLowerCase())) {
					System.out.println(nomeArquivo + " - " + numeroLinha + " - " + linha);
				}
				
				numeroLinha++;
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
