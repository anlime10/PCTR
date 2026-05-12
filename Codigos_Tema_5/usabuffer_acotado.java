import java.util.*; 

public class usabuffer_acotado extends Thread {

    private int tipoTarea;
    private buffer_acotado m;

    public usabuffer_acotado(int tipoTarea, buffer_acotado m) {this.tipoTarea = tipoTarea; this.m = m;}

    public void run() {
        if(tipoTarea == 1) {
            int n;
            Random r = new Random();
            for(int i=1; i<=5; i++){
                n = r.nextInt(100);
                try{m.put(n);}catch(InterruptedException e){}
                System.out.println("Prod "+this.getName()+" : insertando " + n);
            }
        }else if(tipoTarea==2){
               int l=0;
               for(int j=1; j<=5; j++){
                 try{l = m.take();}catch(InterruptedException e){}
                 System.out.println("Con "+this.getName()+" : extrayendo " + l);
               }
             }
    }

    public static void main(String[] args) throws Exception {

        buffer_acotado mon  = new buffer_acotado();
        usabuffer_acotado A = new usabuffer_acotado(2, mon);
        usabuffer_acotado D = new usabuffer_acotado(1, mon);
        A.start(); 
        D.start();
        A.join();  
        D.join();
        
    }
}
