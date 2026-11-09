/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PCGaMeR
 */
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

    public Real getReal() { return real; }
    public Bitcoin getBitcoin() { return bitcoin; }
    public Ethereum getEthereum() { return ethereum; }
    public Ripple getRipple() { return ripple; }
}