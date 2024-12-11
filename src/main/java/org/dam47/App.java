package org.dam47;

import com.formdev.flatlaf.FlatLightLaf;
import org.dam47.DAO.ConsultasDAO;
import org.dam47.controllers.LoginDialogController;
import org.dam47.controllers.MainFrameController;
import org.dam47.controllers.TicketController;
import org.dam47.views.LoginDialog;
import org.dam47.views.MainFrame;
import org.dam47.views.TicketView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FlatLightLaf.setup();
        System.out.println("INICIO PROGRAMA");

        //vistas
        MainFrame mainFrame = new MainFrame();
        TicketView ticketView = new TicketView();
        LoginDialog loginDialog = new LoginDialog(ticketView);
        ConsultasDAO consultasDAO = new ConsultasDAO();

        //controladores
        MainFrameController mainFrameController = new MainFrameController(mainFrame, loginDialog);
        LoginDialogController loginDialogController = new LoginDialogController(loginDialog);
        TicketController ticketController = new TicketController(ticketView, consultasDAO);

        //listenners
        mainFrame.addListener(mainFrameController);
        loginDialog.addListener(loginDialogController);
        ticketView.addListener(ticketController);


        mainFrame.showWindow();
    }
}
