import java.util.Random;
public class prodEscalar {
    public static void main (String args[])
    {
        Random r =new Random();
        double mult=0;
        double[] v1= new double[1000000],v2 = new double[1000000];
        for(int i=0; i<1000000;i++)
        {
            v1[i]=r.nextDouble();
            v2[i]=r.nextDouble();
        }
        long tiempoInicio = System.nanoTime();
        for(int i=0;i<1000000;i++)
        {
            mult=mult+(v1[i]*v2[i]);
        }
        long tiempoFin = System.nanoTime();

        long tiempoEjecucionNanosegundos = tiempoFin - tiempoInicio;

        double tiempoEjecucionMilisegundos = tiempoEjecucionNanosegundos / 1_000_000.0;
        System.out.println("El tiempo de ejecucion ha sido " + tiempoEjecucionMilisegundos);
    }

}
