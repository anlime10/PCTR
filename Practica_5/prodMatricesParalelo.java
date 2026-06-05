import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.random.*;
public class prodMatricesParalelo {
    public static void main(String args[])
    {
        int tamMatriz= Integer.parseInt(args[0]);
        int ntareas= Integer.parseInt(args[1]);
        int tVentana= tamMatriz/ntareas;
        Random r= new Random();
        int[][]m1= new int[tamMatriz][tamMatriz];
        int[][]m2= new int[tamMatriz][tamMatriz];
        int[][]mr= new int[tamMatriz][tamMatriz];
        for(int i=0;i<tamMatriz;i++)
            for(int j=0;j<tamMatriz;j++)
            {
                m1[i][j]=r.nextInt();
                m2[i][j]=r.nextInt();
            }
        long tiempoini=System.nanoTime();
        ExecutorService ejecutor = Executors.newFixedThreadPool(ntareas);
        for(int i=0;i<ntareas;i++)
        {
            ejecutor.execute(new tareaprodMatrices(tVentana*i,tVentana*(i+1),m1,m2,mr));
        }
        ejecutor.shutdown();
        try{
            ejecutor.awaitTermination(1,TimeUnit.HOURS);
        }catch(InterruptedException e){}
        long tiempofin=System.nanoTime();
        long tiempototal=(tiempofin-tiempoini)/(long)1.0e9;
        System.out.println("El tiempo de ejecucion paralelo ha sido " + tiempototal + " segundos");
    } 
}
