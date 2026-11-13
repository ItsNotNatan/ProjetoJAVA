package model;

import java.time.LocalDateTime;

public class Operacao {
    private final LocalDateTime dataHora;
    private final String tipo;
    private final double valor;
    private final String moeda;
    private final double cotacao;
    private final double taxa;

    public Operacao(LocalDateTime dataHora, String tipo, double valor,
                    String moeda, double cotacao, double taxa) {
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.valor = valor;
        this.moeda = moeda;
        this.cotacao = cotacao;
        this.taxa = taxa;
    }

    public LocalDateTime getDataHora() { return dataHora; }
    public String getTipo() { return tipo; }
    public double getValor() { return valor; }
    public String getMoeda() { return moeda; }
    public double getCotacao() { return cotacao; }
    public double getTaxa() { return taxa; }
}
