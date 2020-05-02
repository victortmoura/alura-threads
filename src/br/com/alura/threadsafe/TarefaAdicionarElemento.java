package br.com.alura.threadsafe;

import java.util.Collections;
import java.util.List;

public class TarefaAdicionarElemento implements Runnable {

	private Lista lista;
	private int numeroDoThread;

	public TarefaAdicionarElemento(Lista lista, int numeroDoThread) {
		this.lista = lista;
		this.numeroDoThread = numeroDoThread;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			lista.adicionaElementos("Thread " + numeroDoThread + " - " + i);
		}
	}

}
