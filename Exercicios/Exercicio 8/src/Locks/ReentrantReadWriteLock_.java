import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLock_ {

private static int i = -1;
  
  private static ReadWriteLock lock = new ReentrantReadWriteLock();
  
  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();
    
    Runnable r1 = () -> {
      Lock writeLock = lock.writeLock(); //Lock de escrita sempre escreve primeiro
      writeLock.lock();
      String name = Thread.currentThread().getName();
      System.out.println(name + " - Escrevendo: " + i);
      i++;
      System.out.println(name + " - Escrito: " + i);
      writeLock.unlock();
    };
    
    Runnable r2 = () -> {
      Lock readLock = lock.readLock(); //Lock de leitura não bloqueia um Lock de Escrita, ja que altera o valor de escrita
      readLock.lock();
      System.out.println("Lendo: " + i);
      System.out.println("Lido: " + i);
      readLock.unlock();
    };
    
    for (int i = 0; i < 6; i++) {
      executor.execute(r1);
      executor.execute(r2);
    }
    
    executor.shutdown();
  }
  
}
