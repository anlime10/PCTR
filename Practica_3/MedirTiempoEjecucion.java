import java.util.Arrays;
import java.util.Random;

public class MedirTiempoEjecucion {

    public static void main(String[] args) {
        // 1. Declarar e inicializar el vector de 1000 componentes (números reales)
        double[] vectorNumeros = new double[1000];
        Random random = new Random();

        // Llenar el vector con números reales aleatorios
        for (int i = 0; i < vectorNumeros.length; i++) {
            vectorNumeros[i] = random.nextDouble() * 1000.0; 
        }

        System.out.println("Vector generado. Iniciando la ordenación...");

        // 2. Capturar el tiempo EXACTAMENTE ANTES de ejecutar la tarea
        long tiempoInicio = System.nanoTime();

        // 3. Ejecutar la tarea a medir (ordenar el vector)
        Arrays.sort(vectorNumeros);

        // 4. Capturar el tiempo EXACTAMENTE DESPUÉS de ejecutar la tarea
        long tiempoFin = System.nanoTime();

        // 5. Calcular la diferencia para obtener el tiempo de ejecución
        long tiempoEjecucionNanosegundos = tiempoFin - tiempoInicio;

        // Opcional: Convertir a milisegundos para una lectura más humana
        double tiempoEjecucionMilisegundos = tiempoEjecucionNanosegundos / 1_000_000.0;

        // Mostrar los resultados por consola
        System.out.println("¡Vector ordenado con éxito!");
        System.out.println("Tiempo de ejecución: " + tiempoEjecucionNanosegundos + " nanosegundos.");
        System.out.println("Tiempo de ejecución: " + tiempoEjecucionMilisegundos + " milisegundos.");
    }
}