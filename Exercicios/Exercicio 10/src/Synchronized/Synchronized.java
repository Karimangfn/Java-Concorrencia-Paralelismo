public class Synchronized {

	static int i = -1;

	public static void main(String[] args) {
		MeuRunnable runnable = new MeuRunnable();

		Thread t0 = new Thread(runnable);
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);
		Thread t4 = new Thread(runnable);

		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	public static class MeuRunnable implements Runnable {
		/* 1)
		static Object lock1 = new Object();
		static Object lock2 = new Object();
		@Override
		public void run() {
			synchronized(lock1) {
				i++;
				System.out.println(Thread.currentThread().getName() + ":" + i);	
			}
			synchronized(lock2) {
				i++;
				System.out.println(Thread.currentThread().getName() + ":" + i);	
			}		
		}
		 */

		/* 2)
		@Override
		public synchronized void run() {
			i++;
			System.out.println(Thread.currentThread().getName() + ":" + i);		
		}
		 */	

		// 3)
		public void run() {
			synchronized (this) {
				i++;
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}

	}
}
