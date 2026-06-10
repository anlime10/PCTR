public class monitorImpresoras {
    boolean[] impresora = {true, true, true};
    public synchronized int pedirImpresora()
    {
        while(true){
        if (impresora[0]) {
            impresora[0]=false;
            return 1;
        }
        else if (impresora[1]) {
            impresora[1]=false;
            return 2;
        }
        else if (impresora[2]) {
            impresora[2]=false;
            return 3;
        }
        else
        {
            while (!impresora[0] && !impresora[1] && !impresora[2]) {
                try{wait();}catch (InterruptedException e){}
            }
        }
    }
    }
    public synchronized void liberarImpresora(int n)
    {
        if (!impresora[n-1]) {
            impresora[n-1]=true;
            notifyAll();
        }
    }
}
