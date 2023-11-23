package co.edu.uniquindio.tiendaDeRopa.Dto;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.MetodoPago;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Sexo;

import java.util.Date;

public record ClienteDto(String nombreCompleto, String cedula, Sexo sexo, long telefono, int prendasCompradas, Date fechaUltimaCompra, MetodoPago metodoPago) {
}
