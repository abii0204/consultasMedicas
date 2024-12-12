package org.dam47.controllers;

import org.dam47.DAO.ConsultasDAO;
import org.dam47.views.VerificarCodigoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VerificarCodigoController implements ActionListener {

    private final VerificarCodigoView verificarTicket;
    private final ConsultasDAO consultasDAO;
    public static final String BT_VALIDAR = "bt_validar";

    public VerificarCodigoController(VerificarCodigoView verificarTicket, ConsultasDAO consultasDAO) {

        this.verificarTicket = verificarTicket;
        this.consultasDAO = consultasDAO;
    }

    public void handleValidarTicket() {
        try {
            consultasDAO.validarConsulta(verificarTicket.getTxCodigo());
            verificarTicket.closeWindow();
            verificarTicket.showWindow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case BT_VALIDAR:
               handleValidarTicket();
                break;
        }

    }
}