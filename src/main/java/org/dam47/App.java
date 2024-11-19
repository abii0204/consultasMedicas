package org.dam47;

import com.formdev.flatlaf.FlatLightLaf;
import org.dam47.controllers.LoginDialogController;
import org.dam47.controllers.MainFrameController;
import org.dam47.views.LoginDialog;
import org.dam47.views.MainFrame;

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
        LoginDialog loginDialog = new LoginDialog();

        //controladores
        MainFrameController mainFrameController = new MainFrameController(mainFrame, loginDialog);
        LoginDialogController loginDialogController = new LoginDialogController(loginDialog);

        //listenners
        mainFrame.addListener(mainFrameController);
        loginDialog.addListener(loginDialogController);


        mainFrame.showWindow();
    }
}
