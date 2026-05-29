public class Usa_tareaRunnable {
    public static void main(String[] args) {
    int iteraciones=10000;
    Objeto_compartido o = new Objeto_compartido();
    tareaRunnable t1= new tareaRunnable(iteraciones,true,o);
    tareaRunnable t2= new tareaRunnable(iteraciones,false,o);
    Thread h1= new Thread(t1);
    Thread h2= new Thread(t2);
    h1.start();h2.start();
    try{
        h1.join();h2.join();
    }catch(InterruptedException e) 
    {
        System.out.println("El hilo principal fue interrumpido.");
        e.printStackTrace();
    }
        System.out.println("Número de iteraciones por hilo: " + iteraciones);
        System.out.println("Valor teórico final de n: 0");
        System.out.println("Valor práctico final de n: " + o.observar());
    }
}
