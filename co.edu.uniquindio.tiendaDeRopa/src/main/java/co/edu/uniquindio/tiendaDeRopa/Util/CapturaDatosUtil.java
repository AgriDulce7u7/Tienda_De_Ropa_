package co.edu.uniquindio.tiendaDeRopa.Util;


import javax.swing.*;
import java.util.Date;
import java.util.Scanner;

public class CapturaDatosUtil {
    public static int mostrarMensajeAlerta(String mensaje){
        return JOptionPane.showConfirmDialog(
                null,
                mensaje,
                "Alerta!",
                JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }


    /* Captura de datos por consola */

    /**
     *
     * @param mensaje
     * @return
     */
    public static int leerEntero(String mensaje) {
        int dato = 0;
        String captura = "";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        dato = Integer.parseInt(captura);
        return dato;
    }

    /**
     *
     * @param mensaje
     * @return
     */
    public static double leerDoubleConsola(String mensaje) {
        double dato = 0;
        String captura = "";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        dato = Double.parseDouble(captura);
        return dato;
    }

    /**
     *
     * @param mensaje
     * @return
     */
    public static long leerLongConsola(String mensaje) {
        long dato = 0;
        String captura = "";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        dato = Long.parseLong(captura);
        return dato;
    }


    /**
     *
     * @param mensaje
     * @return
     */
    public static String leerStringConsola(String mensaje) {
        String captura = "";
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        captura = teclado.nextLine();
        return captura;
    }

    /**
     *
     * @param mensaje
     * @return
     */
    public static boolean leerBooleano(String mensaje){
        Scanner entradaEscaner = new Scanner(System.in);
        boolean dato;

        System.out.println(mensaje);
        dato = entradaEscaner.nextBoolean();
        entradaEscaner.nextLine();
        return dato;
    }

    /**
     *
     * @param msj
     * @return
     */
    private static float leerFloat(String msj) {
        float dato;
        System.out.println(msj);
        Scanner teclado = new Scanner(System.in);
        dato= Float.parseFloat(teclado.nextLine());
        return dato;
    }
}
