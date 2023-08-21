import java.util.Random;

public class Aplicacao {

	public static void main(String[] args) {
		
		Random rand = new Random();

		BlockingQueue<Integer> bloquingQueue = new BlockingQueue<>();
		
		// Tentando adicionar números a lista durante mil tentativas em paralelo
		
		new Thread(() -> {
			for(int j = 0; j < 100; j++) {
				try {
					bloquingQueue.put(rand.nextInt());
					System.out.println("Adicionando");
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		// Tentando remover números da lista durante mil tentativas em paralelo
		
		new Thread(() -> {
			for(int j = 0; j < 100; j++) {
				try {
					bloquingQueue.take();
					System.out.println("Removendo");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
