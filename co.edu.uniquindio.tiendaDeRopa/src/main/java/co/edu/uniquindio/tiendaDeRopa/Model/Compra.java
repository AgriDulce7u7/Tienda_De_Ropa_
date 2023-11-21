package co.edu.uniquindio.tiendaDeRopa.Model;

import java.util.Date;

public class Compra {
    private String codigoCompra;
    private Date fechaCompra;
    private double totalCompra;

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
}
