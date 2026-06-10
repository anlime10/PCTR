public class monitorLE {
    //Un lector siempre puede acceder a un recurso que no haya un escritor escrbiendo en el,
    //Los escritores deben esperar a que no haya ni otro escritor ni lectores accediendo al recurso,
    //MONITOR:
    boolean escribiendo;
    int lectores;
    recursoParaLE recurso;
    monitorLE()
    {
        this.escribiendo=false;
        this.lectores=0;
        this.recurso=0;
    }
    public synchronized void iniciarleer()
    {
        while (escribiendo)
        {
            try{
            wait();
            } catch (InterruptedException e){}
        }
        lectores+=1;
        recurso.leer();
    }
    public synchronized void terminarleer()
    {
        lectores-=1;
        if(lectores==0)
        notifyAll();
    }
    public synchronized void escribir()
    {
        while (escribiendo || lectores>0) {
            wait();
        }
        escribiendo=true;
        recurso.escribir();
        escribiendo=false;
        notifyAll();
    }
}
