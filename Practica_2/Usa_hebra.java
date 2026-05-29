public class Usa_hebra {
    public static void main(String[] args) {
        int iteraciones = 1000000;
        hebra h1= new hebra(1000000,true);
        hebra h2= new hebra(1000000,false);
        h1.start();h2.start();
        try{
        h1.join(); h2.join();
        } catch (InterruptedException e){}
        System.out.println("Numero de iteraciones por hilo:"+ iteraciones);
        System.out.println("Valor teórico final de n:0");
        System.out.println("Valor real de n:" + hebra.n);
    }
}
