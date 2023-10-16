package co.edu.uniquindio.tiendaDeRopa.Model;

public class Compra {
    private String codigoCompra;
    private String fechaCompra;

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

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
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
                "Código Compra =" + codigoCompra + '\'' +
                ", Fecha Compra =" + fechaCompra + '\'' +
                '}';
    }
}
