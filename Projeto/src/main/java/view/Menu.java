package view;

import model.Investidor;

public class Menu extends javax.swing.JFrame {

    private double cotacaoBtc = 300000.00;
    private double cotacaoEth = 15000.00;
    private double cotacaoXrp = 3.00;

    private model.Investidor investidorLogado;

    public Menu(model.Investidor investidor) {
        initComponents(); 
        
        // Força a janela a ter 700 pixels de largura por 500 de altura
        this.setSize(700, 500);
        // Centraliza a janela no ecrã
        this.setLocationRelativeTo(null);
        
        this.investidorLogado = investidor;
        if (investidor != null) {
            this.setTitle("Carteira - " + investidor.getNome());
        }
    }

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_Bitcoin = new javax.swing.JLabel();
        lbl_saldo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_Ethereum = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_Ripple = new javax.swing.JLabel();
        bt_saldo = new javax.swing.JToggleButton();

        jToggleButton2.setText("Consulta Extrato");
        jToggleButton2.addActionListener(this::jToggleButton2ActionPerformed);

        jToggleButton3.setText("Depositar");
        jToggleButton3.addActionListener(this::jToggleButton3ActionPerformed);

        jToggleButton4.setText("Comprar Cripto");
        jToggleButton4.addActionListener(this::jToggleButton4ActionPerformed);

        jToggleButton5.setText("Vender Cripto");
        jToggleButton5.addActionListener(this::jToggleButton5ActionPerformed);

        jToggleButton6.setText("Atualizar");
        jToggleButton6.addActionListener(this::jToggleButton6ActionPerformed);

        jToggleButton7.setText("Sacar");
        jToggleButton7.addActionListener(this::jToggleButton7ActionPerformed);

        jToggleButton8.setText("Sair");
        jToggleButton8.addActionListener(this::jToggleButton8ActionPerformed);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("SALDO: R$");

        jLabel3.setText("BItcoin:");

        lbl_Bitcoin.setText("0.00");

        lbl_saldo.setText("0.00");

        jLabel1.setText("Ethereum: ");

        lbl_Ethereum.setText("0.00");

        jLabel4.setText("Ripple: ");

        lbl_Ripple.setText("0.00");

