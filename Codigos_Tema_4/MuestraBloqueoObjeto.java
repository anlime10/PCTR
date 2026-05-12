
public class MuestraBloqueoObjeto {

   public synchronized void metodoA(){
   	for(int i=1;i<100;i++){
           System.out.println("Iteracion "+i+" del metodo A ");
   	}
   	System.out.println("metodo A liberando cerrojo...");
   }

   public synchronized void metodoB(){
   	for(int i=1;i<100;i++){
          System.out.println("Iteracion "+i+" del metodo B ");
   	}
   	System.out.println("metodo B liberando cerrojo...");
   }

}
