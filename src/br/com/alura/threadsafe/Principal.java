package br.com.alura.threadsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		Lista lista = new Lista();
		for (int i = 0; i < 10; i++) {
			new Thread(new TarefaAdicionarElemento(lista, i)).start();;
		}
		
		Thread.sleep(2000);
		
		for (int i = 0; i < lista.tamanho(); i++) {
			System.out.println(lista.pegaElemento(i));
		}
	}
}
