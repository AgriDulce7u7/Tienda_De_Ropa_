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

    @Override
    public boolean crearCompra(String codigoCompra, Date fechaCompra, double totalCompra, String cedulaCliente, String cedulaEmpleado) {
        Cliente cliente = obtenerCliente(cedulaCliente);
        Empleado empleado = obtenerEmpleado(cedulaEmpleado);
        if (cliente == null || empleado == null){
            return false;
        }
        Compra compra = new Compra();
        compra.setCodigoCompra(codigoCompra);
        compra.setFechaCompra(fechaCompra);
        compra.setTotalCompra(totalCompra);
        compra.setClienteAsociado(cliente);
        compra.setEmpleadoAsociado(empleado);
        getListaCompras().add(compra);
        return true;
    }

    @Override
    public Compra obtenerCompra(String codigoCompra) {
        return null;
    }

    @Override
    public boolean actualizarCompra(String codigoCompra, Date fechaCompra, double totalCompra, String cedulaCliente, String cedulaEmpleado) {
        return false;
    }

    @Override
    public void eliminarCompra(String codigoCompra) {
    }

    @Override
    public boolean crearDetalleCompra(int numeroDetalle, String productoComprado, int cantidadCompra, double valorUnidad, double valorTotal, String codigoCompra, String referencia) {
        return false;
    }

    @Override
    public DetalleCompra obtenerDetalleCompra(int numeroDetalle) {
        DetalleCompra detalleCompraEncontrado = null;
        for (DetalleCompra detalleCompra : getListaDetalleCompra()) {
            if (detalleCompra.getNumeroDetalle() == numeroDetalle){
                detalleCompraEncontrado = detalleCompra;
                break;
            }
        }

        return detalleCompraEncontrado;
    }


    @Override
    public boolean actualizarDetalleCompra(int numeroDetalle, String productoComprado, int cantidadCompra, double valorUnidad, double valorTotal, String codigoCompra, String referencia) {
        return false;
    }

    @Override
    public void eliminarDetalleCompra(int numeroDetalle) {
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
}
