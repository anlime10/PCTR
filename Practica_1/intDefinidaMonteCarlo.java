import java.util.concurrent.ThreadLocalRandom;
public class intDefinidaMonteCarlo {
    private static double montecarlo(int n_puntos)
    {
        int C=0;
        double M=1; //Con seno es 0.8415
        for (int i=0;i<n_puntos;i++)
        {
            double x_i=Math.random();
            double x_y=ThreadLocalRandom.current().nextDouble(0,M);
            if (x_y<= Math.sin(x_i)) //Math.sin(x_i)
            {
                C++;
            }
        }
        return M*((double)C/n_puntos);
    }
    public static void main(String[] args) {
        if (args.length==0)
        {
            System.out.println("Introduce un entero");
        }
        else
        {
            System.out.printf("El resultado mediante montecarlo es %f\n",montecarlo(Integer.parseInt(args[0])));
        }
    }
}
