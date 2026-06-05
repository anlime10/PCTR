public class deadlock extends Thread {
    // Declaramos dos recursos genéricos para cada hebra
    private Object recurso1;
    private Object recurso2;

    // El constructor recibe los dos recursos que la hebra intentará bloquear
    public deadlock(Object r1, Object r2, String nombre) {
        super(nombre);
        this.recurso1 = r1;
        this.recurso2 = r2;
    }

    public static void main(String[] args) {
        // 1. Creamos tres candados/recursos distintos
        Object recursoA = new Object();
        Object recursoB = new Object();
        Object recursoC = new Object();

        // 2. Aquí está la magia: creamos el círculo de dependencias cruzando los parámetros
        deadlock h1 = new deadlock(recursoA, recursoB, "Hebra 1");
        deadlock h2 = new deadlock(recursoB, recursoC, "Hebra 2");
        deadlock h3 = new deadlock(recursoC, recursoA, "Hebra 3");

        // 3. Iniciamos las hebras
        h1.start();
        h2.start();
        h3.start();
    }

    @Override
    public void run() {
        // Bloqueamos el primer recurso
        synchronized (recurso1) {
            System.out.println(getName() + " ha bloqueado su primer recurso.");
            
            // Pausamos un instante para garantizar que todas las hebras 
            // bloqueen su primer recurso ANTES de intentar ir a por el segundo.
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}

            System.out.println(getName() + " esperando por su segundo recurso...");
            
            // Intentamos bloquear el segundo recurso (Aquí ocurre el deadlock)
            synchronized (recurso2) {
                System.out.println(getName() + " ha conseguido ambos recursos.");
            }
        }
    }
}