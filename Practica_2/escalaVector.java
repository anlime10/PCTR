import java.util.Random;
public class escalaVector {
    public static void main(String[] args) {
        int k=0; //escalar
        int[] v= new int[1000000];
        Random aleatorio= new Random();
        for (int i = 0; i < 1000000; i++) {
            v[i]=aleatorio.nextInt(1000);
        }
        for (int i=0; i < 1000000; i++)
        {
            v[i]=v[i]*k;
        }
    }
}
