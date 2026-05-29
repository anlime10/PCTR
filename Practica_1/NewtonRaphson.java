public class NewtonRaphson {
    private static void newtonraphson (double x0, int iter) //metodo newtonrapshon , Precondición entra double de primera aproximación y numero de iteraciones
    {
        for (int i=1; i<=iter;i++)
        {
            //x0=x0-((Math.cos(x0)-Math.pow(x0,3))/(-Math.sin(x0)-3*Math.pow(x0,2)));
            x0=x0-((Math.pow(x0,2)-5)/(2*x0));
            System.out.printf("Aproximacion %f,iteracion %d\n",x0,i);
        }
    } 
    public static void main(String[] args) {
        if (args.length < 2){
      System.out.println ("Debe dar un double y un int como argumentos");
      System.exit(-1);
     }
     double x0 = Double.parseDouble(args[0]);
     int x1 = Integer.parseInt(args[1]);
     newtonraphson(x0,x1);
    }
}
