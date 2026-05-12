public class codBloqueo{
    private int numVueltas;
    public codBloqueo(int vueltas){numVueltas = vueltas;}

    public void metodo(){
         //seccion no critica
    	 synchronized(this){
         //seccion critica, ejecutando en exclusion mutua
    	   for(int i=1; i<=numVueltas; i++) System.out.print(i+" ");
    	}
    }
}