package co.edu.uniquindio.tiendaDeRopa.Service;

import co.edu.uniquindio.tiendaDeRopa.Model.*;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.*;

import java.util.Date;

public interface ITienda {
    /* CRUD Cliente */
    boolean crearCliente(String nombreCompleto,
                         String cedula,
                         Sexo sexo,
                         long telefono,
                         int prendasCompradas,
                         Date fechaUltimaCompra,
                         MetodoPago metodoPago,
                         String codigoCompra);
    Cliente obtenerCliente(String cedula);
    boolean actualizarCliente(String cedulaActual,
                              String nombreCompleto,
                              String cedula, Sexo sexo,
                              long telefono,
                              int prendasCompradas,
                              Date fechaUltimaCompra,
                              MetodoPago metodoPago,
                              String codigoCompra);
    void eliminarCliente(String cedula);

    /*  CRUD Empleado */
    boolean crearEmpleado(String nombreCompleto,
                          String cedula,
                          Sexo sexo,
                          long telefono,
                          String correo,
                          double salario,
                          TipoContrato tipoContrato,
                          int horasTrabajo,
                          String codigoCompra);
    Empleado obtenerEmpleado(String cedula);
    boolean actualizarEmpleado(String cedulaActual,
                               String nombreCompleto,
                               String cedula,
                               Sexo sexo,
                               long telefono,
                               String correo,
                               double salario,
                               TipoContrato tipoContrato,
                               int horasTrabajo,
                               String codigoCompra);
    void eliminarEmpleado(String cedula);

    /* CRUD Producto */
    boolean crearProducto(String nombre,
                          String referencia,
                          TipoCliente tipoCliente,
                          TipoProducto tipoProducto,
                          Talla talla,
                          Color color,
                          double precio,
                          int cantidadDisponible,
                          int numeroDetalle);
    Producto obtenerProducto(String referencia);
    boolean actualizarProducto(String referenciaActual,
                               String nombre,
                               String referencia,
                               TipoCliente tipoCliente,
                               TipoProducto tipoProducto,
                               Talla talla,
                               Color color,
                               double precio,
                               int cantidadDisponible,
                               int numeroDetalle);
    void eliminarProducto(String referencia);

    /* CRUD Compra */
    boolean crearCompra(String codigoCompra,
                        Date fechaCompra,
                        double totalCompra,
                        String cedulaCliente,
                        String cedulaEmpleado);

    Compra obtenerCompra(String codigoCompra);
    boolean actualizarCompra(String codigoCompraActual,
                             String codigoCompra,
                             Date fechaCompra,
                             double totalCompra,
                             String cedulaCliente,
                             String cedulaEmpleado);
    void eliminarCompra(String codigoCompra);

    /* CRUD Detalle Compra */
    boolean crearDetalleCompra(int numeroDetalle,
                               String productoComprado,
                               int cantidadCompra,
                               double valorUnidad,
                               double valorTotal,
                               String codigoCompra,
                               String referencia);

    Producto mostrarProducto(String referencia);
}
