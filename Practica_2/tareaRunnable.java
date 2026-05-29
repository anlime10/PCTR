public class tareaRunnable implements Runnable{
    int iteraciones;
    boolean incrementa;
    Objeto_compartido o;
    public tareaRunnable (int i,boolean in,Objeto_compartido ob)
    {
        this.iteraciones=i;
        this.incrementa=in;
        this.o=ob;
    }
    public void run()
    {
        for (int i=0; i < iteraciones; i++)
        {
        if(incrementa)
        {
            o.incrementar();
        }
        else
        {
            o.decrementar();
        }
    }
    }
}
