/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.projeto;

/**
 *
 * @author PCGaMeR
 */
import view.Login;

public class Projeto {

    public static void main(String[] args) {
// Chama a tela de Login para aparecer quando o projeto iniciar
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
