import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class lecEscAN {
    //Un lector siempre puede acceder a un recurso que no haya un escritor escrbiendo en el,
    //Los escritores deben esperar a que no haya ni otro escritor ni lectores accediendo al recurso,
    //MONITOR:
    ReentrantLock L= new ReentrantLock();
    Condition leyendo= L.newCondition();
    Condition escribiendo= L.newCondition();
    boolean escribiendoo;
    int le;
    public void leer()
    {
        L.lock();{
            try{
                while (escribiendoo) {
                 try{leyendo.await();} catch(InterruptedException e){}   
                }
                le++;
            System.out.println("Leyendo");
            le--;
            if (le==0)
            escribiendo.signal();
            }finally{L.unlock();}
        }
    }
    public void escribir()
    {
        L.lock();
        try{
        while (escribiendoo || le>0) {
            try{escribiendo.await();} catch(InterruptedException e){}   
        }
        escribiendoo=true;
        System.out.println("Escribiendo");
        escribiendoo=false;
        escribiendo.signalAll();
        leyendo.signalAll();
    }finally{L.unlock();}
    
    }
}
