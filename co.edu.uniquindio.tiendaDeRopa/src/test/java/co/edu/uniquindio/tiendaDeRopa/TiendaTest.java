package co.edu.uniquindio.tiendaDeRopa;

import co.edu.uniquindio.tiendaDeRopa.Dto.ProductoDto;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Color;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Talla;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.TipoCliente;
import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.TipoProducto;
import co.edu.uniquindio.tiendaDeRopa.Model.Producto;
import co.edu.uniquindio.tiendaDeRopa.Model.Tienda;
import co.edu.uniquindio.tiendaDeRopa.Model.Vestido;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TiendaTest {

    @Test
    public void testCrearProducto() {
        Tienda tienda = new Tienda();
        Producto producto = new Producto("Blusa", "22",
                TipoCliente.MUJER, TipoProducto.IMPORTADO, Talla.S, Color.LILA,
                30000, 15);


        tienda.getListaProductos().add(producto);
        assertTrue(tienda.buscarProducto("22"));
    }
}
