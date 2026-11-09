package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Investidor;

public class InvestidorDAO {
    
    // Variável de conexão que o erro disse que estava faltando
    private Connection conn;

    public InvestidorDAO() {
        this.conn = new Conexao().getConexao();
    }

    // Método que o Login usa (estava faltando)
    public Investidor autenticar(String cpf, String senha) {
        String sql = "SELECT * FROM investidor WHERE cpf = ? AND senha = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Investidor investidor = new Investidor(
                    rs.getString("nome"), 
                    rs.getString("cpf"), 
                    rs.getString("senha")
                );
                investidor.getCarteira().getReal().setSaldo(rs.getDouble("saldo_real"));
                investidor.getCarteira().getBitcoin().setSaldo(rs.getDouble("saldo_btc"));
                investidor.getCarteira().getEthereum().setSaldo(rs.getDouble("saldo_eth"));
                investidor.getCarteira().getRipple().setSaldo(rs.getDouble("saldo_xrp"));
                return investidor;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
        }
        return null;
    }

    // Método que o Menu usa para salvar compras/vendas (estava faltando)
    public void atualizarSaldos(Investidor investidor) {
        String sql = "UPDATE investidor SET saldo_real = ?, saldo_btc = ?, saldo_eth = ?, saldo_xrp = ? WHERE cpf = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, investidor.getCarteira().getReal().getSaldo());
            stmt.setDouble(2, investidor.getCarteira().getBitcoin().getSaldo());
            stmt.setDouble(3, investidor.getCarteira().getEthereum().getSaldo());
            stmt.setDouble(4, investidor.getCarteira().getRipple().getSaldo());
            stmt.setString(5, investidor.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar saldos: " + e.getMessage());
        }
    }

    // Método do extrato que você adicionou por último
    public String consultarExtrato(String cpf) {
        String historico = "";
        try {
            String sql = "SELECT * FROM extrato WHERE cpf_investidor = ? ORDER BY data_operacao DESC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                historico += rs.getString("data_operacao") + " | " 
                          + rs.getString("tipo_operacao") + " " 
                          + rs.getDouble("valor") + " " 
                          + rs.getString("moeda") + " | Taxa: " 
                          + rs.getDouble("taxa") + "\n";
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar extrato: " + e.getMessage());
        }

        if (historico.isEmpty()) {
            return "Nenhuma operação registada no extrato ainda.";
        }
        return historico;
    }
}