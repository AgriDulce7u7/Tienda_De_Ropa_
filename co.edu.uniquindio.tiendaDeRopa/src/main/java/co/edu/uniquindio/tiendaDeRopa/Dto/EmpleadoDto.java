package co.edu.uniquindio.tiendaDeRopa.Dto;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Sexo;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.TipoContrato;

import java.util.Date;

public record EmpleadoDto(String nombreCompleto, String cedula, Sexo sexo, long telefono, String correo, double salario, TipoContrato tipoContrato, int horasTrabajo) {
}
