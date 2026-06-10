import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UsamonitorImpresoras implements Runnable{
    monitorImpresoras M;
    UsamonitorImpresoras(monitorImpresoras mon)
    {
        this.M=mon;
    }
    public static void main(String[] args)
    {
        int n=Integer.parseInt(args[0]);
        monitorImpresoras monitor= new monitorImpresoras();
        ExecutorService ejecutor= Executors.newFixedThreadPool(n);
        for(int i=0;i<n;i++)
        {
        ejecutor.execute(new UsamonitorImpresoras(monitor));
        }
        ejecutor.shutdown();
        try{
        ejecutor.awaitTermination(1, TimeUnit.HOURS);
        } catch(InterruptedException e){}
    }
    public void run()
    {
        for (int i=0; i<5; i++)
        {
            int n=M.pedirImpresora();
            System.out.println("El hilo " + Thread.currentThread().getName() + " tiene la impresora" + n);
            System.out.println("El hilo " + Thread.currentThread().getName() + " libera la impresora");
            M.liberarImpresora(n);
        }
    }
}
