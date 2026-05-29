public class cajero implements Runnable{
    private cuentaCorriente cc;
    public int tipo;
    cajero(cuentaCorriente cC,int t)
    {
        cc=cC;
        tipo=t;
    }
    public void deposito(double cantidad) {cc.deposito(cantidad);}
    public void reintegro(double cantidad) {cc.reintegro(cantidad);}
    public double saldo() {return cc.getSaldo();}
    @Override
    public void run()
    {
        switch (tipo)
        {
            case(100):
            {
                for (int i=0; i<1000; i++)
                {
                deposito(100);
                }
                break;
            }
            case(-100):
            {
                for (int i=0;i<1000; i++)
                {
                reintegro(100);
                }
                break;
            }
        }

    }
}
