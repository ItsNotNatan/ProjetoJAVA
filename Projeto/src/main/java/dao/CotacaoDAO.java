package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CotacaoDAO {

    public Map<String, Double> buscarTodas() throws SQLException {

        Map<String, Double> cotacoes = new HashMap<>();

        String sql = "SELECT * FROM cotacao";

        try (Connection conn = new Conexao().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                String moeda = resultado.getString("moeda");
                double valor = resultado.getDouble("valor");

                cotacoes.put(moeda.toUpperCase(), valor);
            }
        }

        if (cotacoes.get("BITCOIN") == null
                || cotacoes.get("ETHEREUM") == null
                || cotacoes.get("RIPPLE") == null) {

            throw new SQLException("Cotações não encontradas no banco.");
        }

        return cotacoes;
    }

    public void atualizarTodas(Map<String, Double> cotacoes) throws SQLException {

        String sql = "UPDATE cotacao SET valor = ?, "
                + "atualizada_em = CURRENT_TIMESTAMP WHERE moeda = ?";

        try (Connection conn = new Conexao().getConexao()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                String[] moedas = {"BITCOIN", "ETHEREUM", "RIPPLE"};

                for (int i = 0; i < moedas.length; i++) {

                    String moeda = moedas[i];
                    Double valor = cotacoes.get(moeda);

                    if (valor == null || valor <= 0
                            || !Double.isFinite(valor)) {
                        throw new SQLException("Cotação inválida.");
                    }

                    stmt.setDouble(1, valor);
                    stmt.setString(2, moeda);

                    if (stmt.executeUpdate() == 0) {
                        throw new SQLException("Moeda não encontrada.");
                    }
                }

                conn.commit();

            } catch (SQLException erro) {

                conn.rollback();
                throw erro;
            }
        }
    }
}