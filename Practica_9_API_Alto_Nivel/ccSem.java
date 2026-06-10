import java.util.concurrent.Semaphore;


public class ccSem implements Runnable{
    Cuenta_Banca C;
    static Semaphore S= new Semaphore(1);
    ccSem(Cuenta_Banca c)
    {
        this.C=c;
    }
    public static void main (String[] args)
    {
        Cuenta_Banca cuen= new Cuenta_Banca(100,200);
        ccSem recurso=new ccSem(cuen);
        Thread h= new Thread(recurso);
        Thread h2= new Thread(recurso);
        h.start();h2.start();
        try{h.join();}catch (InterruptedException e){}
        try{h2.join();}catch (InterruptedException e){}
    }
    public void run()
    {
        for (int i=0;i<5;i++)
        {
            try{S.acquire();}catch (InterruptedException e){}
            C.Deposito(20);
            S.release();
            try{S.acquire();}catch (InterruptedException e){}
            C.Reintegro(10);
            S.release();
        }
    }
}
