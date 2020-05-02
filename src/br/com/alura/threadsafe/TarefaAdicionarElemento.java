package br.com.alura.threadsafe;

import java.util.Collections;
import java.util.List;

public class TarefaAdicionarElemento implements Runnable {

	private List<String> lista;
	private int numeroDoThread;

	public TarefaAdicionarElemento(List<String> lista, int numeroDoThread) {
		this.lista = lista;
		this.numeroDoThread = numeroDoThread;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			lista.add("Thread " + numeroDoThread + " - " + i);
		}
	}

}
