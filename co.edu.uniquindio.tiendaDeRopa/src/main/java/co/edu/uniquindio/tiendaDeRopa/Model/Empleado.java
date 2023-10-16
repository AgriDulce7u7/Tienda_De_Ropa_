package co.edu.uniquindio.tiendaDeRopa.Model;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Sexo;

public class Empleado {
    private String nombreCompleto;
    private long numeroIdentificacion;
    private Sexo sexo;
    private String correo;
    private long telefono;
    Tienda ownedByTienda;

    /* Constructor */

    public Empleado() {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setOwnedByTienda(Tienda ownedByTienda) {
        this.ownedByTienda = ownedByTienda;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "Nombre Completo =" + nombreCompleto + '\'' +
                ", Cédula =" + numeroIdentificacion + '\'' +
                ", Sexo =" + sexo + '\'' +
                ", Correo =" + correo + '\'' +
                ", Telefono =" + telefono +'\''+
                '}';
    }
}
