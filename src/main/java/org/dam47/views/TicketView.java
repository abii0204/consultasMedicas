package org.dam47.views;

import com.github.lgooddatepicker.components.DatePicker;
import org.dam47.models.MedicoModel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;

import static org.dam47.controllers.TicketController.CREAR;

public class TicketView extends JDialog implements InterfaceView{

    private JPanel mainPanel;
    private JComboBox cb_horas;
    private JButton bt_reservas;
    private DatePicker dp_fecha;
    private JComboBox cb_medicos;

    public TicketView(){
        initWindow();
        initComponents();
        setCommands();
    }

    public MedicoModel getCbMedicos() {
        return (MedicoModel)  cb_medicos.getSelectedItem(); // Devuelve el objeto seleccionado
    }


    public String getCbHoras(){
        return (String) cb_horas.getSelectedItem();
    }

    public String getDpFecha(){
        return dp_fecha.getDate().toString();
    }


    public void cargarComboMedicos(ArrayList<MedicoModel> medicosLista){
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        for(MedicoModel medico: medicosLista){
            comboModel.addElement(medico);
        }
        cb_medicos.setModel(comboModel);
    }

    public void cargarComboHoras(ArrayList<String> horasLista){
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        for(String hora: horasLista){
            comboModel.addElement(hora);
        }
        cb_horas.setModel(comboModel);
    }


    @Override
    public void initWindow() {
        setContentPane(mainPanel);
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
        bt_reservas.setActionCommand(CREAR);

    }

    @Override
    public void addListener(ActionListener listener) {
        cb_medicos.addActionListener(listener);
        bt_reservas.addActionListener(listener);
    }

    @Override
    public void initComponents() {
        ArrayList<String> horas = new ArrayList<>();
        horas.add("11:00:00");
        horas.add("11:15:00");
        horas.add("11:30:00");
        horas.add("12:00:00");
        horas.add("12:15:00");
        horas.add("12:30:00");
        horas.add("13:00:00");
        horas.add("13:15:00");
        horas.add("13:30:00");
        horas.add("14:00:00");
        horas.add("14:15:00");
        horas.add("14:30:00");
        horas.add("15:00:00");
        cargarComboHoras(horas);
    }


}
