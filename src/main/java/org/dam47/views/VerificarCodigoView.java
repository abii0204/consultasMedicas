package org.dam47.views;

import javax.swing.*;
import java.awt.event.ActionListener;

import static org.dam47.controllers.VerificarCodigoController.BT_VALIDAR;


public class VerificarCodigoView extends JDialog implements InterfaceView{
    private JPanel mainPanel;
    private JTextField tx_codigo;
    private JButton bt_validar;

    public VerificarCodigoView(){
        initWindow();
        initComponents();
        setCommands();
    }

    @Override
    public void initWindow() {
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
    }

    public String getTxCodigo() {
        return tx_codigo.getText();
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
        bt_validar.setActionCommand(BT_VALIDAR);
    }

    @Override
    public void addListener(ActionListener listener) {
        bt_validar.addActionListener(listener);
    }

    @Override
    public void initComponents() {

    }
}
