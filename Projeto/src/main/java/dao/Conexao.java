package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL_PADRAO = "jdbc:postgresql://localhost:5432/moeda";
    private static final String USUARIO_PADRAO = "postgres";
    private static final String SENHA_PADRAO = "admin";


    public Connection getConexao() throws SQLException {
        String url = obterConfiguracao("exchange.db.url", "EXCHANGE_DB_URL", URL_PADRAO);
        String usuario = obterConfiguracao("exchange.db.user", "EXCHANGE_DB_USER", USUARIO_PADRAO);
        String senha = obterConfiguracao("exchange.db.password", "EXCHANGE_DB_PASSWORD", SENHA_PADRAO);
        return DriverManager.getConnection(url, usuario, senha);
    }

    private String obterConfiguracao(String propriedade, String variavel, String padrao) {
        String valor = System.getProperty(propriedade);
        if (valor == null || valor.isBlank()) {
            valor = System.getenv(variavel);
        }
        return (valor == null || valor.isBlank()) ? padrao : valor;
    }
}
