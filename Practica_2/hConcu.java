package Practica_2;

public class hConcu 
    extends Thread
{
    private Critica c;
    public hConcu(Critica C)
    {this.c=C;}

    public void run()
    {
        for(int i=0;i<10000;i++)c.inc();
    }
    public static void main(String[] args)
    throws Exception
    {
        Critica p=new Critica();
        hConcu h1=new hConcu(p);
        hConcu h2=new hConcu(p);
        h1.start(); h2.start();
        h1.join();h1.join();
    }
}
