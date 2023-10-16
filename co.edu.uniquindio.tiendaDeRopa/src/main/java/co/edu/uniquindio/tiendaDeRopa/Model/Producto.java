package co.edu.uniquindio.tiendaDeRopa.Model;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Color;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Talla;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.TipoCliente;

public class Producto {
    private String tipoProducto;
    private String referencia;
    private TipoCliente tipoCliente;
    private Talla talla;
    private Color color;
    private double precio;
    private int cantidadDisponible;

    Tienda ownedByTienda;

    /* Constructor Vacío */
    public Producto() {
    }

    /* Obtener la información de las prendas */
    public String obtenerInformacion(){
        String informacion = "";
        informacion = informacion +
                "Tipo de Prenda: "+ getTipoProducto()+"\n"+
                "Referencia: "+getReferencia()+"\n"+
                "Tipo de Cliente: "+getTipoCliente()+"\n"+
                "Talla: "+getTalla()+"\n"+
                "Color: "+getColor()+"\n"+
                "Precio: "+getPrecio()+"\n"+
                "Cantidad Disponible: "+getCantidadDisponible()+"\n";

        return informacion;
    }

    /* Getters and Setters */
    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
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
                "Tipo Producto =" + tipoProducto + '\'' +
                ", Referencia =" + referencia + '\'' +
                ", Tipo Cliente =" + tipoCliente + '\'' +
                ", Talla =" + talla + '\'' +
                ", Color =" + color +'\''+
                ", Precio =" + precio +'\''+
                ", Cantidad Disponible =" + cantidadDisponible +'\''+
                '}';
    }
}
