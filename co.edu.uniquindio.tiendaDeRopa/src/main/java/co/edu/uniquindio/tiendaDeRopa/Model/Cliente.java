package co.edu.uniquindio.tiendaDeRopa.Model;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.MetodoPago;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Sexo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Persona{
    private int prendasCompradas;
    private Date fechaUltimaCompra;
    private MetodoPago metodoPago;
    private List<Compra> comprasAsociadas = new ArrayList<>();

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

    public Date getFechaUltimaCompra() {
        return fechaUltimaCompra;
    }

    public void setFechaUltimaCompra(Date fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<Compra> getComprasAsociadas() {
        return comprasAsociadas;
    }

    public void setComprasAsociadas(List<Compra> comprasAsociadas) {
        this.comprasAsociadas = comprasAsociadas;
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

