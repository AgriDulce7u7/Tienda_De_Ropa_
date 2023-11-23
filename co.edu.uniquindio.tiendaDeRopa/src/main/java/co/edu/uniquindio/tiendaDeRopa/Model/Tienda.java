package co.edu.uniquindio.tiendaDeRopa.Model;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.*;
import co.edu.uniquindio.tiendaDeRopa.Service.ITienda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tienda implements ITienda {
    private  String nombre;
    List<Cliente> listaClientes = new ArrayList<>();
    List<Empleado> listaEmpleados = new ArrayList<>();
    List<Compra> listaCompras = new ArrayList<>();
    List<Producto> listaProductos = new ArrayList<>();
    List<DetalleCompra> listaDetalleCompra = new ArrayList<>();

    /*Constructor*/
    public Tienda() {
    }

    /*Getters and Setters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<DetalleCompra> getListaDetalleCompra() {
        return listaDetalleCompra;
    }

    public void setListaDetalleCompra(List<DetalleCompra> listaDetalleCompra) {
        this.listaDetalleCompra = listaDetalleCompra;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "Nombre = " + nombre + '\'' +
                '}';
    }

    /* Método para crear un cliente */
    @Override
    public boolean crearCliente(String nombreCompleto, String cedula, Sexo sexo, long telefono, int prendasCompradas, Date fechaUltimaCompra, MetodoPago metodoPago, String codigoCompra) {
        if (buscarClientes(cedula) == null){
            Cliente cliente = new Cliente();
            cliente.setNombreCompleto(nombreCompleto);
            cliente.setCedula(cedula);
            cliente.setSexo(sexo);
            cliente.setTelefono(telefono);
            cliente.setPrendasCompradas(prendasCompradas);
            cliente.setFechaUltimaCompra(fechaUltimaCompra);
            cliente.setMetodoPago(metodoPago);
            getListaClientes().add(cliente);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Cliente obtenerCliente(String cedula) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente : getListaClientes()) {
            if (cliente.getCedula().equalsIgnoreCase(cedula)){
                clienteEncontrado = cliente;
                break;
            }
        }

        return clienteEncontrado;
    }

    @Override
    public boolean actualizarCliente(String cedulaActual, String nombreCompleto, String cedula, Sexo sexo, long telefono, int prendasCompradas, Date fechaUltimaCompra, MetodoPago metodoPago, String codigoCompra) {
        Cliente clienteEncontrado = obtenerCliente(cedulaActual);
        if(clienteEncontrado != null){
            clienteEncontrado.setNombreCompleto(nombreCompleto);
            clienteEncontrado.setCedula(cedula);
            clienteEncontrado.setSexo(sexo);
            clienteEncontrado.setTelefono(telefono);
            clienteEncontrado.setPrendasCompradas(prendasCompradas);
            clienteEncontrado.setFechaUltimaCompra(fechaUltimaCompra);
            clienteEncontrado.setMetodoPago(metodoPago);
            getListaClientes().add(clienteEncontrado);

            return true;
        }else{
            return false;
        }
    }

    @Override
    public void eliminarCliente(String cedula) {
        Cliente clienteEncontrado = obtenerCliente(cedula);
        if (clienteEncontrado != null){
            System.out.println("El cliente fue eliminado.");
            getListaClientes().remove(clienteEncontrado);
        }else{
            System.out.println("El cliente no pudo ser eliminado.");
        }
    }

    /**
     * Metodo para buscar y mostrar la informacion de un cliente
     * @param cedula
     */
    public void buscarCliente(String cedula) {
        Cliente clienteEncontrado = obtenerCliente(cedula);
        if(clienteEncontrado != null){
            System.out.println("El cliente fue encontrado con éxito.");
            System.out.println(clienteEncontrado.toString());
        }else{
            System.out.println("El cliente no fue encontraddo.");
        }
    }

    public Cliente buscarClientes(String cedula) {
        for (Cliente cliente : getListaClientes()) {
            if (cliente.getCedula().equalsIgnoreCase(cedula)){
                return cliente;
            }
        }
        return null;
    }

    public int obtenerClienteConMasCompras() {
        int clienteMayorCompras = 0;
        for (Cliente cliente : getListaClientes()) {
            if (cliente.getPrendasCompradas() > clienteMayorCompras){
                clienteMayorCompras = cliente.getPrendasCompradas();
            }
            System.out.println("El cliente con más prendas compradas es: "+ clienteMayorCompras);
            break;
        }
        return clienteMayorCompras;
    }

    public String mostrarClienteConMasComprasAsociadas(){
        int compras = 0;
        Cliente clienteMasCompras = null;
        for (Cliente cliente : getListaClientes()) {
            if (cliente.getComprasAsociadas().size() > compras){
                compras = cliente.getComprasAsociadas().size();
                clienteMasCompras = cliente;
            }
        }
        String mensaje = "El cliente con más compras es: \n"+
                clienteMasCompras.toString()+"\n"+
                "El número de compras hechas por este cliente es: "+ compras;
        return mensaje;
    }

    @Override
    public boolean crearEmpleado(String nombreCompleto, String cedula, Sexo sexo, long telefono, String correo, double salario, TipoContrato tipoContrato, int horasTrabajo, String codigoCompra) {
        if (buscarEmpleados(cedula) == null){
            Empleado empleado = new Empleado();
            empleado.setNombreCompleto(nombreCompleto);
            empleado.setCedula(cedula);
            empleado.setSexo(sexo);
            empleado.setTelefono(telefono);
            empleado.setCorreo(correo);
            empleado.setSalario(salario);
            empleado.setTipoContrato(tipoContrato);
            empleado.setHorasTrabajo(horasTrabajo);
            getListaEmpleados().add(empleado);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Empleado obtenerEmpleado(String cedula) {
        Empleado empleadoEncontrado = null;
        for (Empleado empleado : getListaEmpleados()) {
            if (empleado.getCedula().equalsIgnoreCase(cedula)){
                empleadoEncontrado = empleado;
                break;
            }
        }

        return empleadoEncontrado;
    }

    @Override
    public boolean actualizarEmpleado(String cedulaActual, String nombreCompleto, String cedula, Sexo sexo, long telefono, String correo, double salario, TipoContrato tipoContrato, int horasTrabajo, String codigoCompra) {
        Empleado empleadoEncontrado = obtenerEmpleado(cedulaActual);
        if(empleadoEncontrado != null){
            empleadoEncontrado.setNombreCompleto(nombreCompleto);
            empleadoEncontrado.setCedula(cedula);
            empleadoEncontrado.setSexo(sexo);
            empleadoEncontrado.setTelefono(telefono);
            empleadoEncontrado.setCorreo(correo);
            empleadoEncontrado.setSalario(salario);
            empleadoEncontrado.setTipoContrato(tipoContrato);
            empleadoEncontrado.setHorasTrabajo(horasTrabajo);
            getListaEmpleados().add(empleadoEncontrado);

            return true;
        }else{
            return false;
        }
    }

    @Override
    public void eliminarEmpleado(String cedula) {
        Empleado empleadoEncontrado = obtenerEmpleado(cedula);
        if (empleadoEncontrado != null){
            System.out.println("El empleado fue eliminado.");
            getListaEmpleados().remove(empleadoEncontrado);
        }else{
            System.out.println("El empleado no pudo ser eliminado.");
        }
    }

    public void buscarEmpleado(String cedula) {
        Empleado empleadoEncontrado = obtenerEmpleado(cedula);
        if(empleadoEncontrado != null){
            System.out.println("El empleado fue encontrado con éxito.");
            System.out.println(empleadoEncontrado.toString());
        }else{
            System.out.println("El empleado no fue encontraddo.");
        }
    }

    public Empleado buscarEmpleados(String cedula) {
        for (Empleado empleado : getListaEmpleados()) {
            if (empleado.getCedula().equalsIgnoreCase(cedula)){
                return empleado;
            }
        }
        return null;
    }

    public double obtenerEmpleadoMayorSalario(){
        double empleadoMayorSalario = 0.0;
        for (Empleado empleado : getListaEmpleados()) {
            if (empleado.getSalario() > empleadoMayorSalario){
                empleadoMayorSalario = empleado.getSalario();
            }
            System.out.println("El empleado con más salario es: " + empleadoMayorSalario);
            break;
        }
        return empleadoMayorSalario;
    }

    public int obtenerEmpleadoMayorHorasTrabajo(){
        int empleadoMayorHorasTrabajo = 0;
        for (Empleado empleado : getListaEmpleados()) {
            if (empleado.getHorasTrabajo() > empleadoMayorHorasTrabajo){
                empleadoMayorHorasTrabajo = empleado.getHorasTrabajo();
            }
            System.out.println("El empleado con más horas de trabajo son: "+ empleadoMayorHorasTrabajo);
            break;
        }
        return empleadoMayorHorasTrabajo;
    }

    @Override
    public boolean crearProducto(String nombre, String referencia, TipoCliente tipoCliente, TipoProducto tipoProducto, Talla talla, Color color, double precio, int cantidadDisponible, int numeroDetalle) {
        if (buscarProductos(referencia) == null) {
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setReferencia(referencia);
            producto.setTipoCliente(tipoCliente);
            producto.setTipoProducto(tipoProducto);
            producto.setTalla(talla);
            producto.setColor(color);
            producto.setPrecio(precio);
            producto.setCantidadDisponible(cantidadDisponible);
            getListaProductos().add(producto);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Producto obtenerProducto(String referencia) {
        Producto productoEncontrado = null;
        for (Producto producto : getListaProductos()) {
            if (producto.getReferencia().equalsIgnoreCase(referencia)){
                productoEncontrado = producto;
                break;
            }
        }

        return productoEncontrado;
    }

    @Override
    public boolean actualizarProducto(String referenciaActual, String nombre, String referencia, TipoCliente tipoCliente, TipoProducto tipoProducto, Talla talla, Color color, double precio, int cantidadDisponible, int numeroDetalle) {
        Producto productoEncontrado = obtenerProducto(referenciaActual);
        if(productoEncontrado != null){
            productoEncontrado.setNombre(nombre);
            productoEncontrado.setReferencia(referencia);
            productoEncontrado.setTipoCliente(tipoCliente);
            productoEncontrado.setTipoProducto(tipoProducto);
            productoEncontrado.setTalla(talla);
            productoEncontrado.setColor(color);
            productoEncontrado.setPrecio(precio);
            productoEncontrado.setCantidadDisponible(cantidadDisponible);

            return true;
        }else{
            return false;
        }
    }

    @Override
    public void eliminarProducto(String referencia) {
        Producto productoEncontrado = obtenerProducto(referencia);
        if (productoEncontrado != null){
            System.out.println("El producto fue eliminado.");
            getListaProductos().remove(productoEncontrado);
        }else{
            System.out.println("El producto no pudo ser eliminado.");
        }
    }

    public boolean buscarProducto(String referencia) {
        Producto productoEncontrado = obtenerProducto(referencia);
        if(productoEncontrado != null){
            System.out.println("El producto fue encontrado con éxito.");
            System.out.println(productoEncontrado.toString());
            return true;
        }else{
            System.out.println("El producto no fue encontraddo.");
            return false;
        }
    }

    public Producto buscarProductos(String referencia) {
        for (Producto producto : getListaProductos()) {
            if (producto.getReferencia().equalsIgnoreCase(referencia)){
                return producto;
            }
        }
        return null;
    }

    public int obtenerCantidadProducto(){
        int cantidadProducto = 0;
        for (Producto producto : getListaProductos()) {
            if (producto.getCantidadDisponible() > cantidadProducto){
                cantidadProducto = producto.getCantidadDisponible();
            }
            System.out.println("El producto con más stock disponible tiene un total de: " + cantidadProducto + " prendas.");
            break;
        }
        return cantidadProducto;
    }

    public double obtenerProductoMasCostoso(){
        double productoMasCostoso = 0.0;
        for (Producto producto : getListaProductos()) {
            if(producto.getPrecio() > productoMasCostoso){
                productoMasCostoso = producto.getPrecio();
            }
            System.out.println("El producto más costoso tiene un precio de: ");
            break;
        }
        return productoMasCostoso;
    }

    @Override
    public boolean crearCompra(String codigoCompra, Date fechaCompra, double totalCompra, String cedulaCliente, String cedulaEmpleado) {
        if (buscarCompra(codigoCompra) == null) {
            Cliente cliente = obtenerCliente(cedulaCliente);
            Empleado empleado = obtenerEmpleado(cedulaEmpleado);
            if (cliente == null || empleado == null){
                return false;
            }else{
                Compra compra = new Compra();
                compra.setCodigoCompra(codigoCompra);
                compra.setFechaCompra(fechaCompra);
                compra.setTotalCompra(totalCompra);
                compra.setClienteAsociado(cliente);
                compra.setEmpleadoAsociado(empleado);
                getListaCompras().add(compra);
                return true;
            }
        }else {
            return false;
        }
    }

    @Override
    public Compra obtenerCompra(String codigoCompra) {
        Compra compraEncontrada = null;
        for (Compra compra : getListaCompras()) {
            if (compra.getCodigoCompra().equalsIgnoreCase(codigoCompra)){
               compraEncontrada = compra;
                break;
            }
        }

        return compraEncontrada;
    }

    @Override
    public boolean actualizarCompra(String codigoCompraActual, String codigoCompra, Date fechaCompra, double totalCompra, String cedulaCliente, String cedulaEmpleado) {
//        Empleado empleadoAsociado;
//        Cliente clienteAsociado;
//
//        if (obtenerCompra(codigoCompra) == null || codigoCompra == codigoCompraActual){
//            empleadoAsociado = obtenerEmpleado(cedulaEmpleado);
//            clienteAsociado = obtenerCliente(cedulaCliente);
//
//            if (empleadoAsociado == null || clienteAsociado == null){
//                return false;
//
//            }else{
//                Compra compra = obtenerCompra(codigoCompra);
//                compra.setCodigoCompra(codigoCompra);
//                compra.setFechaCompra(fechaCompra);
//                compra.setTotalCompra(totalCompra);
//                compra.setClienteAsociado(clienteAsociado);
//                compra.setEmpleadoAsociado(empleadoAsociado);
//                return true;
//            }
//        }else{
//            return false;
//        }
        return false;
    }

    @Override
    public void eliminarCompra(String codigoCompra) {
        Compra compraEncontrada = obtenerCompra(codigoCompra);
        if (compraEncontrada != null){
            System.out.println("La compra fue eliminada.");
            getListaProductos().remove(compraEncontrada);
        }else{
            System.out.println("La compra no pudo ser eliminada.");
        }
    }

    public Compra buscarCompra(String codigoCompra){
        for (Compra compra : getListaCompras()) {
            if (compra.getCodigoCompra().equalsIgnoreCase(codigoCompra)){
                return compra;
            }
        }
        return null;
    }


    @Override
    public boolean crearDetalleCompra(int numeroDetalle, String productoComprado, int cantidadCompra, double valorUnidad, double valorTotal, String codigoCompra, String referencia) {
        Producto producto = obtenerProducto(referencia);
        if (producto == null){
            return false;
        }

        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setNumeroDetalle(numeroDetalle);
        detalleCompra.setProductoComprado(productoComprado);
        detalleCompra.setCantidadComprado(cantidadCompra);
        detalleCompra.setValorUnidad(valorUnidad);
        detalleCompra.setValorTotal(valorTotal);
        detalleCompra.setProductoAsociado(producto);

        getListaDetalleCompra().add(detalleCompra);

        return true;

    }

    /* Método para mostrar una prenda por la referencia */
    @Override
    public Producto mostrarProducto(String referencia) {
        Producto productoEncontrado = null;
        for (Producto producto : getListaProductos()) {
            if (producto.getReferencia().equalsIgnoreCase(referencia)) {
                productoEncontrado = producto;
                System.out.println(producto.toString());
                break;
            }
        }
        return productoEncontrado;
    }

    public List<Cliente> obtenerClientes() {
        return getListaClientes();
    }

    public List<Empleado> obtenerEmpleados() {
        return getListaEmpleados();
    }

    public List<Producto> obtenerProductos() {
        return getListaProductos();
    }

    public void mostrarInformacionClientes(){
        for (Cliente cliente : getListaClientes()) {
            System.out.println(cliente.toString());
        }
    }
    public void mostrarInformacionEmpleados(){
        for (Empleado empleado : getListaEmpleados()) {
            System.out.println(empleado.toString());
        }
    }

    public void mostrarInformacionProductos(){
        for (Producto producto : getListaProductos()) {
            System.out.println(producto.toString());
        }
    }

    public void crearDetalleCompra(Compra compra, Producto producto, int numeroDetalle, String productoComprado, int cantidadComprado, double valorUnidad, double valorTotal, String referenciaProducto) {
        if (producto != null && (producto.getCantidadDisponible() - cantidadComprado) > 0){
            int cantidadActual = producto.getCantidadDisponible();
            producto.setCantidadDisponible(cantidadActual-cantidadComprado);
            DetalleCompra detalleCompra = new DetalleCompra();
            detalleCompra.setNumeroDetalle(numeroDetalle);
            detalleCompra.setProductoComprado(productoComprado);
            detalleCompra.setCantidadComprado(cantidadComprado);
            detalleCompra.setValorUnidad(valorUnidad);
            detalleCompra.setValorTotal(valorTotal);
            detalleCompra.setProductoAsociado(producto);
            compra.getListaDetalleCompra().add(detalleCompra);
            detalleCompra.setOwnedByCompra(compra);
        }
    }
}
