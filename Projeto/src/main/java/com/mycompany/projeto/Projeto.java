package com.mycompany.projeto;

import view.Login;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/** Ponto de entrada da aplicação Exchange de Criptomoedas. */
public class Projeto {

    private Projeto() {
        // Evita a instanciação da classe principal.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                // O tema padrão do Swing será usado se o tema do sistema falhar.
            }
            new Login().setVisible(true);
        });
    }
}
