/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttwiter;

import javax.swing.JOptionPane;

/**
 * menu
 *
 * @author acomesanavila
 */
public class TTwiter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Autorizacion.conexion();

        int select;

        do {
            select = Integer.parseInt(JOptionPane.showInputDialog("1. Nuevo estado \n 2.TimeLine \n 3.BuscarTwit \n 4.Mensaje"));
            switch (select) {

                case 1:
                    Autorizacion.twitearN(JOptionPane.showInputDialog(null, "Introducir nuevo Estado"));
                    break;
                case 2:
                    Autorizacion.lineaTiempo();
                    break;
                case 3:
                    Autorizacion.buscarTwit(JOptionPane.showInputDialog("Introduce el hastag"));
                    break;
                case 4:
                    Autorizacion.enviarMensaje(JOptionPane.showInputDialog("Introduce destinatario"), JOptionPane.showInputDialog("Introduce el mensaje"));
                    break;

            }

        } while (select != 0);

    }
}
