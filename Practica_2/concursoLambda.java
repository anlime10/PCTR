public class concursoLambda {
    
    // Variable compartida entre ambas tareas
    static int contadorCompartido = 0;

    public static void main(String[] args) throws InterruptedException {
        
        // Número de iteraciones por hilo
        int iteraciones = 100000;

        // Modelando la Tarea 1 usando una expresión lambda (Runnable)
        Runnable tarea1 = () -> {
            for (int i = 0; i < iteraciones; i++) {
                contadorCompartido++; // Sección crítica
            }
        };

        // Modelando la Tarea 2 usando una expresión lambda (Runnable)
        Runnable tarea2 = () -> {
            for (int i = 0; i < iteraciones; i++) {
                contadorCompartido++; // Sección crítica
            }
        };

        // Creación de los hilos pasando las expresiones lambda
        Thread hilo1 = new Thread(tarea1, "Hilo-1");
        Thread hilo2 = new Thread(tarea2, "Hilo-2");

        // Iniciamos la ejecución concurrente
        hilo1.start();
        hilo2.start();

        // El hilo principal espera a que ambas tareas terminen
        hilo1.join();
        hilo2.join();

        // Mostramos los resultados
        System.out.println("--- Resultado de la Condición de Concurso ---");
        System.out.println("Valor esperado : " + (iteraciones * 2));
        System.out.println("Valor obtenido : " + contadorCompartido);
        System.out.println("---------------------------------------------");
        
        if (contadorCompartido != (iteraciones * 2)) {
            System.out.println("¡Se ha producido una condición de concurso!");
        } else {
            System.out.println("No hubo colisión esta vez (poco probable con tantas iteraciones).");
        }
    }
}