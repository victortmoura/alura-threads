package br.com.alura.banheiro;

public class Banheiro {
	
	boolean estaSujo = true;

	public void fazNumero1() {
		
		String nome = Thread.currentThread().getName();
	
		synchronized (this) {
			if(this.estaSujo) {
				System.out.println(nome + " entrando no banheiro");
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " fazendo coisa rapida");
			
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mão");
			System.out.println(nome + " saindo do banheiro");
		}

	}

	public void fazNumero2() {
		
		String nome = Thread.currentThread().getName();

		synchronized (this) {
			if(this.estaSujo) {
				System.out.println(nome + " entrando no banheiro");
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " fazendo coisa demorada");
			
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando a mão");
			System.out.println(nome + " saindo do banheiro");
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

	public void limpa() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " entrando no banehiro ");
			
			if(!estaSujo) {
				System.out.println(nome + ", não está sujo, vou sair.");
				return;
			}
			
			System.out.println(nome + " limpando o banheiro");
			estaSujo = false;
			
			try {
				Thread.sleep(13000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.notifyAll();
			
			System.out.println(nome + " saindo do banheiro");
		}
	}
	
}
