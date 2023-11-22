package co.edu.uniquindio.tiendaDeRopa.Model;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Color;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Talla;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.TipoCliente;

public class Producto {
    private String nombre;
    private String referencia;
    private TipoCliente tipoCliente;
    private Talla talla;
    private Color color;
    private double precio;
    private int cantidadDisponible;
    Tienda ownedByTienda;

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

    @Override
    public String toString() {
        return "Producto{" +
                "Nombre = " + nombre + '\'' +
                ", Referencia = " + referencia + '\'' +
                ", Tipo Cliente = " + tipoCliente + '\'' +
                ", Talla = " + talla + '\'' +
                ", Color = " + color +'\''+
                ", Precio = " + precio +'\''+
                ", Cantidad Disponible = " + cantidadDisponible +'\''+
                '}';
    }

    public double calcularPrecio() {
        return 0.0;
    }
}
