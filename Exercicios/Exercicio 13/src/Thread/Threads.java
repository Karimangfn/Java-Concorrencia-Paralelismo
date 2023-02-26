package Thread;

public class Threads {
	
	public static void main(String[] args) {
		// Thread Atual
		Thread t = Thread.currentThread();
		System.out.println(t.getName());
		
		
		// Nova Thread
		Thread t0 = new Thread(new MeuRunnable());
		//t0.run(); // apenas executando na mesma thread
		t0.start(); // executando em uma nova thread
		
		// Runnable com Lambda
		Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
		t1.start();
	}	
}
