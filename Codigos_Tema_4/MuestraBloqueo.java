
public class MuestraBloqueo implements Runnable{
    private Object o;
    private static int i = 0;

    public MuestraBloqueo(Object p){o = p;}

    public void run(){
    	synchronized(o){
    	  for(int i=1; i<1000000; i++){
    	    i++;
    	  }
    	}
    }

    public static void main(String[] args) throws Exception{
    	Object lock = new Object();
        Thread h1 = new Thread(new MuestraBloqueo(lock));
        Thread h2 = new Thread(new MuestraBloqueo(lock));
        h1.setPriority(Thread.MIN_PRIORITY);
        h2.setPriority(Thread.MAX_PRIORITY);
        h1.start(); h2.start();
        h2.join();  h2.join();
        System.out.println(i);
    }
}
