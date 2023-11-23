package co.edu.uniquindio.tiendaDeRopa;

import co.edu.uniquindio.tiendaDeRopa.Model.*;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.*;

public class MainMenu {
    public static void main(String[] args) {
        Tienda tienda = inicializarDatosPrueba();
        gestionarOpcionesAplicacionPrestamoUQ(tienda);
    }

    private static void gestionarOpcionesAplicacionPrestamoUQ(Tienda tienda) {
    }

    /* Método para inializar  los datos de la tienda */
    private static Tienda inicializarDatosPrueba() {
        Tienda tienda = new Tienda();
        tienda.setNombre("Monaco");

        Chaqueta chaqueta = new Chaqueta();
        chaqueta.setNombre("bomber");
        chaqueta.setReferencia("yui09");
        chaqueta.setTipoCliente(TipoCliente.HOMBRE);
        chaqueta.setTalla(Talla.XL);
        chaqueta.setColor(Color.AZUL);
        chaqueta.setPrecio(120000.0);
        chaqueta.setCantidadDisponible(14);

        Cliente cliente = new Cliente();
        cliente.setNombreCompleto("Ana Cruz Marin");
        cliente.setCedula("1004830265");
        cliente.setSexo(Sexo.FEMENINO);
        cliente.setTelefono(4554);
        cliente.setPrendasCompradas(11);
        cliente.setMetodoPago(MetodoPago.EFECTIVO);

        Empleado empleado = new Empleado();
        empleado.setNombreCompleto("Santiago Ramirez");
        empleado.setCedula("1520623205");
        empleado.setSexo(Sexo.MASCULINO);
        empleado.setTelefono(302156986);
        empleado.setCorreo("santi@h78");
        empleado.setSalario(1450000);
        empleado.setTipoContrato(TipoContrato.HORAS);
        empleado.setHorasTrabajo(32);

        chaqueta.setOwnedByTienda(tienda);
        cliente.setOwnedByTienda(tienda);
        empleado.setOwnedByTienda(tienda);

        tienda.getListaProductos().add(chaqueta);
        tienda.getListaPersonas().add(cliente);
        tienda.getListaPersonas().add(empleado);

        System.out.println(tienda.getNombre());

        chaqueta.setOwnedByTienda(tienda);

        tienda.getListaProductos().add(chaqueta);

        System.out.println(tienda.getNombre());

        return tienda;
    }
}
