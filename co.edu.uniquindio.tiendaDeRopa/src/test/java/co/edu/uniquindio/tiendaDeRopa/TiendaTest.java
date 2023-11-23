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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TiendaTest {
    Tienda tienda;
    Producto producto;

    @BeforeEach
    void init() {
        tienda = new Tienda();
        producto = new Producto("Blusa", "Crop213",
                TipoCliente.MUJER, TipoProducto.IMPORTADO, Talla.S, Color.LILA,
                30000, 15);
        tienda.getListaProductos().add(producto);
    }

    @Test
    public void testCrearProducto() {

        assertEquals(producto , tienda.obtenerProducto("Crop213"));
    }

    @Test
    public void testActualizarProducto() {

        tienda.actualizarProducto("Crop213", "Blusa", "Crop213",
                TipoCliente.MUJER, TipoProducto.IMPORTADO, Talla.M, Color.AZUL,
                30000, 15, 1);

        assertEquals(Color.AZUL , tienda.obtenerProducto("Crop213").getColor());
    }

    @Test
    public void testBuscarProducto() {

        assertTrue(tienda.buscarProducto("Crop213"));
    }

    @Test
    public void testEliminarProducto() {

        tienda.eliminarProducto("Crop213");

        assertFalse(tienda.buscarProducto("Crop213"));
    }

}
