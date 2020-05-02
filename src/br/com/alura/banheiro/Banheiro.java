package br.com.alura.banheiro;

public class Banheiro {
	
	boolean estaSujo = true;

	public void fazNumero1() {
		
		String nome = Thread.currentThread().getName();
	
		synchronized (this) {
			System.out.println(nome + " batendo na porta");
			
			while(estaSujo) {
				esperaLaFora(nome);
			}
			System.out.println(nome + " fazendo coisa rapida");
			
			dormeThread(5000);
			estaSujo = true;
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mão");
			System.out.println(nome + " saindo do banheiro");
		}

	}

	public void fazNumero2() {
		
		String nome = Thread.currentThread().getName();

		synchronized (this) {
			System.out.println(nome + " batendo na porta");
			
			while(estaSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " fazendo coisa demorada");
			
			dormeThread(15000);
			estaSujo = true;
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mão");
			System.out.println(nome + " saindo do banheiro");
		}
	}
	
	public void limpa() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " entrando no banheiro ");
			
			if(!estaSujo) {
				System.out.println(nome + ", não está sujo, vou sair.");
				return;
			}
			
			System.out.println(nome + " limpando o banheiro");
			estaSujo = false;
			
			dormeThread(13000);
			
			this.notifyAll();
			
			System.out.println(nome + " saindo do banheiro");
		}
	}
	
	private void dormeThread(long tempoMili) {
		try {
			Thread.sleep(tempoMili);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void esperaLaFora(String nome) {
		System.out.println(nome + " eca, está sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}