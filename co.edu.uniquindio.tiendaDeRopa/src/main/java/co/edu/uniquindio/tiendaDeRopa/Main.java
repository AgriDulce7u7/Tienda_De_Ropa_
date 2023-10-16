package co.edu.uniquindio.tiendaDeRopa;

import co.edu.uniquindio.tiendaDeRopa.Model.Cliente;
import co.edu.uniquindio.tiendaDeRopa.Model.Compra;
import co.edu.uniquindio.tiendaDeRopa.Model.Empleado;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Sexo;
import co.edu.uniquindio.tiendaDeRopa.Model.Producto;
import co.edu.uniquindio.tiendaDeRopa.Model.Tienda;
import co.edu.uniquindio.tiendaDeRopa.Util.CapturaDatosUtil;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = inicializarDatosPrueba();

        /** Funciones CRUD
         * */
        //Create
        crearCliente( "Ana Cruz Marin", "1004830265", Sexo.FEMENINO, 11, "11/09/2023", tienda);
        crearCliente("Juan Mora Perez", "91850265", Sexo.MASCULINO, 9, "18/07/2023", tienda);
        crearCliente("Jose Luna Campos", "91850274", Sexo.MASCULINO, 21, "22/08/2023", tienda);
        crearCliente("Luis Ortiz Ruiz", "1094838275", Sexo.FEMENINO, 31, "13/09/2023",tienda);
        crearCliente("Isabel Chica Mora", "1010660485", Sexo.FEMENINO, 31, "13/09/2023",tienda);
        //Read
        mostrarInformacionCliente(tienda);
        System.out.println("Clientes creados  correctamente.");

        //Update
        actualizarCliente("1010660485", "Karen Escarraga", Sexo.FEMENINO, 1, "05/12/2023", tienda);

        //Delete
        eliminarCliente(tienda, "1004830265");
        System.out.println("-----> Informacion luego de eliminar");
        mostrarInformacionCliente(tienda);

        //Capturar de datos de forma dinamica
        int valor = CapturaDatosUtil.leerEnteroVentana("Ingrese la cedula del cliente: ");
        System.out.println("Valor obtenido es: "+valor);

        /**
         * Metodo para mostrar menú
         * */
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {

            System.out.println("1. Crear Cliente ");
            System.out.println("2. Leer Cliente ");
            System.out.println("3. Actualizar Cliente ");
            System.out.println("4. Eliminar Cliente ");
            System.out.println("5. Salir ");

            try {

                System.out.println("Escribe una de las opciones: ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        Main.crearCliente( "Ana Cruz Marin", "1004830265", Sexo.FEMENINO, 11, "11/09/2023", tienda);
                        Main.crearCliente("Juan Mora Perez", "91850265", Sexo.MASCULINO, 9, "18/07/2023", tienda);
                        Main.crearCliente("Jose Luna Campos", "91850274", Sexo.MASCULINO, 21, "22/08/2023", tienda);
                        Main.crearCliente("Luis Ortiz Ruiz", "1094838275", Sexo.FEMENINO, 31, "13/09/2023",tienda);
                        Main.crearCliente("Isabel Chica Mora", "1010660485", Sexo.FEMENINO, 31, "13/09/2023",tienda);
                        System.out.println("Has seleccionado la opcion 1.");
                        break;
                    case 2:
                        Main.mostrarInformacionCliente(tienda);
                        System.out.println("Has seleccionado la opcion 2.");
                        break;
                    case 3:
                        Main.actualizarCliente("1010660485", "Karen Escarraga", Sexo.FEMENINO, 1, "05/12/2023", tienda);
                        System.out.println("Has seleccionado la opcion 3.");
                        break;
                    case 4:
                        Main.eliminarCliente(tienda, "1000256235");
                        System.out.println("Has seleccionado la opcion 4.");
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número.");
                sn.next();
            }
        }
    }

    /**
     * Método para inializar  los datos del prestamo
     * */
    private static Tienda inicializarDatosPrueba() {
        Tienda tienda = new Tienda();
        tienda.setNombre("Monaco");
        System.out.println(tienda.getNombre());

        return tienda;
    }

    /**
     * Método para crear clientes
     * */
    private static void crearCliente(String nombreCompleto, String numeroIdentificacion, Sexo sexo, int prendasCompradas, String fechaUltimaCompra, Tienda tienda) {
        tienda.crearCliente(nombreCompleto, numeroIdentificacion, sexo, prendasCompradas, fechaUltimaCompra);
    }

    /**
     * Método para leer la lista de clientes
     * */
    private static void mostrarInformacionCliente(Tienda tienda) {
        List<Cliente> listaClientes = tienda.obtenerClientes();
        int tamanioLista = listaClientes.size();
        for(int i=0; i < tamanioLista; i++){
            Cliente cliente = listaClientes.get(i);
            System.out.println(cliente.toString());
        }
    }

    /**
     * Método para actualizar un cliente
     * */
    private static void actualizarCliente(String numeroIdentificacion,String nuevoNombreCompleto, Sexo nuevoSexo,
                                          int nuevaPrendasCompradas, String nuevoFechaUltimaCompra, Tienda tienda)
    { tienda.actualizarCliente(numeroIdentificacion, nuevoNombreCompleto,nuevoSexo, nuevaPrendasCompradas, nuevoFechaUltimaCompra);
    }

    /**
     * Método para  eliminar un cliente
     * */
    private static void eliminarCliente(Tienda tienda, String numeroIdentificacion) {
        tienda.eliminarCliente(numeroIdentificacion);
    }
}