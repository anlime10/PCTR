import java.util.concurrent.*;

public class ProConColaBloqueante {

    public static void main(String[] args)
    {
       int ranuras = 1;
       LinkedBlockingQueue<Integer> colaBloqueante = new LinkedBlockingQueue<Integer>(ranuras);
       new Productor(colaBloqueante);
       new Consumidor(colaBloqueante);
    }
}
