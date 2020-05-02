package br.com.alura.threads;

public class RespostaMain {
	
//	utilizando a classe Thread de uma forma mais enxuta
	
	public static void main(String[] args) {
		
//		Nesse caso o compilador gera uma classe anonima que 
//		implementa a interface. E' uma forma mais enxuta de usar a tarefa
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("ola thread");
			}
		}).start();
		
//		Alem disso, como o compilador realmente gera uma classe, essa classe, 
//		de fato, existe quando e executada. Isso pode ser mais dificil de se entender 
//		quando recebemos uma excecao ou depuramos o codigo pois a classe nao esta presente
//		no nosso codigo fonte.
//		
	}
}
