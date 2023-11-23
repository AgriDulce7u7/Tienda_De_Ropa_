package co.edu.uniquindio.tiendaDeRopa.Dto;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Color;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Talla;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.TipoCliente;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.TipoProducto;
import co.edu.uniquindio.tiendaDeRopa.Model.Tienda;

public record ProductoDto(String nombre,
                          String referencia,
                          TipoCliente tipoCliente,
                          TipoProducto tipoProducto,
                          Talla talla,
                          Color color,
                          double precio,
                          int cantidadDisponible){
}
