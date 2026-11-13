package model;


public class Carteira {
    private Real real;
    private Bitcoin bitcoin;
    private Ethereum ethereum;
    private Ripple ripple;

    public Carteira() {
        this.real = new Real();
        this.bitcoin = new Bitcoin();
        this.ethereum = new Ethereum();
        this.ripple = new Ripple();
    }

    public Carteira copiar() {
        Carteira copia = new Carteira();
        copia.getReal().setSaldo(real.getSaldo());
        copia.getBitcoin().setSaldo(bitcoin.getSaldo());
        copia.getEthereum().setSaldo(ethereum.getSaldo());
        copia.getRipple().setSaldo(ripple.getSaldo());
        return copia;
    }

    public Real getReal() { return real; }
    public Bitcoin getBitcoin() { return bitcoin; }
    public Ethereum getEthereum() { return ethereum; }
    public Ripple getRipple() { return ripple; }

    public void setReal(Real real) { this.real = real; }
    public void setBitcoin(Bitcoin bitcoin) { this.bitcoin = bitcoin; }
    public void setEthereum(Ethereum ethereum) { this.ethereum = ethereum; }
    public void setRipple(Ripple ripple) { this.ripple = ripple; }
}
