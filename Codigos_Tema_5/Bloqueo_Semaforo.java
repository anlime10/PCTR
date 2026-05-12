import java.util.concurrent.*;

public class Bloqueo_Semaforo {

 public static void main(String[] args)
 throws InterruptedException {
  Semaphore sem = new Semaphore(2);
  sem.acquire(2);
  System.out.println("Ahora el semaforo esta a 0...");
  System.out.println("y su estado es: " + sem.toString());
  System.out.println("Ahora intentamos adquirirlo...");
  sem.tryAcquire();
  System.out.println("sin bloqueo por no conseguirlo");
  System.out.println("Ahora intentamos adquirirlo...");
  sem.tryAcquire(3L, TimeUnit.SECONDS);
  System.out.println("tras esperar lo indicado sin conseguirlo...");
  sem.acquire();
  System.out.println("Aqui no llegaremos nunca...");

 }
}