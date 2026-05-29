import java.util.Random;

public class escalaVPar extends Thread {
    static int[] v=new int[1000000];
    int rango_i;
    int rango_f;
    int k=2; //escaar
    public escalaVPar(int[] vec,int rango_ini ,int rango_fin)
    {
        System.arraycopy(v,0,v,0,1000000);
        this.rango_i=rango_ini;
        this.rango_f=rango_fin;
    }
    public void run()
    {
        for (int i=rango_i;i < rango_f;i++)
        {
            v[i]=k*v[i];
        }
    }

    public static void main(String[] args) {
        Random aleatorio= new Random();
        for (int i = 0; i < 1000000; i++) {
            v[i]=aleatorio.nextInt(1000);
        }
        Thread h1=new Thread(new escalaVPar(v,0,250000));
        Thread h2=new Thread(new escalaVPar(v,250000,500000));
        Thread h3=new Thread(new escalaVPar(v,500000,750000));
        Thread h4=new Thread(new escalaVPar(v,750000,1000000));
        h1.start();h2.start();h3.start();h4.start();
        try{
            h1.join();h2.join();h3.join();h4.join();
        } catch (InterruptedException e){}

    }
}
