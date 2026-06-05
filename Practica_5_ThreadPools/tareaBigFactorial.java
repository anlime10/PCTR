import java.math.BigInteger;
import java.util.concurrent.Callable;

public class tareaBigFactorial implements Callable<BigInteger> {
    BigInteger inicio,fin;
    public tareaBigFactorial(BigInteger ini,BigInteger fini)
    {
        inicio=ini;
        if (inicio.compareTo(BigInteger.valueOf(0))==0)
        {inicio= inicio.add(BigInteger.valueOf(1));}
        fin=fini;
    }

    public BigInteger call()
    {
        BigInteger resultado= new BigInteger("1");
        while (inicio.compareTo(fin)==-1) {
            resultado= resultado.multiply(inicio);
            inicio= inicio.add(BigInteger.valueOf(1));
        }
        return resultado;
    }
}
