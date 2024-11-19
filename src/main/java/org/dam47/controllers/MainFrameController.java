package org.dam47.controllers;

import org.dam47.views.LoginDialog;
import org.dam47.views.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController implements ActionListener {

    private final MainFrame mainFrame;
    private final LoginDialog loginDialog;

    public static final String LOGIN = "LOGIN";

    public MainFrameController(MainFrame mainFrame, LoginDialog loginDialog) {
        this.mainFrame = mainFrame;
        this.loginDialog = loginDialog;
    }

    public void handleLogin(){
        loginDialog.showWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case LOGIN:
                handleLogin();
                break;
            default:
                break;
        }

    }
}
