public class Cuenta_Banca 
{
  private int Codigo_Cuenta;     
  private double Saldo_Cuenta; 

  public Cuenta_Banca (){} 
  public Cuenta_Banca (int id, double disponible)
  { Codigo_Cuenta=id;
    Saldo_Cuenta=disponible;
  }
  
  public double  Saldo()
  {return (Saldo_Cuenta);}

  public void Deposito (double Cantidad)
  {if (Saldo_Cuenta>0)
      Saldo_Cuenta=Saldo_Cuenta+Cantidad;
  }
  
  public boolean Reintegro (double Cantidad)
  {if((Cantidad <=0)||(Cantidad>Saldo_Cuenta))
    return (false);
   else {Saldo_Cuenta=Saldo_Cuenta-Cantidad;
         return (true);          
        }
  }
  
  public int Codigo () //
  {return (Codigo_Cuenta);}
}

