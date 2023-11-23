package co.edu.uniquindio.tiendaDeRopa.Model;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Color;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Talla;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.TipoCliente;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.TipoProducto;
import co.edu.uniquindio.tiendaDeRopa.Service.IProducto;

public class Producto implements IProducto {
    private String nombre;
    private String referencia;
    private TipoCliente tipoCliente;
    private TipoProducto tipoProducto;
    private Talla talla;
    private Color color;
    private double precio;
    private int cantidadDisponible;
    Tienda ownedByTienda;
    private final double IMPUESTO = 0.19;
    private final double IMPUESTO_ADICIONAL = 0.03;

    /* Constructor */
    public Producto() {
    }

    /* Getters and Setters */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setOwnedByTienda(Tienda ownedByTienda) {
        this.ownedByTienda = ownedByTienda;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Nombre = " + nombre + '\'' +
                ", Referencia = " + referencia + '\'' +
                ", Tipo Cliente = " + tipoCliente + '\'' +
                ", Talla = " + talla + '\'' +
                ", Color = " + color + '\'' +
                ", Precio = " + precio + '\'' +
                ", Cantidad Disponible = " + cantidadDisponible + '\'' +
                '}';
    }

    @Override
    public double calcularPrecioBase() {
        double precioBase = getPrecio();
        double precioFinal = 0.0;
        if (getTipoProducto() == TipoProducto.IMPORTADO) {
            precioFinal = precioBase + (precioBase * (IMPUESTO + IMPUESTO_ADICIONAL));
        }
        if (getTipoProducto() == TipoProducto.NACIONAL){
            precioFinal = precioBase + (precioBase * IMPUESTO);
        }
        return precioFinal;
    }

    @Override
    public double calcularPrecio() {
        double precio = calcularPrecioBase();
        return precio;
    }
}


