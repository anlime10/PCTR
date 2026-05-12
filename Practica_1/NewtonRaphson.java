public class NewtonRaphson {
    private static void newtonraphson(double x0,int iteraciones)
    {
        double xN=x0,xN1=xN;
        for (int i=0; i<iteraciones ;i++)
        {
            if (Math.cos(xN)-xN*xN*xN != 0)
            {
                xN1=xN-((Math.cos(xN)-Math.pow(xN,3))/(-Math.sin(xN)-3*Math.pow(xN,2)));
                System.out.printf("Iteracion: %d. Aproximacion %f.%n",i,xN1);
            }
            xN=xN1;
        }
        System.out.printf("Resultado: %f",xN);
    }
    public static void main(String[] args) 
    {
        double dato0;
        int dato1;
        if (args.length == 0)
        {
            System.out.println ("Debe dar una funcion como argumento...");
            System.exit(-1);
        }
        else
        try {
        double firstArg = Double.parseDouble(args[0]);
        }    catch (NumberFormatException e) {
        System.err.println("Argument" + args[0] + " must be an integer.");
        System.exit(1);
        }
        dato0= Double.parseDouble(args[0]);
        dato1= Integer.parseInt(args[1]);
        newtonraphson(dato0,dato1);
    }
}
