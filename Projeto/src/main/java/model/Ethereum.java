package model;

public class Ethereum extends Moedas implements Tarifacao {
    public Ethereum() { super(); }
    @Override public double calcularTaxaCompra(double valor) { return valor * 0.01; }
    @Override public double calcularTaxaVenda(double valor) { return valor * 0.02; }
}
