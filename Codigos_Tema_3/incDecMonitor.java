public class incDecMonitor
{
    private int n=0;
    public incDecMonitor() {}
    public synchronized void inc()
    {n++;}
    public synchronized void dec()
    {n--;}
    public synchronized int ver()
    {return(n);}


}