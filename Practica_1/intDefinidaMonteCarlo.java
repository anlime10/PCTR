public class intDefinidaMonteCarlo {
    private static void MonteCarlo(int n)
    {
        double contador_exitos=0;
        for (int i=0;i<n;i++)
        {
            double x=Math.random(),y=Math.random();
            if(y<=x)
            {
                contador_exitos++;
            }
        }
        System.out.printf("Integral aproximada: %f",contador_exitos/(double) n);
    }
    public static void main(String[] args) {
    int dato0;
    if (args.length == 0)
        {
            System.out.println ("Debe dar una funcion como argumento...");
            System.exit(-1);
        }
        else
        try {
        int firstArg = Integer.parseInt(args[0]);
        }    catch (NumberFormatException e) {
        System.err.println("Argument" + args[0] + " must be an integer.");
        System.exit(1);
        }
        dato0= Integer.parseInt(args[0]);
        MonteCarlo(dato0);
    }
}

