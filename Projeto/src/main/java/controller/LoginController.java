package controller;

import dao.InvestidorDAO;
import java.sql.SQLException;
import model.Investidor;

public class LoginController {

    private InvestidorDAO investidorDAO;

    public LoginController() {
        investidorDAO = new InvestidorDAO();
    }

    public Investidor fazerLogin(String cpf, String senha) throws SQLException {

        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("Digite o CPF.");
        }

        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Digite a senha.");
        }

        cpf = cpf.trim();
        senha = senha.trim();

        if (!cpf.matches("[0-9]{11}")) {
            throw new IllegalArgumentException("O CPF deve ter 11 números.");
        }

        if (!senha.matches("[0-9]{6}")) {
            throw new IllegalArgumentException("A senha deve ter 6 números.");
        }

        return investidorDAO.autenticar(cpf, senha);
    }
}