class ObCritico{
 private int Dato;

 public ObCritico(int VInicial) 
  {Dato = VInicial;}

 public synchronized void Incremento() //a ejecutar bajo e.m.
  {Dato++;}

 public synchronized int Valor() //a ejecutar en e.m.
  {return (Dato);}
}

public class ExMutua extends Thread{
 private ObCritico SC;

 public ExMutua(ObCritico SecCritica){SC = SecCritica; }

 public void run() {
  for (int i=0; i<10000; i++) 
   SC.Incremento();
 }

 public static void main(String[] args) throws Exception {
  if (args.length != 2){
   System.err.println("Sintaxis: java ExMutua n m");
   System.exit(1);
  }

  int NumHilos = Integer.valueOf(args[0]).intValue(); //fija numero de hebras
  ObCritico c  = new ObCritico(Integer.valueOf(args[1]).intValue()); //fija valor inicial de Dato
  ExMutua[] Hilos = new ExMutua[NumHilos];
  for (int i = 0; i <= NumHilos - 1; i++) 
   Hilos[i] = new ExMutua(c);
  for (int i = 0; i <= NumHilos - 1; i++) Hilos[i].start();
  for (int i = 0; i <= NumHilos - 1; i++) Hilos[i].join();
  System.out.println(c.Valor());
 }
}