        bt_saldo.setText("Consulta Saldo");
        bt_saldo.addActionListener(this::bt_saldoActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Bitcoin)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Ethereum)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Ripple)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_saldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_saldo)
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_saldo)
                    .addComponent(bt_saldo))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_Bitcoin)
                    .addComponent(jLabel1)
                    .addComponent(lbl_Ethereum)
                    .addComponent(jLabel4)
                    .addComponent(lbl_Ripple))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton7)
                    .addComponent(jToggleButton3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jToggleButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToggleButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton6)))
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton8)
                            .addComponent(jToggleButton4))))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jToggleButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton4))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton5)
                    .addComponent(jToggleButton6)
                    .addComponent(jToggleButton8))
                .addGap(53, 53, 53))
        );
    }// </editor-fold>                          

    private void bt_saldoActionPerformed(java.awt.event.ActionEvent evt) {                                         
// Pede a senha
        String senhaDigitada = javax.swing.JOptionPane.showInputDialog(this, "Digite sua senha de 6 dígitos para revelar o saldo:");

        if (senhaDigitada != null && senhaDigitada.equals(investidorLogado.getSenha())) {
            
            // Atualiza a Label dos Reais
            double saldoReais = investidorLogado.getCarteira().getReal().getSaldo();
            lbl_saldo.setText(String.format("%.2f", saldoReais));
            
            // Atualiza as Labels individuais de cada criptomoeda
            double saldoBtc = investidorLogado.getCarteira().getBitcoin().getSaldo();
            lbl_Bitcoin.setText(String.format("%.4f", saldoBtc));
            
            double saldoEth = investidorLogado.getCarteira().getEthereum().getSaldo();
            lbl_Ethereum.setText(String.format("%.4f", saldoEth));
            
            double saldoXrp = investidorLogado.getCarteira().getRipple().getSaldo();
            lbl_Ripple.setText(String.format("%.4f", saldoXrp));

        } else if (senhaDigitada != null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Senha incorreta!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        try {
            // Pede o valor ao utilizador
            String valorStr = javax.swing.JOptionPane.showInputDialog(this, "Digite o valor em Reais para depositar:");

            if (valorStr != null && !valorStr.trim().isEmpty()) {
                // Converte o texto para número decimal (double)
                valorStr = valorStr.replace(",", "."); // Aceita vírgula ou ponto
                double valorDeposito = Double.parseDouble(valorStr);

                if (valorDeposito > 0) {
                    // Atualiza o saldo na memória (objeto)
                    double saldoAtual = investidorLogado.getCarteira().getReal().getSaldo();
                    investidorLogado.getCarteira().getReal().setSaldo(saldoAtual + valorDeposito);

                    // Guarda o novo saldo na base de dados
                    dao.InvestidorDAO dao = new dao.InvestidorDAO();
                    dao.atualizarSaldos(investidorLogado);

                    javax.swing.JOptionPane.showMessageDialog(this, "Depósito de R$ " + valorDeposito + " realizado com sucesso!");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "O valor deve ser maior que zero.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Valor inválido! Digite apenas números.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }                                              

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        try {
            String valorStr = javax.swing.JOptionPane.showInputDialog(this, "Digite o valor em Reais para sacar:");

            if (valorStr != null && !valorStr.trim().isEmpty()) {
                valorStr = valorStr.replace(",", ".");
                double valorSaque = Double.parseDouble(valorStr);

                double saldoAtual = investidorLogado.getCarteira().getReal().getSaldo();

                if (valorSaque > 0 && valorSaque <= saldoAtual) {
                    // Subtrai o valor do saldo
                    investidorLogado.getCarteira().getReal().setSaldo(saldoAtual - valorSaque);

                    // Atualiza na base de dados
                    dao.InvestidorDAO dao = new dao.InvestidorDAO();
                    dao.atualizarSaldos(investidorLogado);

                    javax.swing.JOptionPane.showMessageDialog(this, "Saque de R$ " + valorSaque + " realizado com sucesso!");
                } else if (valorSaque > saldoAtual) {
                    // Regra: saldo não pode ficar negativo
                    javax.swing.JOptionPane.showMessageDialog(this, "Saldo insuficiente para este saque!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "O valor deve ser maior que zero.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Valor inválido! Digite apenas números.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }                                              

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        java.util.Random gerador = new java.util.Random();

        // A matemática para gerar uma variação entre -0.05 (-5%) e +0.05 (+5%)
        double variacaoBtc = (gerador.nextDouble() * 0.10) - 0.05;
        double variacaoEth = (gerador.nextDouble() * 0.10) - 0.05;
        double variacaoXrp = (gerador.nextDouble() * 0.10) - 0.05;

        // Atualiza as cotações multiplicando pelo valor gerado
        cotacaoBtc = cotacaoBtc * (1 + variacaoBtc);
        cotacaoEth = cotacaoEth * (1 + variacaoEth);
        cotacaoXrp = cotacaoXrp * (1 + variacaoXrp);

        // Mostra os novos valores formatados
        String mensagem = String.format("Novas Cotações:\n\nBitcoin: R$ %.2f\nEthereum: R$ %.2f\nRipple: R$ %.2f", cotacaoBtc, cotacaoEth, cotacaoXrp);
        javax.swing.JOptionPane.showMessageDialog(this, mensagem, "Cotações Atualizadas", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }                                              

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // 1. Pede a senha
        String senha = javax.swing.JOptionPane.showInputDialog(this, "Digite sua senha de 6 dígitos para comprar:");

        if (senha != null && senha.equals(investidorLogado.getSenha())) {

            // 2. Escolhe a moeda (Simplificado para perguntar qual quer)
            String[] opcoes = {"Bitcoin", "Ethereum", "Ripple"};
            int escolha = javax.swing.JOptionPane.showOptionDialog(this,
                    "Qual criptomoeda deseja comprar?", "Comprar",
                    javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE,
                    null, opcoes, opcoes[0]);

            if (escolha >= 0) { // Se escolheu alguma
                String valorStr = javax.swing.JOptionPane.showInputDialog(this, "Digite o valor em REAIS que deseja investir:");

                if (valorStr != null && !valorStr.trim().isEmpty()) {
                    valorStr = valorStr.replace(",", ".");
                    double valorInvestimento = Double.parseDouble(valorStr);
                    double saldoReal = investidorLogado.getCarteira().getReal().getSaldo();

                    if (valorInvestimento > 0 && valorInvestimento <= saldoReal) {

                        double taxa = 0;
                        double valorComprado = 0;

                        // 3. Aplica regras dependendo da moeda escolhida
                        if (escolha == 0) { // Bitcoin
                            taxa = investidorLogado.getCarteira().getBitcoin().calcularTaxaCompra(valorInvestimento);
                            double valorLiquido = valorInvestimento - taxa;
                            valorComprado = valorLiquido / cotacaoBtc; // Converte Reais para BTC

                            double saldoMoeda = investidorLogado.getCarteira().getBitcoin().getSaldo();
                            investidorLogado.getCarteira().getBitcoin().setSaldo(saldoMoeda + valorComprado);

                        } else if (escolha == 1) { // Ethereum
                            taxa = investidorLogado.getCarteira().getEthereum().calcularTaxaCompra(valorInvestimento);
                            double valorLiquido = valorInvestimento - taxa;
                            valorComprado = valorLiquido / cotacaoEth;

                            double saldoMoeda = investidorLogado.getCarteira().getEthereum().getSaldo();
                            investidorLogado.getCarteira().getEthereum().setSaldo(saldoMoeda + valorComprado);

                        } else if (escolha == 2) { // Ripple
                            taxa = investidorLogado.getCarteira().getRipple().calcularTaxaCompra(valorInvestimento);
                            double valorLiquido = valorInvestimento - taxa;
                            valorComprado = valorLiquido / cotacaoXrp;

                            double saldoMoeda = investidorLogado.getCarteira().getRipple().getSaldo();
                            investidorLogado.getCarteira().getRipple().setSaldo(saldoMoeda + valorComprado);
                        }

                        // Desconta os reais da carteira
                        investidorLogado.getCarteira().getReal().setSaldo(saldoReal - valorInvestimento);

                        // Salva no banco de dados
                        dao.InvestidorDAO dao = new dao.InvestidorDAO();
                        dao.atualizarSaldos(investidorLogado);

                        String recibo = String.format("Compra realizada!\nTaxa cobrada: R$ %.2f\nVocê comprou: %f moedas", taxa, valorComprado);
                        javax.swing.JOptionPane.showMessageDialog(this, recibo);

                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "Saldo insuficiente!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else if (senha != null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Senha incorreta!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }                                              

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // 1. Pede a senha
        String senha = javax.swing.JOptionPane.showInputDialog(this, "Digite sua senha de 6 dígitos para vender:");

        if (senha != null && senha.equals(investidorLogado.getSenha())) {

            // 2. Escolhe a moeda
            String[] opcoes = {"Bitcoin", "Ethereum", "Ripple"};
            int escolha = javax.swing.JOptionPane.showOptionDialog(this,
                    "Qual criptomoeda deseja vender?", "Vender",
                    javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE,
                    null, opcoes, opcoes[0]);

            if (escolha >= 0) {
                // 3. Pergunta a quantidade de moedas (não em reais, mas a quantidade da moeda em si)
                String qtdStr = javax.swing.JOptionPane.showInputDialog(this, "Digite a QUANTIDADE de moedas que deseja vender:");

                if (qtdStr != null && !qtdStr.trim().isEmpty()) {
                    qtdStr = qtdStr.replace(",", ".");
                    double qtdVenda = Double.parseDouble(qtdStr);

                    if (qtdVenda > 0) {
                        double taxa = 0;
                        double valorReaisBruto = 0;
                        boolean sucesso = false; // Controla se ele tinha saldo suficiente

                        // 4. Aplica as regras da venda
                        if (escolha == 0) { // Bitcoin
                            double saldoMoeda = investidorLogado.getCarteira().getBitcoin().getSaldo();
                            if (qtdVenda <= saldoMoeda) { // Verifica se não fica negativo
                                valorReaisBruto = qtdVenda * cotacaoBtc;
                                taxa = investidorLogado.getCarteira().getBitcoin().calcularTaxaVenda(valorReaisBruto);
                                investidorLogado.getCarteira().getBitcoin().setSaldo(saldoMoeda - qtdVenda);
                                sucesso = true;
                            }
                        } else if (escolha == 1) { // Ethereum
                            double saldoMoeda = investidorLogado.getCarteira().getEthereum().getSaldo();
                            if (qtdVenda <= saldoMoeda) {
                                valorReaisBruto = qtdVenda * cotacaoEth;
                                taxa = investidorLogado.getCarteira().getEthereum().calcularTaxaVenda(valorReaisBruto);
                                investidorLogado.getCarteira().getEthereum().setSaldo(saldoMoeda - qtdVenda);
                                sucesso = true;
                            }
                        } else if (escolha == 2) { // Ripple
                            double saldoMoeda = investidorLogado.getCarteira().getRipple().getSaldo();
                            if (qtdVenda <= saldoMoeda) {
                                valorReaisBruto = qtdVenda * cotacaoXrp;
                                taxa = investidorLogado.getCarteira().getRipple().calcularTaxaVenda(valorReaisBruto);
                                investidorLogado.getCarteira().getRipple().setSaldo(saldoMoeda - qtdVenda);
                                sucesso = true;
                            }
                        }

                        // 5. Se a venda foi autorizada (tinha saldo)
                        if (sucesso) {
                            double valorLiquido = valorReaisBruto - taxa; // Tira a taxa do lucro

                            // Adiciona os reais na conta
                            double saldoReal = investidorLogado.getCarteira().getReal().getSaldo();
                            investidorLogado.getCarteira().getReal().setSaldo(saldoReal + valorLiquido);

                            // Salva no banco de dados
                            dao.InvestidorDAO dao = new dao.InvestidorDAO();
                            dao.atualizarSaldos(investidorLogado);

                            String recibo = String.format("Venda realizada!\nValor Bruto: R$ %.2f\nTaxa cobrada: R$ %.2f\nVocê recebeu: R$ %.2f", valorReaisBruto, taxa, valorLiquido);
                            javax.swing.JOptionPane.showMessageDialog(this, recibo);

                        } else {
                            javax.swing.JOptionPane.showMessageDialog(this, "Saldo de criptomoeda insuficiente!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        } else if (senha != null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Senha incorreta!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }                                              

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        System.exit(0);
    }                                              

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // Pede a senha
        String senha = javax.swing.JOptionPane.showInputDialog(this, "Digite sua senha de 6 dígitos para ver o extrato:");

        if (senha != null && senha.equals(investidorLogado.getSenha())) {

            // Vai ao banco de dados procurar o histórico
            dao.InvestidorDAO dao = new dao.InvestidorDAO();
            String historicoBD = dao.consultarExtrato(investidorLogado.getCpf());

            // Monta o cabeçalho igual ao PDF
            String cabecalho = "Nome: " + investidorLogado.getNome() + "\n"
                    + "CPF: " + investidorLogado.getCpf() + "\n"
                    + "--------------------------------------------------\n";

            // Mostra tudo na tela
            javax.swing.JOptionPane.showMessageDialog(this, cabecalho + historicoBD, "Extrato de Operações", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } else if (senha != null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Senha incorreta!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }                                              

    // Variables declaration - do not modify                     
    private javax.swing.JToggleButton bt_saldo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JLabel lbl_Bitcoin;
    private javax.swing.JLabel lbl_Ethereum;
    private javax.swing.JLabel lbl_Ripple;
    private javax.swing.JLabel lbl_saldo;
    // End of variables declaration                   
}