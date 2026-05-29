public class cuentaCorriente {
    
    // Atributos encapsulados (privados) para proteger el estado del objeto
    private String numeroCuenta;
    private double saldo;

    /**
     * Constructor para inicializar la cuenta corriente.
     * @param numeroCuenta Identificador de la cuenta.
     * @param saldoInicial Dinero inicial en la cuenta.
     */
    public cuentaCorriente(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        // Validación básica: no permitir abrir una cuenta con saldo negativo
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            System.out.println("Aviso: El saldo inicial no puede ser negativo. Se inicializará en 0.0");
            this.saldo = 0.0;
        }
    }

    /**
     * Método para ingresar dinero en la cuenta (depósito).
     * @param cantidad Cantidad a ingresar.
     */
    public boolean deposito(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            return true;
        } else {
            System.out.println("Error: La cantidad a depositar debe ser mayor que cero.");
            return false;
        }
    }

    /**
     * Método para retirar dinero de la cuenta (reintegro).
     * @param cantidad Cantidad a retirar.
     * @return true si la operación fue exitosa, false si no hay saldo o la cantidad es inválida.
     */
    public boolean reintegro(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad a retirar debe ser mayor que cero.");
            return false;
        } else if (this.saldo >= cantidad) {
            this.saldo -= cantidad;
            return true;
        } else {
            System.out.println("Error: Saldo insuficiente para realizar el reintegro.");
            return false;
        }
    }

    // Métodos observadores (Getters) para consultar el estado
    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
}
