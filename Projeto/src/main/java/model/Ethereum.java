/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PCGaMeR
 */
public class Ethereum extends Moedas implements Tarifacao {
    
    public Ethereum() {
        super();
    }

    @Override
    public double calcularTaxaCompra(double valor) {
        return valor * 0.01;
    }

    @Override
    public double calcularTaxaVenda(double valor) {
        return valor * 0.02;
    }
}