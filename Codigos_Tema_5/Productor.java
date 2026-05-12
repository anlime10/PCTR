import java.util.concurrent.*;

public class Productor
implements Runnable {

 LinkedBlockingQueue < Integer > data;
 Thread hilo;

 public Productor(LinkedBlockingQueue < Integer > l) {
  this.data = l;
  hilo = new Thread(this);
  hilo.start();
 }

 public void run() {
  try {
   for (int x = 0;; x++) {
    data.put(Integer.valueOf(x));
    System.out.println("Insertando " + x);
   }
  } catch (InterruptedException e) {}
 }
}