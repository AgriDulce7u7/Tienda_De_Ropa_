package co.edu.uniquindio.tiendaDeRopa.Model;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.MetodoPago;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Sexo;

public class Cliente extends Persona{
    private int prendasCompradas;
    private String fechaUltimaCompra;
    private MetodoPago metodoPago;

    Tienda ownedByTienda;

    /* Constructor Vacío */
    public Cliente() {
    }

    /* Getters and Setters */
    public int getPrendasCompradas() {
        return prendasCompradas;
    }

    public void setPrendasCompradas(int prendasCompradas) {
        this.prendasCompradas = prendasCompradas;
    }

    public String getFechaUltimaCompra() {
        return fechaUltimaCompra;
    }

    public void setFechaUltimaCompra(String fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setOwnedByTienda(Tienda ownedByTienda) {
        this.ownedByTienda = ownedByTienda;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "Nombre Completo = " + getNombreCompleto() + '\'' +
                ", Cédula = " + getCedula() + '\'' +
                ", Sexo = " + getSexo() + '\'' +
                ", Prendas Compradas = " + prendasCompradas + '\'' +
                ", Fecha Ultima Compra = " + fechaUltimaCompra +'\''+
                ", Método de pago = " + metodoPago + '\''+
                '}';
    }
}

