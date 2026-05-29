public class hebra extends Thread {
    static int n=0;
    private int iteraciones;
    private boolean incrementar;
    public hebra(int iteraciones, boolean incrementar)
    {
        this.iteraciones=iteraciones;
        this.incrementar=incrementar;
    }
    public void run() {
        for (int i=0 ; i<iteraciones;i++)
        {
            if (incrementar)
            {
                n++;
            }
            else
            {
                n--;
            }
        }
    }
}
