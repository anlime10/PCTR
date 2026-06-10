public class Productor_Consumidor {
    int recurso=0;
    public synchronized void productor()
    {
        while(recurso==5)
        {
            try{wait();} catch (InterruptedException e) {}
        }
        recurso++;
        System.out.println("Productor produjo 1 elemento. Total en buffer: " + recurso);
        notifyAll();
    }
    public synchronized void consumidor()
    {
        while (recurso==0 ) {
            try{wait();} catch (InterruptedException e) {}
        }
        recurso--;
        notifyAll();
    }
}
