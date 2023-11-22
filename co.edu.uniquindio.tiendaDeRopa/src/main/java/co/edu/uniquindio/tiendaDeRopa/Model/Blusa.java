package co.edu.uniquindio.tiendaDeRopa.Model;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.TipoBlusa;

public class Blusa extends Producto{

    private TipoBlusa tipoBlusa;
    private final double DESCUENTO = 0.15;

    /* Constructor */
    public Blusa() {
    }

    /* Getters and setters*/

    public TipoBlusa getTipoBlusa() {
        return tipoBlusa;
    }

    public void setTipoBlusa(TipoBlusa tipoBlusa) {
        this.tipoBlusa = tipoBlusa;
    }

    @Override
    public double calcularPrecio() {
        double precioBase = super.calcularPrecio();
        double precioDescuento = 0.0;
        if (tipoBlusa == TipoBlusa.CROP_TOP){
            precioDescuento = precioBase - (precioBase * DESCUENTO);
        }
        else {
            precioDescuento = precioBase;
        }
        return  precioDescuento;
    }
}
