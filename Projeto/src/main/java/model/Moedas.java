package model;

public abstract class Moedas {
    protected double saldo;

    protected Moedas() {
        this.saldo = 0.0;
    }

    public double getSaldo() { return saldo; }

    public void setSaldo(double saldo) {
        if (!Double.isFinite(saldo) || saldo < 0) {
            throw new IllegalArgumentException("O saldo não pode ser negativo ou inválido.");
        }
        this.saldo = saldo;
    }
}
