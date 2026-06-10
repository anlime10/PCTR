public class UsalecEscAN implements Runnable {

    lecEscAN monitor;
    boolean esEscritor;

    public UsalecEscAN(lecEscAN monitor, boolean esEscritor) {
        this.monitor = monitor;
        this.esEscritor = esEscritor;
    }

    public void run() {
            if (esEscritor) monitor.escribir();
            else monitor.leer();
        
    }

    public static void main(String[] args) throws InterruptedException {

        lecEscAN monitor = new lecEscAN();

        Thread[] hilos = {
            new Thread(new UsalecEscAN(monitor, false), "Lector-1"),
            new Thread(new UsalecEscAN(monitor, false), "Lector-2"),
            new Thread(new UsalecEscAN(monitor, true),  "Escritor-1"),
            new Thread(new UsalecEscAN(monitor, false), "Lector-3"),
            new Thread(new UsalecEscAN(monitor, true),  "Escritor-2"),
        };

        for (Thread h : hilos) h.start();
        for (Thread h : hilos) h.join();

        System.out.println("Todos los hilos han terminado.");
    }
}