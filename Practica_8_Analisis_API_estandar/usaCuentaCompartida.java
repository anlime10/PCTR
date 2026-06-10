package PCTR.Practica_8_Analisis_API_estandar;

// 1. Es mejor convención en Java que las clases empiecen por mayúscula
public class usaCuentaCompartida implements Runnable { 
    
    CuentaCompartida cuenta; // Nombre de variable más descriptivo que 'a'

    // Constructor
    usaCuentaCompartida(CuentaCompartida cuenta) {
        this.cuenta = cuenta;
    }

    public static void main(String[] args) {
        CuentaCompartida cuentaComun = new CuentaCompartida();
        
        // 2. Uso de arrays para manejar las hebras de forma elegante y no repetir código
        Thread[] titulares = new Thread[8];

        // Inicializamos y arrancamos las 8 hebras
        for (int i = 0; i < titulares.length; i++) {
            // Le damos un nombre personalizado a cada hebra para leer mejor la consola
            titulares[i] = new Thread(new usaCuentaCompartida(cuentaComun), "Titular-" + (i + 1));
            titulares[i].start();
        }

        // Esperamos a que todas las hebras terminen con join()
        for (int i = 0; i < titulares.length; i++) {
            try {
                titulares[i].join();
            } catch (InterruptedException e) {
                System.out.println("El hilo principal fue interrumpido.");
            }
        }
        
        System.out.println("Todos los titulares han terminado sus operaciones.");
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep((long) (Math.random() * 10));

                boolean esIngreso = Math.random() > 0.5;
                
                // 3. Ajuste clave: Reducimos la cantidad máxima de reintegro 
                // para evitar que la cuenta se quede seca y las hebras se bloqueen para siempre.
                int cuantia;

                if (esIngreso) {
                    cuantia = (int) (Math.random() * 100) + 1; // Ingresan entre 1 y 100
                    System.out.println(Thread.currentThread().getName() + " intenta ingresar: " + cuantia);
                    cuenta.ingreso(cuantia);
                } else {
                    cuantia = (int) (Math.random() * 50) + 1;  // Retiran entre 1 y 50
                    System.out.println(Thread.currentThread().getName() + " intenta retirar:  " + cuantia);
                    cuenta.reintegro(cuantia);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " fue interrumpida.");
                break; 
            }
        }
        System.out.println(Thread.currentThread().getName() + " ha terminado sus operaciones.");
    }
}