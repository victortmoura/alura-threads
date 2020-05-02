package br.com.alura.banheiro;

public class TestaBanheiro {
	
	public static void main(String[] args) {
		
		Banheiro banheiro = new Banheiro();
		
		Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Victor");
		Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Joao");
//		Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Pedro");
//		Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Bruna");
		Thread limpeza    = new Thread(new TarefaLimpeza(banheiro), "Tia da limpeza");
		limpeza.setDaemon(true);
		
		convidado1.start();
		convidado2.start();
//		convidado3.start();
//		convidado4.start();
		limpeza.start();
	}
}
