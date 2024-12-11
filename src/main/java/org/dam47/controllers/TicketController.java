package org.dam47.controllers;

import org.dam47.DAO.ConsultasDAO;
import org.dam47.utils.Session;
import org.dam47.views.TicketView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public class TicketController implements ActionListener {
    private final TicketView ticketView;
    private final ConsultasDAO consultasDAO;

    public static final String CREAR = "CREAR";

    public TicketController(TicketView ticketView, ConsultasDAO consultasDAO) {
        this.ticketView = ticketView;
        this.consultasDAO = consultasDAO;
        handleCargarMedicos();
    }

    public void handleCargarMedicos(){
        try {
            ticketView.cargarComboMedicos(consultasDAO.getMedicosLista());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(CREAR)) {
            try {
                // Obtener el token y usuario de la sesión
                String token = Session.getToken();
                String usuario = Session.getUsername();

                // Validar que el usuario esté autenticado
                if (!Session.isAuthenticated()) {
                    JOptionPane.showMessageDialog(ticketView, "Debes iniciar sesión antes de realizar una reserva.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Capturar datos de la vista
                int idMedico = ticketView.getCbMedicos().getId();
                Date fecha = Date.valueOf(ticketView.getDpFecha());
                Time hora = Time.valueOf(ticketView.getCbHoras());

                // Imprimir datos para depuración
                System.out.println("Datos capturados:");
                System.out.println("Token: " + token);
                System.out.println("Usuario: " + usuario);
                System.out.println("Id Médico: " + idMedico);
                System.out.println("Fecha: " + fecha);
                System.out.println("Hora: " + hora);

                // Llamar al método de DAO para crear la consulta
                boolean resultado = consultasDAO.crearConsulta(token, usuario, idMedico, fecha, hora);

                if (resultado) {
                    JOptionPane.showMessageDialog(ticketView, "Consulta reservada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ticketView, "Error al reservar la consulta. Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(ticketView, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


}
