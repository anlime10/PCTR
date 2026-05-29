public class redCajeros {
    public int tipo;
    public static void main(String[] args) {
        cuentaCorriente cC= new cuentaCorriente(null, 4000);
        cajero c= new cajero(cC,100);
        cajero c2= new cajero(cC,-100);
        Thread h1 = new Thread(c); Thread h2 = new Thread(c2); Thread h3 = new Thread(c); Thread h4 = new Thread(c2); 
        h1.start();h2.start();h3.start();h4.start();
        try
        {
        h1.join();h2.join();h3.join();h4.join();
        }catch (InterruptedException e)
        {
        System.out.println("El hilo principal fue interrumpido.");
        e.printStackTrace();
        }
        System.out.println("El saldo es:" + cC.getSaldo());
    }
}
