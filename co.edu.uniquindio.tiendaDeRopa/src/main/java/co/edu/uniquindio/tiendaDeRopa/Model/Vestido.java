package co.edu.uniquindio.tiendaDeRopa.Model;

public class Vestido extends Producto{
    private final double IMPUESTO = 0.19;

    /* Constructor */
    public Vestido() {
    }

    @Override
    public double calcularPrecio() {
        double precioImpuesto = 0.0;
        precioImpuesto = getPrecio() * IMPUESTO;
        return precioImpuesto;
    }
}
