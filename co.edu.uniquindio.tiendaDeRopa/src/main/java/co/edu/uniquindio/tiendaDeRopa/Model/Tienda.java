package co.edu.uniquindio.tiendaDeRopa.Model;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Sexo;
import co.edu.uniquindio.tiendaDeRopa.Service.ITienda;

import java.util.ArrayList;
import java.util.List;

public class Tienda implements ITienda {
    private  String nombre;
    List<Cliente> listaClientes = new ArrayList<>();
    List<Empleado> listaEmpleado = new ArrayList<>();
    List<Compra> listaCompras = new ArrayList<>();
    List<Producto> listaProductos = new ArrayList<>();

    /*Constructor*/
    public Tienda() {
    }

    /*Getters and Setters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "Nombre = " + nombre + '\'' +
                '}';
    }

    /**
     * Método para crear un cliente
     */
    public boolean crearCliente(String nombreCompleto, String cedula, Sexo sexo, int prendasCompradas, String fechaUltimaCompra){
        Cliente cliente = new Cliente();
        cliente.setNombreCompleto(nombreCompleto);
        cliente.setCedula(cedula);
        cliente.setSexo(sexo);
        cliente.setPrendasCompradas(prendasCompradas);
        cliente.setFechaUltimaCompra(fechaUltimaCompra);
        getListaClientes().add(cliente);

        return true;
    }

    /**
     * Método para obtener la lista de todos los clientes
     * @return List<Cliente>
     */
    public List<Cliente> obtenerClientes() {
        return getListaClientes();
    }

    /**
     * Método para actualizar un cliente por medio de la cedula
     * */
    public void actualizarCliente(String cedula,String nuevoNombreCompleto, Sexo nuevoSexo, int nuevaPrendasCompradas, String nuevoFechaUltimaCompra) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setNombreCompleto(nuevoNombreCompleto);
                cliente.setSexo(nuevoSexo);
                cliente.setPrendasCompradas(nuevaPrendasCompradas);
                cliente.setFechaUltimaCompra(nuevoFechaUltimaCompra);
                System.out.println("Cliente actualizado exitosamente :"+'\n'+cliente.toString());
                return;
            }
        }
    }

    /**
     * Método para eliminar un cliente por medio de la cedula
     * */
    public void eliminarCliente(String cedula) {
        int tamanioLista = getListaClientes().size();
        for (int i=0; i < tamanioLista; i++){
            Cliente cliente = getListaClientes().get(i);
            if(cliente.getCedula().equalsIgnoreCase(cedula)){
                getListaClientes().remove(i);
                break;
            }
        }
    }

    /* Método para mostrar una prenda por la referencia */
    @Override
    public Producto mostrarProducto(String referencia) {
        Producto productoEncontrado = null;
        for (Producto producto : getListaProductos()) {
            if (producto.getReferencia().equalsIgnoreCase(referencia)) {
                productoEncontrado = producto;
                System.out.println(producto.toString());
                break;
            }
        }
        return productoEncontrado;
    }
}
