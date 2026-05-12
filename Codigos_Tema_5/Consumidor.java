import java.util.concurrent.*;

public class Consumidor
implements Runnable {

 LinkedBlockingQueue < Integer > data;
 Thread hilo;

 public Consumidor(LinkedBlockingQueue < Integer > l) {
  this.data = l;
  hilo = new Thread(this);
  hilo.start();
 }

 public void run() {
  try {
   for (;;)
    System.out.println("Extrayendo " + data.take().intValue());
  } catch (InterruptedException e) {}
 }
}