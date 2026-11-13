package view;

import controller.MenuController;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.Carteira;
import model.Investidor;
import model.Operacao;

public class Menu extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    private final Investidor investidorLogado;
    private final MenuController controller;
    private static final Locale LOCALE_BR = Locale.forLanguageTag("pt-BR");
    private static final DateTimeFormatter FORMATO_DATA =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public Menu(Investidor investidor) throws SQLException {
        initComponents();

        this.investidorLogado = investidor;
        this.controller = new MenuController(investidor);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setTitle("Exchange - Carteira de " + investidor.getNome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jPanel2 = new javax.swing.JPanel();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        jToggleButton8.setText("Sair");
        jToggleButton8.addActionListener(this::jToggleButton8ActionPerformed);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("SALDO: R$");

        jLabel3.setText("Bitcoin:");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_Ripple))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_saldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_saldo)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbl_saldo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bt_saldo)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_Bitcoin)
                    .addComponent(jLabel1)
                    .addComponent(lbl_Ethereum)
                    .addComponent(jLabel4)
                    .addComponent(lbl_Ripple))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jToggleButton7.setText("Sacar");
        jToggleButton7.addActionListener(this::jToggleButton7ActionPerformed);

        jToggleButton3.setText("Depositar");
        jToggleButton3.addActionListener(this::jToggleButton3ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton7))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jToggleButton7)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton3)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jToggleButton5.setText("Vender Cripto");
        jToggleButton5.addActionListener(this::jToggleButton5ActionPerformed);

        jToggleButton4.setText("Comprar Cripto");
        jToggleButton4.addActionListener(this::jToggleButton4ActionPerformed);

        jToggleButton6.setText("Atualizar");
        jToggleButton6.addActionListener(this::jToggleButton6ActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton5)
                    .addComponent(jToggleButton4)
                    .addComponent(jToggleButton6))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton6)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jToggleButton2.setText("Consulta Extrato");
        jToggleButton2.addActionListener(this::jToggleButton2ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton8))
                .addContainerGap(160, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_saldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saldoActionPerformed
        String senha = solicitarSenha("Digite sua senha de 6 dígitos para consultar o saldo:");

        if (senha == null) {
            return;
        }

        try {
            Carteira carteira = controller.consultarSaldo(senha);
            atualizarLabels(carteira);
        } catch (IllegalArgumentException ex) {
            mostrarErro(ex.getMessage());
        }
    }//GEN-LAST:event_bt_saldoActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        Double valor = solicitarValor("Digite o valor em reais para depositar:");

        if (valor == null) {
            return;
        }

        try {
            controller.depositar(valor);
        } catch (IllegalArgumentException ex) {
            mostrarErro(ex.getMessage());
        } catch (SQLException ex) {
            mostrarErroBanco(ex);
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
        Double valor = solicitarValor("Digite o valor em reais para sacar:");

        if (valor == null) {
            return;
        }

        try {
            controller.sacar(valor);
        } catch (IllegalArgumentException ex) {
            mostrarErro(ex.getMessage());
        } catch (SQLException ex) {
            mostrarErroBanco(ex);
        }
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        String senha = solicitarSenha("Digite sua senha de 6 dígitos para comprar:");

        if (senha == null) {
            return;
        }

        try {
            controller.consultarSaldo(senha);
            mostrarCotacoes(controller.getCotacoes(), "Cotações disponíveis para compra");

            String moeda = selecionarMoeda("Qual criptomoeda deseja comprar?");

            if (moeda == null) {
                return;
            }

            Double valor = solicitarValor("Digite o valor TOTAL em reais que deseja usar (a taxa será descontada desse valor):");

            if (valor == null) {
                return;
            }

            Operacao operacao = controller.comprar(moeda, valor, senha);

            String mensagem = String.format(LOCALE_BR,
                    "Compra realizada!\n\nQuantidade adquirida: %.8f %s\nCotação: R$ %.2f\nTaxa cobrada: R$ %.2f\nValor total debitado: R$ %.2f",
                    operacao.getValor(), sigla(operacao.getMoeda()),
                    operacao.getCotacao(), operacao.getTaxa(), valor);

            JOptionPane.showMessageDialog(this, mensagem, "Compra concluída",
                    JOptionPane.INFORMATION_MESSAGE);

            atualizarLabels(investidorLogado.getCarteira());

        } catch (IllegalArgumentException ex) {
            mostrarErro(ex.getMessage());
        } catch (SQLException ex) {
            mostrarErroBanco(ex);
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        String senha = solicitarSenha("Digite sua senha de 6 dígitos para vender:");

        if (senha == null) {
            return;
        }

        try {
            controller.consultarSaldo(senha);
            mostrarCotacoes(controller.getCotacoes(), "Cotações disponíveis para venda");

            String moeda = selecionarMoeda("Qual criptomoeda deseja vender?");

            if (moeda == null) {
                return;
            }

            Double quantidade = solicitarValor("Digite a QUANTIDADE de criptomoedas que deseja vender:");

            if (quantidade == null) {
                return;
            }

            Operacao operacao = controller.vender(moeda, quantidade, senha);

            double bruto = operacao.getValor() * operacao.getCotacao();
            double liquido = bruto - operacao.getTaxa();

            String mensagem = String.format(LOCALE_BR,
                    "Venda realizada!\n\nQuantidade vendida: %.8f %s\nValor bruto: R$ %.2f\nTaxa cobrada: R$ %.2f\nVocê recebeu: R$ %.2f",
                    operacao.getValor(), sigla(operacao.getMoeda()),
                    bruto, operacao.getTaxa(), liquido);

            JOptionPane.showMessageDialog(this, mensagem, "Venda concluída",
                    JOptionPane.INFORMATION_MESSAGE);

            atualizarLabels(investidorLogado.getCarteira());

        } catch (IllegalArgumentException ex) {
            mostrarErro(ex.getMessage());
        } catch (SQLException ex) {
            mostrarErroBanco(ex);
        }
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        try {
            Map<String, Double> novas = controller.atualizarCotacoes();
            mostrarCotacoes(novas, "Cotações atualizadas (variação máxima de ±5%)");
        } catch (SQLException ex) {
            mostrarErroBanco(ex);
        }
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        String senha = solicitarSenha("Digite sua senha de 6 dígitos para consultar o extrato:");

        if (senha == null) {
            return;
        }

        try {
            List<Operacao> operacoes = controller.consultarExtrato(senha);

            StringBuilder texto = new StringBuilder();
            texto.append("Nome: ").append(investidorLogado.getNome()).append('\n');
            texto.append("CPF: ").append(investidorLogado.getCpf()).append("\n\n");

            if (operacoes.isEmpty()) {
                texto.append("Nenhuma operação registrada.");
            } else {
                for (Operacao op : operacoes) {
                    texto.append(formatarOperacao(op)).append('\n');
                }
            }

            JTextArea area = new JTextArea(texto.toString(), 20, 72);
            area.setEditable(false);
            area.setCaretPosition(0);
            area.setFont(new java.awt.Font(java.awt.Font.MONOSPACED,
                    java.awt.Font.PLAIN, 12));

            JOptionPane.showMessageDialog(this, new JScrollPane(area),
                    "Extrato de operações", JOptionPane.INFORMATION_MESSAGE);

        } catch (IllegalArgumentException ex) {
            mostrarErro(ex.getMessage());
        } catch (SQLException ex) {
            mostrarErroBanco(ex);
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton8ActionPerformed
        dispose();
    }//GEN-LAST:event_jToggleButton8ActionPerformed

    private String solicitarSenha(String mensagem) {
        javax.swing.JPasswordField campo = new javax.swing.JPasswordField();

        int opcao = JOptionPane.showConfirmDialog(this, campo, mensagem,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        return opcao == JOptionPane.OK_OPTION
                ? new String(campo.getPassword()) : null;
    }

    private Double solicitarValor(String mensagem) {
        String texto = JOptionPane.showInputDialog(this, mensagem);

        if (texto == null) {
            return null;
        }

        try {
            texto = texto.replace(",", ".");
            double valor = Double.parseDouble(texto);

            if (valor <= 0 || Double.isNaN(valor) || Double.isInfinite(valor)) {
                mostrarErro("Digite um valor maior que zero.");
                return null;
            }

            return valor;

        } catch (NumberFormatException ex) {
            mostrarErro("Valor inválido.");
            return null;
        }
    }

    private String selecionarMoeda(String mensagem) {
        String[] opcoes = {"Bitcoin", "Ethereum", "Ripple"};

        int escolha = JOptionPane.showOptionDialog(
                this,
                mensagem,
                "Selecionar criptomoeda",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if (escolha == 0) {
            return "BITCOIN";
        } else if (escolha == 1) {
            return "ETHEREUM";
        } else if (escolha == 2) {
            return "RIPPLE";
        }

        return null;
    }

    private void atualizarLabels(Carteira carteira) {
        lbl_saldo.setText(String.format(LOCALE_BR, "%.2f",
                carteira.getReal().getSaldo()));

        lbl_Bitcoin.setText(String.format(LOCALE_BR, "%.8f",
                carteira.getBitcoin().getSaldo()));

        lbl_Ethereum.setText(String.format(LOCALE_BR, "%.8f",
                carteira.getEthereum().getSaldo()));

        lbl_Ripple.setText(String.format(LOCALE_BR, "%.8f",
                carteira.getRipple().getSaldo()));
    }

    private void mostrarCotacoes(Map<String, Double> cotacoes, String titulo) {
        String mensagem = String.format(LOCALE_BR,
                "Bitcoin: R$ %.2f\nEthereum: R$ %.2f\nRipple: R$ %.2f",
                cotacoes.get("BITCOIN"),
                cotacoes.get("ETHEREUM"),
                cotacoes.get("RIPPLE"));

        JOptionPane.showMessageDialog(this, mensagem, titulo,
                JOptionPane.INFORMATION_MESSAGE);
    }

    private String formatarOperacao(Operacao op) {
        String data = op.getDataHora().format(FORMATO_DATA);

        if (op.getMoeda().equals("REAL")) {
            return String.format(LOCALE_BR, "%s | %s | R$ %.2f",
                    data, op.getTipo(), op.getValor());
        }

        return String.format(LOCALE_BR,
                "%s | %s | %.8f %s | Cotação R$ %.2f | Taxa R$ %.2f",
                data, op.getTipo(), op.getValor(), sigla(op.getMoeda()),
                op.getCotacao(), op.getTaxa());
    }

    private String sigla(String moeda) {
        if (moeda.equals("BITCOIN")) {
            return "BTC";
        } else if (moeda.equals("ETHEREUM")) {
            return "ETH";
        } else if (moeda.equals("RIPPLE")) {
            return "XRP";
        }

        return moeda;
    }

    private void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Atenção",
                JOptionPane.WARNING_MESSAGE);
    }

    private void mostrarErroBanco(SQLException ex) {
        JOptionPane.showMessageDialog(this,
                "Não foi possível salvar ou consultar os dados. Verifique se executou sql/banco.sql e se o PostgreSQL está ativo.\n\nDetalhes: "
                + ex.getMessage(),
                "Erro no banco de dados", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bt_saldo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    // End of variables declaration//GEN-END:variables
}