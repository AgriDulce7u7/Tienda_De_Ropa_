package co.edu.uniquindio.tiendaDeRopa.Util;

import javax.swing.*;

public class CapturaDatosUtil {
    /**
     * Permite leer un numero entero mediante una caja de dialogo
     * @param mensaje El mensaje que verá el usuario
     * @return el numero ingresado por el usuario
     */
    public static int leerEnteroVentana (String mensaje)
    {
        int dato= Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return dato;
    }
}
