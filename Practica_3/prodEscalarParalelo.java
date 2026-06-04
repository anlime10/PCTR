import java.util.Random;

public class prodEscalarParalelo extends Thread{
    public int id,ini,fin;
    static public double[] vector= new double[4];
    static public double[] v1= new double[1000000],v2 = new double[1000000];
    public prodEscalarParalelo(int idHebra,int inicio,int fina)
    {
        id=idHebra;
        ini=inicio;
        fin=fina;
    }
    public static void main (String args[])
    {
        Random r =new Random();
            for(int i=0; i<1000000;i++)
            {
                v1[i]=r.nextDouble();
                v2[i]=r.nextDouble();
            }
            Thread h1 = new prodEscalarParalelo(0,0,250000); 
            Thread h2= new prodEscalarParalelo(1,250000,500000);
            Thread h3 = new prodEscalarParalelo(2,500000,750000); 
            Thread h4= new prodEscalarParalelo(3,750000,1000000);
            long tiempo_inicial= System.nanoTime();
            h1.start();h2.start();h3.start();h4.start();
            try{
            h1.join();h2.join();h3.join();h4.join();
            }catch(InterruptedException e) {}
            double resultado_final=vector[0]+vector[1]+vector[2]+vector[3];
            long tiempo_final=System.nanoTime();
            double tiempo_en_milisegundos=(tiempo_final-tiempo_inicial)/1_000_000.0;
            System.out.println("El tiempo de ejecución ha sido " + tiempo_en_milisegundos);
    }

    public void run()
    {
        double mult=0;
        for(int i=ini; i<fin;i++)
        {
            mult=mult+(v1[i]*v2[i]);
        }
        vector[id]=mult;
    }
}
