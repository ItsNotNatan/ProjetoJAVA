/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author PCGaMeR
 */

import dao.InvestidorDAO;
import model.Investidor;
import view.Menu;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class LoginController {

    // Guarda a tela que chamou o controller para poder fechá-la depois
    private JFrame view;

    public LoginController(JFrame view) {
        this.view = view;
    }

    // Toda a lógica que antes estava no botão, agora fica aqui no Controller
    public void fazerLogin(String cpf, String senha) {
        try {
            InvestidorDAO dao = new InvestidorDAO();
            Investidor investidor = dao.autenticar(cpf, senha);

            if (investidor != null) {
                JOptionPane.showMessageDialog(view, "Login efetuado com sucesso! Bem-vindo, " + investidor.getNome());
                
                // Abre o Menu e fecha o Login
                Menu menu = new Menu(investidor);
                menu.setVisible(true);
                view.dispose();
                
            } else {
                JOptionPane.showMessageDialog(view, "CPF ou Senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro ao tentar fazer login: " + e.getMessage());
        }
    }
}
