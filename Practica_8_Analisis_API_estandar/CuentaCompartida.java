package PCTR.Practica_8_Analisis_API_estandar;

public class CuentaCompartida {
    int Cuenta;
    boolean ingresando, reintegrando;
    public synchronized void ingreso(int cuantia)
    {
        Cuenta=Cuenta+cuantia;
        notifyAll();
    }
    public synchronized void reintegro(int cuantia)
    {
        while (Cuenta-cuantia<0)
        {
            try{wait();}catch (InterruptedException e){}
        }
        Cuenta=Cuenta-cuantia;
        notifyAll();
    }
}
