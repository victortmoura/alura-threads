package br.com.alura.threads;

import br.com.alura.banheiro.Banheiro;
import br.com.alura.banheiro.TarefaLimpeza;
import br.com.alura.banheiro.TarefaNumero1;
import br.com.alura.banheiro.TarefaNumero2;

public class TestaBanheiro {
	
	public static void main(String[] args) {
		
		Banheiro banheiro = new Banheiro();
		
		Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Victor");
		Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Joao");
//		Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Pedro");
//		Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Bruna");
		Thread limpeza    = new Thread(new TarefaLimpeza(banheiro), "Tia da limpeza");
		
		convidado1.start();
		convidado2.start();
//		convidado3.start();
//		convidado4.start();
		limpeza.start();
	}
}
