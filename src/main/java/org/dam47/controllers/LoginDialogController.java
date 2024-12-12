package org.dam47.controllers;

import org.dam47.views.LoginDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialogController implements ActionListener {

    private final LoginDialog loginDialog;
    private static final String ABRIR_LOGIN = "ABRIR_LOGIN";

    public LoginDialogController(LoginDialog loginDialog) {
        this.loginDialog = loginDialog;
    }

    public void handleAbrirLogin(){
        loginDialog.showWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case ABRIR_LOGIN:
                handleAbrirLogin();
                break;
            default:
                break;
        }

    }
}
