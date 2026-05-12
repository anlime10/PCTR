public class UsacodBloqueo extends Thread{
   codBloqueo compartido;

    public UsacodBloqueo(codBloqueo l) {compartido = l;}

    public void run(){
        //llamada a metodo que tiene codigo sincronizado
    	compartido.metodo(); 
    }


    public static void main(String[] args){
        codBloqueo aux = new codBloqueo(200);
        UsacodBloqueo h1 = new UsacodBloqueo(aux);
        UsacodBloqueo h2 = new UsacodBloqueo(aux);
        h2.start();
        h1.start();
    }
}
