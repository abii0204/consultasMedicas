package org.dam47.views;

import javax.swing.*;
import java.awt.event.ActionListener;

import static org.dam47.controllers.MainFrameController.LOGIN;

public class MainFrame extends JFrame implements InterfaceView{

    public MainFrame() {
        initWindow();
        initComponents();
        setCommands();
    }

    private JPanel mainPanel;
    private JButton btn_login;

    @Override
    public void initWindow() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void showWindow() {
        setVisible(true);
    }

    @Override
    public void closeWindow() {
        dispose();
    }

    @Override
    public void setCommands() {
        btn_login.setActionCommand(LOGIN);

    }

    @Override
    public void addListener(ActionListener listener) {
        btn_login.addActionListener(listener);
    }

    @Override
    public void initComponents() {

    }
}
