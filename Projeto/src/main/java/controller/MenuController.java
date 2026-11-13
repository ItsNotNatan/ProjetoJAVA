package controller;

import dao.CotacaoDAO;
import dao.OperacaoDAO;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import model.Carteira;
import model.Investidor;
import model.Operacao;
import model.Tarifacao;

public class MenuController {

    private Investidor investidor;
    private OperacaoDAO operacaoDAO;
    private CotacaoDAO cotacaoDAO;
    private Random random;
    private Map<String, Double> cotacoes;

    public MenuController(Investidor investidor) throws SQLException {

        if (investidor == null) {
            throw new IllegalArgumentException("Investidor não encontrado.");
        }

        this.investidor = investidor;
        operacaoDAO = new OperacaoDAO();
        cotacaoDAO = new CotacaoDAO();
        random = new Random();
        cotacoes = cotacaoDAO.buscarTodas();
    }

    public Carteira consultarSaldo(String senha) {
        validarSenha(senha);
        return investidor.getCarteira();
    }

    public List<Operacao> consultarExtrato(String senha) throws SQLException {
        validarSenha(senha);
        return operacaoDAO.listarPorCpf(investidor.getCpf());
    }

    public Operacao depositar(double valor) throws SQLException {

        if (valor <= 0 || Double.isNaN(valor) || Double.isInfinite(valor)) {
            throw new IllegalArgumentException("Digite um valor válido.");
        }

        valor = arredondarDinheiro(valor);

        Carteira nova = investidor.getCarteira().copiar();

        double saldo = nova.getReal().getSaldo();
        nova.getReal().setSaldo(arredondarDinheiro(saldo + valor));

        Operacao operacao = new Operacao(
                LocalDateTime.now(),
                "DEPOSITO",
                valor,
                "REAL",
                0,
                0
        );

        salvarOperacao(nova, operacao);

        return operacao;
    }

    public Operacao sacar(double valor) throws SQLException {

        if (valor <= 0 || Double.isNaN(valor) || Double.isInfinite(valor)) {
            throw new IllegalArgumentException("Digite um valor válido.");
        }

        valor = arredondarDinheiro(valor);

        Carteira nova = investidor.getCarteira().copiar();

        if (valor > nova.getReal().getSaldo()) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }

        nova.getReal().setSaldo(
                arredondarDinheiro(nova.getReal().getSaldo() - valor)
        );

        Operacao operacao = new Operacao(
                LocalDateTime.now(),
                "SAQUE",
                valor,
                "REAL",
                0,
                0
        );

        salvarOperacao(nova, operacao);

