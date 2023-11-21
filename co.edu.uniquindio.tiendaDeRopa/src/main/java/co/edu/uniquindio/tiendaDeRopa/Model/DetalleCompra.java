package co.edu.uniquindio.tiendaDeRopa.Model;

public class DetalleCompra {
    private String productoComprado;
    private  int cantidadComprado;
    private double valorUnidad;
    private double valorTotal;
    Compra ownedByCompra;

    /* Constructor */
    public DetalleCompra() {
    }

    /* Getters and Setters */
    public String getProductoComprado() {
        return productoComprado;
    }

    public void setProductoComprado(String productoComprado) {
        this.productoComprado = productoComprado;
    }

    public int getCantidadComprado() {
        return cantidadComprado;
    }

    public void setCantidadComprado(int cantidadComprado) {
        this.cantidadComprado = cantidadComprado;
    }

    public double getValorUnidad() {
        return valorUnidad;
    }

    public void setValorUnidad(double valorUnidad) {
        this.valorUnidad = valorUnidad;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Compra getOwnedByCompra() {
        return ownedByCompra;
    }

    public void setOwnedByCompra(Compra ownedByCompra) {
        this.ownedByCompra = ownedByCompra;
    }
}
