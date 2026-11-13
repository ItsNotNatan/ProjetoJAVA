package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Investidor;

public class InvestidorDAO {

    public Investidor autenticar(String cpf, String senha) throws SQLException {

        String sql = "SELECT * FROM usuario WHERE cpf = ? AND senha = ?";

        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.setString(2, senha);

            try (ResultSet resultado = stmt.executeQuery()) {

                if (resultado.next()) {

                    Investidor investidor = new Investidor(
                            resultado.getString("nome"),
                            resultado.getString("cpf"),
                            resultado.getString("senha")
                    );

                    investidor.getCarteira().getReal().setSaldo(
                            resultado.getDouble("s_real"));

                    investidor.getCarteira().getBitcoin().setSaldo(
                            resultado.getDouble("s_btc"));

                    investidor.getCarteira().getEthereum().setSaldo(
                            resultado.getDouble("s_eth"));

                    investidor.getCarteira().getRipple().setSaldo(
                            resultado.getDouble("s_xrp"));

                    return investidor;
                }
            }
        }

        return null;
    }
}