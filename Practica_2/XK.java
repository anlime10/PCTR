import java.util.*;
public class XK  extends Thread{ //Esta clase son hilos, cuando hacemos start lo que hacemos es hacer la funcion run y ponemos 
  //ini y fin simplementa para decir de que numero a que numero procesan XK.

    static double[] data = new double[10]; //Declaración de un array de double
    double escalar = 2;
    int inicio;int fin;

    public XK(int ini, int fin){
      this.inicio = ini;
      this.fin    = fin;
    } //funcion XK

    public void run(){
      for(int i=inicio; i<=fin; i++)
        data[i]=data[i]*escalar;
    } //funcion que calcula el doble de cada double del vector

    public static void main(String[] args)
    	throws Exception{
      for(int i=0; i<data.length; i++)
        data[i]=Math.random();
      System.out.println(Arrays.toString(data));
      XK h1 = new XK(0, 4);
      XK h2 = new XK(5, 9);
      h1.start(); h2.start(); //Inicializa las hebras como iniicio 0,fin 4 y inicio 5 y fin 9 por lo que se va a run.
      h1.join(); h2.join();
      System.out.println(Arrays.toString(data));
    }
}