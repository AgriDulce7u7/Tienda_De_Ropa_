package co.edu.uniquindio.tiendaDeRopa.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
    private String codigoCompra;
    private Date fechaCompra;
    private double totalCompra;
    private Empleado empleadoAsociado;
    private Cliente clienteAsociado;

    List<DetalleCompra> listaDetalleCompra = new ArrayList<>();

    Tienda ownedByTienda;

    /* Constructor */
    public Compra() {
    }

    /* Getters and Setters */
    public String getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(String codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Empleado getEmpleadoAsociado() {
        return empleadoAsociado;
    }

    public void setEmpleadoAsociado(Empleado empleadoAsociado) {
        this.empleadoAsociado = empleadoAsociado;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    public List<DetalleCompra> getListaDetalleCompra() {
        return listaDetalleCompra;
    }

    public void setListaDetalleCompra(List<DetalleCompra> listaDetalleCompra) {
        this.listaDetalleCompra = listaDetalleCompra;
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setOwnedByTienda(Tienda ownedByTienda) {
        this.ownedByTienda = ownedByTienda;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "Código Compra = " + codigoCompra + '\'' +
                ", Fecha Compra = " + fechaCompra + '\'' +
                ", Total de la Compra = " + totalCompra + '\'' +
                '}';
    }

    public void crearDetalleCompra(int numeroDetalle, String productoComprado, int cantidadComprado, double valorUnidad, double valorTotal, Producto ProductoAsosiado) {
        Producto producto = ownedByTienda.buscarProducto(productoAsociado);
        LocalDate fechaConvertida;
        if (producto!=null && (producto.getStockAlmacen()-cantidad)>0){
            try {
                int cantidadActual = producto.getStockAlmacen();
                producto.setStockAlmacen(cantidadActual-cantidad);
                fechaConvertida = LocalDate.parse(fechaCompra, formato);
                this.detalleVenta = new DetalleVenta();
                this.detalleVenta.setCantidad(cantidad);
                this.detalleVenta.setFechaCompra(fechaConvertida);
                this.detalleVenta.setProductoAsociado(producto);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Algo ha salido mal con la fecha, inténtelo nuevamente", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Revise e id del producto, este no fue encontrado o el stock no esta disponible");
        }

    }
}
