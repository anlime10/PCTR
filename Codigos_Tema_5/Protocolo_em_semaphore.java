import java.lang.*;
import java.util.concurrent.*;
public class Protocolo_em_semaphore {

  public static void main(String[] args)
    {
	  Semaphore sem  = new Semaphore (1);
	  Tarea_concurrente Tarea_1 = new Tarea_concurrente (sem);
	  Tarea_concurrente Tarea_2 = new Tarea_concurrente (sem);
	  Tarea_2.start();
	  Tarea_1.start();
    }
}
