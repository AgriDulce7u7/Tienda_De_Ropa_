package co.edu.uniquindio.tiendaDeRopa.Model;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Sexo;

public class Cliente {
    private String nombreCompleto;
    private long numeroIdentificacion;
    private Sexo sexo;
    private int prendasCompradas;
    private String fechaUltimaCompra;

    Tienda ownedByTienda;

    /* Constructor Vacío */
    public Cliente() {
    }

    /* Getters and Setters */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public long getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(long numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

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

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setOwnedByTienda(Tienda ownedByTienda) {
        this.ownedByTienda = ownedByTienda;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Nombre Completo =" + nombreCompleto + '\'' +
                ", Cédula =" + numeroIdentificacion + '\'' +
                ", Sexo =" + sexo + '\'' +
                ", Prendas Compradas =" + prendasCompradas + '\'' +
                ", Fecha Ultima Compra =" + fechaUltimaCompra +'\''+
                '}';
    }
}

