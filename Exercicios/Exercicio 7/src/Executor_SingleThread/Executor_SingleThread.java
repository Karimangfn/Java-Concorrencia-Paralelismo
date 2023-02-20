import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Executor_SingleThread {

	public static void main(String[] args) throws Exception {
		ExecutorService executor = null;
		try {
			executor = Executors.newSingleThreadExecutor(); // Executa uma Thread

			Future<String> future = executor.submit(new Tarefa()); 

			System.out.println(future.isDone()); //Para ver se a tarefa foi executada
			//System.out.println(future.get());
			System.out.println(future.get(5, TimeUnit.SECONDS));
			System.out.println(future.isDone());

			//executor.shutdown();
			//executor.awaitTermination(10, TimeUnit.SECONDS);
			//System.out.println(future.isDone());
		} catch (Exception e) {
			throw e;
		} finally {
			if (executor != null) {
				//executor.shutdown();
				executor.shutdownNow();
			}
		}
	}

	public static class Tarefa implements Callable<String> {
		@Override
		public String call() throws Exception {
			Thread.sleep(1000);
			String name = Thread.currentThread().getName();
			int nextInt = new Random().nextInt(1000);
			return name + ": Mensagem! " + nextInt;
		}
	}

}