        return operacao;
    }

    public Operacao comprar(String moeda, double valor, String senha) throws SQLException {

        validarSenha(senha);

        if (valor <= 0 || Double.isNaN(valor) || Double.isInfinite(valor)) {
            throw new IllegalArgumentException("Digite um valor válido.");
        }

        valor = arredondarDinheiro(valor);

        String codigo = normalizarMoeda(moeda);
        double cotacao = cotacoes.get(codigo);

        Carteira nova = investidor.getCarteira().copiar();

        if (valor > nova.getReal().getSaldo()) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }

        Tarifacao moedaEscolhida = obterTarifacao(nova, codigo);

        double taxa = arredondarDinheiro(
                moedaEscolhida.calcularTaxaCompra(valor)
        );

        double valorFinal = valor - taxa;
        double quantidade = valorFinal / cotacao;

        quantidade = arredondarCripto(quantidade);

        if (quantidade <= 0) {
            throw new IllegalArgumentException("Valor muito baixo para realizar a compra.");
        }

        nova.getReal().setSaldo(
                arredondarDinheiro(nova.getReal().getSaldo() - valor)
        );

        alterarSaldo(nova, codigo, quantidade, true);

        Operacao operacao = new Operacao(
                LocalDateTime.now(),
                "COMPRA",
                quantidade,
                codigo,
                cotacao,
                taxa
        );

        salvarOperacao(nova, operacao);

        return operacao;
    }

    public Operacao vender(String moeda, double quantidade, String senha) throws SQLException {

        validarSenha(senha);

        if (quantidade <= 0 || Double.isNaN(quantidade) || Double.isInfinite(quantidade)) {
            throw new IllegalArgumentException("Digite uma quantidade válida.");
        }

        quantidade = arredondarCripto(quantidade);

        String codigo = normalizarMoeda(moeda);
        double cotacao = cotacoes.get(codigo);

        Carteira nova = investidor.getCarteira().copiar();

        if (quantidade > obterSaldo(nova, codigo)) {
            throw new IllegalArgumentException("Saldo de criptomoedas insuficiente.");
        }

        double valor = arredondarDinheiro(quantidade * cotacao);

        Tarifacao moedaEscolhida = obterTarifacao(nova, codigo);

        double taxa = arredondarDinheiro(
                moedaEscolhida.calcularTaxaVenda(valor)
        );

        double valorFinal = valor - taxa;

        alterarSaldo(nova, codigo, quantidade, false);

        nova.getReal().setSaldo(
                arredondarDinheiro(nova.getReal().getSaldo() + valorFinal)
        );

        Operacao operacao = new Operacao(
                LocalDateTime.now(),
                "VENDA",
                quantidade,
                codigo,
                cotacao,
                taxa
        );

        salvarOperacao(nova, operacao);

        return operacao;
    }

    public Map<String, Double> atualizarCotacoes() throws SQLException {

        Map<String, Double> novasCotacoes = new HashMap<>();

        String[] moedas = {"BITCOIN", "ETHEREUM", "RIPPLE"};

        for (int i = 0; i < moedas.length; i++) {

            String moeda = moedas[i];

            double valorAtual = cotacoes.get(moeda);
            double variacao = (random.nextDouble() * 0.10) - 0.05;

            double novoValor = valorAtual * (1 + variacao);

            novasCotacoes.put(moeda, novoValor);
        }

        cotacaoDAO.atualizarTodas(novasCotacoes);

        cotacoes = novasCotacoes;

        return new HashMap<>(cotacoes);
    }

    public Map<String, Double> getCotacoes() {
        return new HashMap<>(cotacoes);
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    private void salvarOperacao(Carteira nova, Operacao operacao) throws SQLException {

        operacaoDAO.registrarOperacao(investidor, nova, operacao);

        investidor.setCarteira(nova);
    }

    private void validarSenha(String senha) {

        if (senha == null || !senha.equals(investidor.getSenha())) {
            throw new IllegalArgumentException("Senha incorreta.");
        }
    }

    private String normalizarMoeda(String moeda) {

        if (moeda == null) {
            throw new IllegalArgumentException("Selecione uma moeda.");
        }

        String codigo = moeda.trim().toUpperCase();

        if (codigo.equals("BTC")) {
            codigo = "BITCOIN";
        } else if (codigo.equals("ETH")) {
            codigo = "ETHEREUM";
        } else if (codigo.equals("XRP")) {
            codigo = "RIPPLE";
        }

        if (!codigo.equals("BITCOIN")
                && !codigo.equals("ETHEREUM")
                && !codigo.equals("RIPPLE")) {
            throw new IllegalArgumentException("Moeda inválida.");
        }

        return codigo;
    }

    private Tarifacao obterTarifacao(Carteira carteira, String codigo) {

        if (codigo.equals("BITCOIN")) {
            return carteira.getBitcoin();
        } else if (codigo.equals("ETHEREUM")) {
            return carteira.getEthereum();
        } else {
            return carteira.getRipple();
        }
    }

    private double obterSaldo(Carteira carteira, String codigo) {

        if (codigo.equals("BITCOIN")) {
            return carteira.getBitcoin().getSaldo();
        } else if (codigo.equals("ETHEREUM")) {
            return carteira.getEthereum().getSaldo();
        } else {
            return carteira.getRipple().getSaldo();
        }
    }

    private void alterarSaldo(Carteira carteira, String codigo,
                              double quantidade, boolean compra) {

        if (codigo.equals("BITCOIN")) {

            double saldo = carteira.getBitcoin().getSaldo();

            if (compra) {
                carteira.getBitcoin().setSaldo(arredondarCripto(saldo + quantidade));
            } else {
                carteira.getBitcoin().setSaldo(arredondarCripto(saldo - quantidade));
            }

        } else if (codigo.equals("ETHEREUM")) {

            double saldo = carteira.getEthereum().getSaldo();

            if (compra) {
                carteira.getEthereum().setSaldo(arredondarCripto(saldo + quantidade));
            } else {
                carteira.getEthereum().setSaldo(arredondarCripto(saldo - quantidade));
            }

        } else {

            double saldo = carteira.getRipple().getSaldo();

            if (compra) {
                carteira.getRipple().setSaldo(arredondarCripto(saldo + quantidade));
            } else {
                carteira.getRipple().setSaldo(arredondarCripto(saldo - quantidade));
            }
        }
    }

    private double arredondarDinheiro(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }

    private double arredondarCripto(double valor) {
        return Math.round(valor * 100000000.0) / 100000000.0;
    }
}