package co.edu.uniquindio.tiendaDeRopa.Model;

public class Chaqueta extends Producto{
    /* Constructor */
    public Chaqueta() {
    }
    private final double DESCUENTO = 0.08;

    @Override
    public double calcularPrecio() {
        double precioBase = super.calcularPrecio();
        double precioDescuento = precioBase - (precioBase * DESCUENTO);
        return precioDescuento;

    }
}
