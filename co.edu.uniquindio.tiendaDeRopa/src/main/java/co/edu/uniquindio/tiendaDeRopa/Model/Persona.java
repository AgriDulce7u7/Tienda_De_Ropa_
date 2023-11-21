package co.edu.uniquindio.tiendaDeRopa.Model;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Sexo;

public abstract class Persona {
    private String nombreCompleto;
    private String cedula;
    private Sexo sexo;
    private long telefono;
    Tienda ownedByTienda;

    /* Constructor */
    public Persona() {
    }

    /* Getters and Setters */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
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
        return "Persona {" +
                "Nombre Completo =" + nombreCompleto + '\'' +
                ", Cédula =" + cedula + '\'' +
                ", Sexo =" + sexo + '\'' +
                ", teléfono =" + telefono + '\'' +
                '}';
    }
}
