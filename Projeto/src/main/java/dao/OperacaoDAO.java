package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import model.Carteira;
import model.Investidor;
import model.Operacao;

public class OperacaoDAO {

    public void registrarOperacao(Investidor investidor, Carteira carteira,
            Operacao operacao) throws SQLException {

        String sql1 = "UPDATE usuario SET s_real = ?, s_btc = ?, s_eth = ?, s_xrp = ? WHERE cpf = ?";

        String sql2 = "INSERT INTO dados "
                + "(cpf_usuario, data_op, tipo_op, valor, moeda, cotacao, taxa, "
                + "saldo_real, saldo_btc, saldo_eth, saldo_xrp) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = new Conexao().getConexao()) {

            conn.setAutoCommit(false);

            try {

                PreparedStatement atualizar = conn.prepareStatement(sql1);

                atualizar.setDouble(1, carteira.getReal().getSaldo());
                atualizar.setDouble(2, carteira.getBitcoin().getSaldo());
                atualizar.setDouble(3, carteira.getEthereum().getSaldo());
                atualizar.setDouble(4, carteira.getRipple().getSaldo());
                atualizar.setString(5, investidor.getCpf());

                int resultado = atualizar.executeUpdate();

                if (resultado == 0) {
                    throw new SQLException("Investidor não encontrado.");
                }

                atualizar.close();

                PreparedStatement inserir = conn.prepareStatement(sql2);

                inserir.setString(1, investidor.getCpf());
                inserir.setString(2, operacao.getDataHora().format(
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                inserir.setString(3, operacao.getTipo());
                inserir.setDouble(4, operacao.getValor());
                inserir.setString(5, operacao.getMoeda());
                inserir.setDouble(6, operacao.getCotacao());
                inserir.setDouble(7, operacao.getTaxa());
                inserir.setDouble(8, carteira.getReal().getSaldo());
                inserir.setDouble(9, carteira.getBitcoin().getSaldo());
                inserir.setDouble(10, carteira.getEthereum().getSaldo());
                inserir.setDouble(11, carteira.getRipple().getSaldo());

                inserir.executeUpdate();

                inserir.close();

                conn.commit();

            } catch (SQLException erro) {

                conn.rollback();

                throw erro;
            }
        }
    }

    public List<Operacao> listarPorCpf(String cpf) throws SQLException {

        List<Operacao> lista = new ArrayList<>();

        String sql = "SELECT * FROM dados WHERE cpf_usuario = ? ORDER BY id DESC";

        try (Connection conn = new Conexao().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {

                String data = resultado.getString("data_op");
                LocalDateTime dataHora = interpretarData(data);

                Operacao operacao = new Operacao(
                        dataHora,
                        resultado.getString("tipo_op"),
                        resultado.getDouble("valor"),
                        resultado.getString("moeda"),
                        resultado.getDouble("cotacao"),
                        resultado.getDouble("taxa")
                );

                lista.add(operacao);
            }

            resultado.close();
        }

        return lista;
    }

    private LocalDateTime interpretarData(String data) {

        try {
            return LocalDateTime.parse(
                    data,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            );

        } catch (DateTimeParseException erro) {

            try {
                return LocalDateTime.parse(
                        data,
                        DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
                );

            } catch (DateTimeParseException erro2) {

                try {
                    return LocalDateTime.parse(data);

                } catch (DateTimeParseException erro3) {
                    return LocalDateTime.now();
                }
            }
        }
    }
}