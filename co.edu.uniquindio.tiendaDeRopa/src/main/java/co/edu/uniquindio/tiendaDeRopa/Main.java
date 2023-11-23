package co.edu.uniquindio.tiendaDeRopa;

import co.edu.uniquindio.tiendaDeRopa.Model.*;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.*;
import co.edu.uniquindio.tiendaDeRopa.Util.CapturaDatosUtil;

import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;

import static co.edu.uniquindio.tiendaDeRopa.Util.CapturaDatosUtil.*;
import static co.edu.uniquindio.tiendaDeRopa.Util.CapturaDatosUtil.leerEntero;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = inicializarDatosPrueba();
        Producto producto1 = tienda.mostrarProducto("agh789");
        tienda.crearDetalleCompra(155, "Blusa", 3, 20000, 60000, "556", "Crop213");
        Date fechaCompra = new Date(23, 1, 31, 17, 00);
        Date fechaCompra1 = new Date(98, 9, 11, 11, 00);

        /* Funciones CRUD Cliente */
        //Create
        crearCliente("Ana Cruz Marin", "1004830265", Sexo.FEMENINO, 3024659, 11, new Date(23, 7, 6, 16, 0), MetodoPago.EFECTIVO, "41y", tienda);
        crearCliente("Juan Mora Perez", "91850265", Sexo.MASCULINO, 3065651, 2, new Date(22, 1, 9, 13, 0), MetodoPago.TARJETA, "4k5", tienda);
        crearCliente("Jose Luna Campos", "91850274", Sexo.MASCULINO, 3216549, 5, new Date(20, 12, 24, 10, 0), MetodoPago.TARJETA, "98m", tienda);
        //Read
        mostrarInformacionCliente(tienda);
        //Update
        actualizarCliente("1", "Karen Escarraga", "1010660485", Sexo.FEMENINO, 305912565, 12, new Date(22, 4, 3, 11, 00), MetodoPago.EFECTIVO, "ter8", tienda);
        //Delete
        eliminarCliente(tienda, "1");
        System.out.println("-----> Informacion luego de eliminar");
        mostrarInformacionCliente(tienda);


        /* CRUD Empleado */
        //Create
        crearEmpleado("Luis Ortiz Ruiz", "1094838275", Sexo.FEMENINO, 312356558, "argy78@", 1200000, TipoContrato.HORAS, 22, "156e", tienda);
        crearEmpleado("Isabel Chica Mora", "1010660485", Sexo.FEMENINO, 315454543, "hyu@d",1300000, TipoContrato.MEDIO_TIEMPO, 15, "guyi89",tienda);
        crearEmpleado("Santiago Ramirez", "15206232", Sexo.MASCULINO, 302156986, "santi@h78", 1450000, TipoContrato.HORAS, 32, "tre31", tienda);
        //Read
        mostrarInformacionEmpleado(tienda);
        //Update
        actualizarEmpleado("15206232","Santiago Ramirez", "15206232012", Sexo.MASCULINO, 302156986, "santi@h78", 1450000, TipoContrato.HORAS, 32, "tre31", tienda);
        //Delete
        eliminarEmpleado(tienda, "1");


        /* CRUD Producto */
        //Create
        crearProducto("Chaqueta Bomber", "tui09", TipoCliente.HOMBRE, TipoProducto.IMPORTADO, Talla.XL, Color.ROSADA, 120000, 14, 1, tienda);
        crearProducto("Vestido Semi ajustado", "hy7t", TipoCliente.MUJER, TipoProducto.NACIONAL, Talla.S, Color.NEGRA, 75000, 10, 1, tienda);
        crearProducto("Jean Looser", "pant65", TipoCliente.HOMBRE, TipoProducto.IMPORTADO, Talla.L, Color.AZUL, 150000, 20, 2, tienda);
        //Read
        mostrarInformacionProducto(tienda);
        //Update
        actualizarProducto("yui09", "Camisa Leñadora", "ret5", TipoCliente.HOMBRE, TipoProducto.IMPORTADO, Talla.M, Color.LILA, 95000, 9, 3, tienda);
        //Delete
        eliminarProducto(tienda, "h");

        /* CRUD Compra */
        //Create
        crearCompra("ret6", fechaCompra, 59000, "91850274", "1010660485", tienda);
        //Update
        actualizarCompra("jkñ8", "reyh8", fechaCompra1, 59000, "91850274", "1010660485", tienda);
        //Delete
        eliminarCompra(tienda, "e");

        gestionarOpcionesAplicacionPrestamoUQ(tienda);
    }
    /* Menú para gestionar las aplicaciones del proyecto */
    private static void gestionarOpcionesAplicacionPrestamoUQ(Tienda tienda) {
        int opcion = 0;
        do {
            mostrarMenuPrincipal();
            opcion= leerEntero("Seleccione una de las opciones del menú: ");
            switch (opcion) {
                case 1:
                    gestionarOpcionesCliente(tienda);
                    break;
                case 2:
                    gestionarOpcionesEmpleado(tienda);
                    break;
                case 3:
                    gestionarOpcionesProducto(tienda);
                    break;
                case 4:
                    gestionarOpcionesCompra(tienda);
                    break;
                case 5:
                    int valorRespuesta = mostrarMensajeAlerta("Esta seguro de desea salir de la aplicación");
                    if(valorRespuesta == 1){
                        opcion = 0;
                    }
                    break;
                default:
                    mostrarMensaje("La opción seleccionada no es una opción validad");
                    break;
            }
        }while(opcion!=5);
    }

    private static void gestionarOpcionesCliente(Tienda tienda) {
        int opcion = 0;
        do {
            mostrarMenuCrudCliente();
            opcion = leerEntero("Seleccione la opcion de gestión de clientes: ");
            switch (opcion) {
                case 1:
                    crearCliente(tienda);
                    break;
                case 2:
                    tienda.mostrarInformacionClientes();
                    break;
                case 3:
                    actualizarCliente(tienda);
                    break;
                case 4:
                    eliminarCliente(tienda);
                    break;
                case 5:
                    buscarCliente(tienda);
                    break;
                case 6:
                    obtenerClienteConMasCompras(tienda);
                    break;
                case 7:
                    mostrarClienteConMasComprasAsociadas(tienda);
                case 8:
                    int valorRespuesta = mostrarMensajeAlerta("Esta seguro de desea salir de la aplicación.");
                    if(valorRespuesta == 1){
                        opcion = 0;
                    }
                    break;
                default:
                    mostrarMensaje("La opción seleccionada no es una opción valida.");
                    break;
            }
        }while (opcion != 8);
    }

    private static void gestionarOpcionesEmpleado(Tienda tienda) {
        int opcion = 0;
        do {
            mostrarMenuCrudEmpleado();
            opcion = leerEntero("Seleccione la opcion de gestión de empleados: ");
            switch (opcion) {
                case 1:
                    crearEmpleado(tienda);
                    break;
                case 2:
                    tienda.mostrarInformacionEmpleados();
                    break;
                case 3:
                    actualizarEmpleado(tienda);
                    break;
                case 4:
                    eliminarEmpleado(tienda);
                    break;
                case 5:
                    buscarEmpleado(tienda);
                    break;
                case 6:
                    obtenerEmpleadoMayorSalario(tienda);
                    break;
                case 7:
                    obtenerEmpleadoMayorHorasTrabajo(tienda);
                    break;
                case 8:
                    int valorRespuesta = mostrarMensajeAlerta("Esta seguro de desea salir de la aplicación.");
                    if(valorRespuesta == 1){
                        opcion = 0;
                    }
                    break;
                default:
                    mostrarMensaje("La opción seleccionada no es una opción valida.");
                    break;
            }
        }while (opcion != 8);
    }

    private static void gestionarOpcionesProducto(Tienda tienda) {
        int opcion = 0;
        do {
            mostrarMenuCrudProducto();
            opcion = leerEntero("Seleccione la opcion de gestión de los productos: ");
            switch (opcion) {
                case 1:
                    crearProducto(tienda);
                    break;
                case 2:
                    tienda.mostrarInformacionProductos();
                    break;
                case 3:
                    actualizarProducto(tienda);
                    break;
                case 4:
                    eliminarProducto(tienda);
                    break;
                case 5:
                    buscarProducto(tienda);
                    break;
                case 6:
                    obtenerCantidadProducto(tienda);
                    break;
                case 7:
                    obtenerProductoMasCostoso(tienda);
                    break;
                case 8:
                    int valorRespuesta = mostrarMensajeAlerta("Esta seguro de desea salir de la aplicación.");
                    if(valorRespuesta == 1){
                        opcion = 0;
                    }
                    break;
                default:
                    mostrarMensaje("La opción seleccionada no es una opción valida.");
                    break;
            }
        }while (opcion != 8);
    }

    private static void gestionarOpcionesCompra(Tienda tienda) {
        int opcion = 0;
        do {
            mostrarMenuCrudCompra();
            opcion = leerEntero("Seleccione la opcion de gestión de las compras: ");
            switch (opcion) {
                case 1:
                    crearCompra(tienda);
                    break;
                case 2:
                    actualizarCompra(tienda);
                    break;
                case 3:
                    eliminarCompra(tienda);
                    break;
                case 4:
                    buscarCompra(tienda);
                    break;
                case 5:
                    int valorRespuesta = mostrarMensajeAlerta("Esta seguro de desea salir de la aplicación.");
                    if(valorRespuesta == 1){
                        opcion = 0;
                    }
                    break;
                default:
                    mostrarMensaje("La opción seleccionada no es una opción valida.");
                    break;
            }
        }while (opcion != 5);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Opciones del menú principal: ");
        System.out.println("1 - Gestionar clientes");
        System.out.println("2 - Gestionar empleados");
        System.out.println("3 - Gestionar productos");
        System.out.println("4 - Realizar compra de productos");
        System.out.println("5 - Salir");
    }

    private static void mostrarMenuCrudCliente() {
        System.out.println("Menú gestion clientes: ");
        System.out.println("1 - Crear Cliente");
        System.out.println("2 - Mostrar la información de los clientes");
        System.out.println("3 - Actualizar cliente");
        System.out.println("4 - Eliminar cliente");
        System.out.println("5 - Buscar cliente");
        System.out.println("6 - Obtener el cliente con más prendas compradas");
        System.out.println("7 - Obtener el cliente con más compras");
        System.out.println("8 - Salir");
    }

    private static void mostrarMenuCrudEmpleado() {
        System.out.println("Menú gestion empleados: ");
        System.out.println("1 - Crear empleado");
        System.out.println("2 - Mostrar la información de los empleados");
        System.out.println("3 - Actualizar empleado");
        System.out.println("4 - Eliminar empleado");
        System.out.println("5 - Buscar empleado");
        System.out.println("6 - Obtener el empleado con mayor salario");
        System.out.println("7 - Obtener el empleado con más horas de trabajo");
        System.out.println("8 - Salir");

    }

    private static void mostrarMenuCrudProducto() {
        System.out.println("Menú gestion productos: ");
        System.out.println("1 - Crear producto");
        System.out.println("2 - Mostrar la información de los productos");
        System.out.println("3 - Actualizar producto");
        System.out.println("4 - Eliminar producto");
        System.out.println("5 - Buscar producto");
        System.out.println("7 - Obtener el producto con más stock");
        System.out.println("8 - Obtener el producto más costoso");
        System.out.println("6 - Salir");
    }

    private static void mostrarMenuCrudCompra() {
        System.out.println("Menú gestion compras: ");
        System.out.println("1 - Crear compra");
        System.out.println("2 - Actualizar compra");
        System.out.println("3 - Eliminar compra");
        System.out.println("4 - Buscar compra");
        System.out.println("5 - Salir");
    }

    private static void crearCliente(Tienda tienda) {
        String nombreCompleto = leerStringConsola("Ingrese el nombre del cliente: ");
        String cedula = leerStringConsola("Ingrese la cédula del cliente: ");
        Sexo sexo = Sexo.MASCULINO;
        long telefono = leerLongConsola("Ingrese el télefono del cliente: ");
        int prendasCompradas = leerEntero("Ingrese el total de prendas compradaspor el cliente: ");
        Date fechaUltimaCompra = new Date(23, 5, 9, 5, 0);
        MetodoPago metodoPago = MetodoPago.TARJETA;
        String codigoCompra = leerStringConsola("Ingrese el código de la compra realizada por el cliente: ");
        boolean flagCreado = tienda.crearCliente(nombreCompleto, cedula, sexo, telefono, prendasCompradas, fechaUltimaCompra, metodoPago, codigoCompra);
        if(flagCreado == true){
            System.out.println("El cliente fue creado con éxito.");
        }else{
            System.out.println("El cliente no pudo ser creado.");
        }
    }

    private static void actualizarCliente(Tienda tienda) {
        String cedulaActual = leerStringConsola("Ingrese la cédula actual del cliente: ");
        String nombreCompleto = leerStringConsola("Ingrese el nombre del cliente: ");
        String cedula = leerStringConsola("Ingrese la cédula del cliente: ");
        Sexo sexo = Sexo.MASCULINO;
        long telefono = leerLongConsola("Ingrese el télefono del cliente: ");
        int prendasCompradas = leerEntero("Ingrese el total de prendas compradaspor el cliente: ");
        Date fechaUltimaCompra = new Date(23, 5, 9, 5, 0);
        MetodoPago metodoPago = MetodoPago.TARJETA;
        String codigoCompra = leerStringConsola("Ingrese el código de la compra realizada por el cliente: ");
        boolean flagActualizado = tienda.actualizarCliente(cedulaActual, nombreCompleto, cedula, sexo, telefono, prendasCompradas, fechaUltimaCompra, metodoPago, codigoCompra);
        if(flagActualizado == true){
            System.out.println("Cliente actualizado con éxito.");
        }else{
            System.out.println("El cliente no se pudo actualizar.");
        }
    }

    private static void eliminarCliente(Tienda tienda){
        String cedula = leerStringConsola("Ingrese la cédula del cliente: ");
        tienda.eliminarCliente(cedula);
    }

    private static void buscarCliente(Tienda tienda) {
        String cedula = leerStringConsola("Ingrese la cédula del cliente: ");
        tienda.buscarCliente(cedula);
    }

    private static void obtenerClienteConMasCompras(Tienda tienda){
        tienda.obtenerClienteConMasCompras();
    }

    private static void mostrarClienteConMasComprasAsociadas(Tienda tienda){
        tienda.mostrarClienteConMasComprasAsociadas();
    }

    private static void crearEmpleado(Tienda tienda) {
        String nombreCompleto = leerStringConsola("Ingrese el nombre del empleado: ");
        String cedula = leerStringConsola("Ingrese la cédula del empleado: ");
        Sexo sexo = Sexo.FEMENINO;
        long telefono = leerLongConsola("Ingrese el télefono del empleado: ");
        String correo = leerStringConsola("Ingrese el correo del empleado: ");
        double salario = leerDoubleConsola("Ingrese el salario del empleado: ");
        TipoContrato tipoContrato = TipoContrato.MEDIO_TIEMPO;
        int horasTrabajo = leerEntero("Ingrese las horas de trabajo del empleado: ");
        String codigoCompra = leerStringConsola("Ingrese el código de la compra realizada por el cliente: ");
        boolean flagCreado = tienda.crearEmpleado(nombreCompleto, cedula, sexo, telefono, correo, salario, tipoContrato, horasTrabajo, codigoCompra);
        if(flagCreado == true){
            System.out.println("El empleado fue creado con éxito.");
        }else{
            System.out.println("El empleado no pudo ser creado.");
        }
    }

    private static void actualizarEmpleado(Tienda tienda) {
        String cedulaActual = leerStringConsola("Ingrese la cédula actual del cliente: ");
        String nombreCompleto = leerStringConsola("Ingrese el nombre del empleado: ");
        String cedula = leerStringConsola("Ingrese la cédula del empleado: ");
        Sexo sexo = Sexo.FEMENINO;
        long telefono = leerLongConsola("Ingrese el télefono del empleado: ");
        String correo = leerStringConsola("Ingrese el correo del empleado: ");
        double salario = leerDoubleConsola("Ingrese el salario del empleado: ");
        TipoContrato tipoContrato = TipoContrato.MEDIO_TIEMPO;
        int horasTrabajo = leerEntero("Ingrese las horas de trabajo del empleado: ");
        String codigoCompra = leerStringConsola("Ingrese el código de la compra realizada por el cliente: ");
        boolean flagActualizado = tienda.actualizarEmpleado(cedulaActual, nombreCompleto, cedula, sexo, telefono, correo, salario, tipoContrato, horasTrabajo, codigoCompra);
        if(flagActualizado == true){
            System.out.println("Empleado actualizado con éxito.");
        }else{
            System.out.println("El empleado no se pudo actualizar.");
        }
    }

    private static void eliminarEmpleado(Tienda tienda){
        String cedula = leerStringConsola("Ingrese la cédula del empleado: ");
        tienda.eliminarEmpleado(cedula);
    }

    private static void buscarEmpleado(Tienda tienda) {
        String cedula = leerStringConsola("Ingrese la cédula del empleado: ");
        tienda.buscarEmpleado(cedula);
    }

    private static void obtenerEmpleadoMayorSalario(Tienda tienda){
        tienda.obtenerEmpleadoMayorSalario();
    }

    private static void obtenerEmpleadoMayorHorasTrabajo(Tienda tienda){
        tienda.obtenerEmpleadoMayorHorasTrabajo();
    }

    private static void crearProducto(Tienda tienda) {
        String nombre = leerStringConsola("Ingrese el nombre del producto: ");
        String referencia = leerStringConsola("Ingrese la referencia del producto: ");
        TipoCliente tipoCliente = TipoCliente.HOMBRE;
        TipoProducto tipoProducto = TipoProducto.NACIONAL;
        Talla talla = Talla.M;
        Color color = Color.LILA;
        double precio = leerDoubleConsola("Ingrese el precio del producto: ");
        int cantidadDisponible = leerEntero("Ingrese la cantidad disponible del producto: ");
        int numeroDetalle = leerEntero("Ingrese el número de detalle de la compra a la que esta asociada el producto: ");
        boolean flagCreado = tienda.crearProducto(nombre, referencia, tipoCliente, tipoProducto, talla, color, precio, cantidadDisponible, numeroDetalle);
        if(flagCreado == true){
            System.out.println("El producto fue creado con éxito.");
        }else{
            System.out.println("El producto no pudo ser creado.");
        }
    }

    private static void actualizarProducto(Tienda tienda) {
        String referenciaActual = leerStringConsola("Ingrese la referencia actual del cliente: ");
        String nombre = leerStringConsola("Ingrese el nombre del producto: ");
        String referencia = leerStringConsola("Ingrese la referencia del producto: ");
        TipoCliente tipoCliente = TipoCliente.HOMBRE;
        TipoProducto tipoProducto = TipoProducto.NACIONAL;
        Talla talla = Talla.M;
        Color color = Color.LILA;
        double precio = leerDoubleConsola("Ingrese el precio del producto: ");
        int cantidadDisponible = leerEntero("Ingrese la cantidad disponible del producto: ");
        int numeroDetalle = leerEntero("Ingrese el número de detalle de la compra a la que esta asociada el producto: ");
        boolean flagActualizado = tienda.actualizarProducto(referenciaActual, nombre, referencia, tipoCliente, tipoProducto, talla, color, precio, cantidadDisponible, numeroDetalle);
        if(flagActualizado == true){
            System.out.println("Empleado actualizado con éxito.");
        }else{
            System.out.println("El empleado no se pudo actualizar.");
        }
    }

    private static void eliminarProducto(Tienda tienda){
        String referencia = leerStringConsola("Ingrese la referencia del producto: ");
        tienda.eliminarProducto(referencia);
    }

    private static void buscarProducto(Tienda tienda) {
        String referencia = leerStringConsola("Ingrese la referencia del producto: ");
        tienda.buscarProducto(referencia);
    }

    private static void obtenerCantidadProducto (Tienda tienda){
        tienda.obtenerCantidadProducto();
    }

    private static void obtenerProductoMasCostoso(Tienda tienda){
        tienda.obtenerProductoMasCostoso();
    }

    private static void crearCompra(Tienda tienda) {
        String codigoCompra = leerStringConsola("Ingrese el codigo de la compra: ");
        Date fechaCompra = new Date(23, 6, 18, 11, 0);
        double totalCompra = leerDoubleConsola("Ingrese el total de la compra: ");
        String cedulaEmpleadoAsociado = leerStringConsola("Ingrese la cédula del empleado que realizo la compra: ");
        String cedulaClienteAsociado = leerStringConsola("Ingrese la cédula del cliente que hizo la compra: ");
        boolean flagCreado = tienda.crearCompra(codigoCompra, fechaCompra, totalCompra, cedulaEmpleadoAsociado, cedulaClienteAsociado);
        if(flagCreado == true){
            System.out.println("La compra fue creada con éxito.");
        }else{
            System.out.println("La compra no pudo ser creada.");
        }
    }

    private static void actualizarCompra(Tienda tienda) {
        String codigoCompraActual = leerStringConsola("Ingrese el codigo de la compra: ");
        String codigoCompra = leerStringConsola("Ingrese el codigo de la compra: ");
        Date fechaCompra = new Date(23, 6, 18, 11, 0);
        double totalCompra = leerDoubleConsola("Ingrese el total de la compra: ");
        String cedulaEmpleadoAsociado = leerStringConsola("Ingrese la cédula del empleado que realizo la compra: ");
        String cedulaClienteAsociado = leerStringConsola("Ingrese la cédula del cliente que hizo la compra: ");
        boolean flagCreado = tienda.actualizarCompra(codigoCompraActual, codigoCompra, fechaCompra, totalCompra, cedulaEmpleadoAsociado, cedulaClienteAsociado);
        if(flagCreado == true){
            System.out.println("La compra fue actualizada con éxito.");
        }else{
            System.out.println("La compra no pudo ser actualizada.");
        }
    }

    private static void eliminarCompra(Tienda tienda){
        String codigoCompra = leerStringConsola("Ingrese el código de la compra: ");
        tienda.eliminarCompra(codigoCompra);
    }

    private static void buscarCompra(Tienda tienda){
        String codigoCompra = leerStringConsola("Ingrese el código de la compra: ");
        tienda.buscarCompra(codigoCompra);
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
        empleado.setCedula("15206232");
        empleado.setSexo(Sexo.MASCULINO);
        empleado.setTelefono(302156986);
        empleado.setCorreo("santi@h78");
        empleado.setSalario(1450000);
        empleado.setTipoContrato(TipoContrato.HORAS);
        empleado.setHorasTrabajo(32);

        Compra compra = new Compra();
        compra.setCodigoCompra("agh56");
        compra.setTotalCompra(25000);

        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setNumeroDetalle(1);
        detalleCompra.setProductoComprado("Vestido");
        detalleCompra.setCantidadComprado(2);
        detalleCompra.setValorUnidad(78000.0);
        detalleCompra.setValorTotal(156000.0);

        chaqueta.setOwnedByTienda(tienda);
        cliente.setOwnedByTienda(tienda);
        empleado.setOwnedByTienda(tienda);
        compra.setOwnedByTienda(tienda);
        detalleCompra.setOwnedByCompra(compra);

        tienda.getListaProductos().add(chaqueta);
        tienda.getListaClientes().add(cliente);
        tienda.getListaEmpleados().add(empleado);
        tienda.getListaCompras().add(compra);
        tienda.getListaDetalleCompra().add(detalleCompra);

        System.out.println(tienda.getNombre());

        return tienda;
    }

    /* Método para crear clientes */
    private static void crearCliente(String nombreCompleto, String cedula, Sexo sexo, long telefono, int prendasCompradas, Date fechaUltimaCompra, MetodoPago metodoPago, String codigoCompra, Tienda tienda) {
        tienda.crearCliente(nombreCompleto, cedula, sexo, telefono, prendasCompradas, fechaUltimaCompra, metodoPago, codigoCompra);
    }

    /* Método para leer la lista de clientes */
    private static void mostrarInformacionCliente(Tienda tienda) {
        List<Cliente> listaClientes = tienda.obtenerClientes();
        int tamanioLista = listaClientes.size();
        for(int i=0; i < tamanioLista; i++){
            Cliente cliente = listaClientes.get(i);
            System.out.println(cliente.toString());
        }
    }

    /* Método para actualizar un cliente */
    private static void actualizarCliente(String cedulaActual, String nombreCompleto, String cedula, Sexo sexo, long telefono, int prendasCompradas, Date fechaUltimaCompra, MetodoPago metodoPago, String codigoCompra, Tienda tienda)
    { tienda.actualizarCliente(cedulaActual, nombreCompleto, cedula, sexo, telefono, prendasCompradas, fechaUltimaCompra, metodoPago, codigoCompra);
    }

    /* Método para  eliminar un cliente */
    private static void eliminarCliente(Tienda tienda, String cedula) {
        tienda.eliminarCliente(cedula);
    }

    /* Método para crear empleado */
    private static void crearEmpleado(String nombreCompleto, String cedula, Sexo sexo, long telefono, String correo, double salario, TipoContrato tipoContrato, int horasTrabajo, String codigoCompra, Tienda tienda){
        tienda.crearEmpleado(nombreCompleto, cedula, sexo, telefono, correo, salario, tipoContrato, horasTrabajo, codigoCompra);
    }

    /* Método para leer lista de empleados */
    private static void mostrarInformacionEmpleado(Tienda tienda) {
        List<Empleado> listaEmpleados = tienda.obtenerEmpleados();
        int tamanioLista = listaEmpleados.size();
        for(int i=0; i < tamanioLista; i++){
            Empleado empleado = listaEmpleados.get(i);
            System.out.println(empleado.toString());
        }
    }

    /* Método para acualizar un empleado */
    private static void actualizarEmpleado(String cedulaActual, String nombreCompleto, String cedula, Sexo sexo, long telefono, String correo, double salario, TipoContrato tipoContrato, int horasTrabajo, String codigoCompra, Tienda tienda){
        tienda.actualizarEmpleado(cedulaActual, nombreCompleto, cedula, sexo, telefono, correo, salario, tipoContrato, horasTrabajo, codigoCompra);
    }

    /* Método para  eliminar un empleado */
    private static void eliminarEmpleado(Tienda tienda, String cedula) {
        tienda.eliminarEmpleado(cedula);
    }

    /* Método para crear un producto */
    public static void crearProducto(String nombre, String referencia, TipoCliente tipoCliente, TipoProducto tipoProducto, Talla talla, Color color, double precio, int cantidadDisponible, int numeroDetalle, Tienda tienda){
        tienda.crearProducto(nombre, referencia, tipoCliente, tipoProducto, talla, color, precio, cantidadDisponible, numeroDetalle);
    }

    /* Método para leer lista de productos */
    private static void mostrarInformacionProducto(Tienda tienda) {
        List<Producto> listaProductos = tienda.obtenerProductos();
        int tamanioLista = listaProductos.size();
        for(int i=0; i < tamanioLista; i++){
            Producto producto = listaProductos.get(i);
            System.out.println(producto.toString());
        }
    }

    /* Método para acualizar un producto */
    private static void actualizarProducto(String referenciaActual, String nombre, String referencia, TipoCliente tipoCliente, TipoProducto tipoProducto, Talla talla, Color color, double precio, int cantidadDisponible, int numeroDetalle, Tienda tienda){
        tienda.actualizarProducto(referenciaActual, nombre, referencia, tipoCliente, tipoProducto, talla, color, precio, cantidadDisponible, numeroDetalle);
    }

    /* Método para  eliminar un empleado */
    private static void eliminarProducto(Tienda tienda, String referencia) {
        tienda.eliminarProducto(referencia);
    }

    /* Método para crear compra */
    private static void crearCompra(String codigoCompra, Date fechaCompra, double totalCompra, String cedulaCliente, String cedulaEmpleado, Tienda tienda) {
        tienda.crearCompra(codigoCompra, fechaCompra, totalCompra, cedulaCliente, cedulaEmpleado);
    }

    /* Método para actualizar compra */
    private static void actualizarCompra(String codigoCompraActual, String codigoCompra, Date fechaCompra, double totalCompra, String cedulaCliente, String cedulaEmpleado, Tienda tienda){
        tienda.actualizarCompra(codigoCompraActual, codigoCompra, fechaCompra, totalCompra, cedulaCliente, cedulaEmpleado);
    }

    /* Método para eliminar una compra */
    private static void eliminarCompra(Tienda tienda, String codigoCompra){
        tienda.eliminarCompra(codigoCompra);
    }
}