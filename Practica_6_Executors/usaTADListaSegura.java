import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class usaTADListaSegura implements Runnable{
    public TADListaSegura a;
    public usaTADListaSegura(TADListaSegura x)
    {
        a=x;
    }
    public void run() {
        String nombreHilo = Thread.currentThread().getName();
        
        // 1. Cada hilo inserta 3 valores aleatorios
        for (int i = 0; i < 3; i++) {
            int valor = (int) (Math.random() * 100);
            a.insertar(valor);
            System.out.println(nombreHilo + " insertó el valor: " + valor);
            
            // Pausa simulada para forzar el entrelazado de hilos
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {}
        }

        // 2. Cada hilo imprime la lista tras terminar sus inserciones
        System.out.print(nombreHilo + " ve la lista así: ");
        a.imprimir_lista();
        System.out.println(); // Salto de línea
    }
    public static void  main(String[] args)
    {
        ExecutorService ejecutor = Executors.newFixedThreadPool(4);
        TADListaSegura b= new TADListaSegura();
        for(int i=0;i<4;i++)
        {
        ejecutor.execute(new usaTADListaSegura(b));
        }
        ejecutor.shutdown();
        try{
        ejecutor.awaitTermination(1, TimeUnit.HOURS);
        } catch(InterruptedException e){}
        System.out.println("\n--- RESULTADO FINAL ---");
        System.out.print("Estado de la lista: ");
        b.imprimir_lista();
        System.out.println("\nTamaño esperado: 12 (4 hilos x 3 inserciones)");
        System.out.println("Tamaño real de la lista: " + b.tam());
    }
}
