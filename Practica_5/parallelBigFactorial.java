import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class parallelBigFactorial {
    public static void main(String args[])
    {
        BigInteger resultado= new BigInteger("1");
        BigInteger a= new BigInteger(args[0]);
        BigInteger tVentana= a.divide(new BigInteger("8"));
        int nTareas=8;
        List<Future<BigInteger>> lista=(new ArrayList<>());
        ExecutorService ejecutor= Executors.newFixedThreadPool(nTareas);
        long tiempo_ini=System.nanoTime();
        for (int i=0;i<8;i++)
        {
            if (i == nTareas - 1) {
                lista.add(ejecutor.submit(new tareaBigFactorial(tVentana.multiply(BigInteger.valueOf(i)),a)));
            }
            lista.add(ejecutor.submit(new tareaBigFactorial(tVentana.multiply(BigInteger.valueOf(i)),tVentana.multiply(BigInteger.valueOf(i+1)))));
        }
        ejecutor.shutdown();
        for(Future<BigInteger> iterador:lista)
      try{
      	  resultado= resultado.multiply(iterador.get()); 
      }catch (CancellationException e){}
       catch (ExecutionException e){}
       catch (InterruptedException e){}
       long tiempo_fin=System.nanoTime();
       long tiempo_total=(tiempo_fin-tiempo_ini)/(long)1.0e9;
       System.out.println("El timepo final en segundos es:" + tiempo_total);
    }
}
