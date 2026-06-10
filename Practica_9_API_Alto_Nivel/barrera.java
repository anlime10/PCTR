import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class barrera implements Runnable{
    CyclicBarrier bar;
    barrera(CyclicBarrier b)
    {
        this.bar=b;
    }
    public static void main(String[] args)
    {
        ExecutorService ejecutor= Executors.newFixedThreadPool(8);
        CyclicBarrier b= new CyclicBarrier(8);
        for (int i=0; i<8 ; i++)
        {
            ejecutor.execute(new barrera(b));
        }
    }
    public void run()
    {
        System.out.println("Hebra " + Thread.currentThread().getName() + " creada y esperando a la creación de las demás");
        try{bar.await();}catch (BrokenBarrierException | InterruptedException c){};
        System.out.println("TODAS UNIDAS");
        try{bar.await();}catch (BrokenBarrierException | InterruptedException c){};
        System.out.println("SEGUNDA UNION");
    }
}
