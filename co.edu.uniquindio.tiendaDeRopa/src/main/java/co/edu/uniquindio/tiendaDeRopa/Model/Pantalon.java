package co.edu.uniquindio.tiendaDeRopa.Model;

public class Pantalon extends Producto{
    /* Constructor */
    public Pantalon() {
    }
    private final double DESCUENTO = 0.05;

    @Override
    public double calcularPrecio() {
        double precioBase = super.calcularPrecio();
        double precioDescuento = precioBase - (precioBase * DESCUENTO);
        return precioDescuento;

    }
}
