package co.edu.uniquindio.tiendaDeRopa.Model;

import co.edu.uniquindio.tiendaDeRopa.Model.Enumeracion.Sexo;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private  String nombre;

    List<Cliente> listaClientes = new ArrayList<>();
    List<Compra> listaCompras = new ArrayList<>();
    List<Empleado> listaEmpleados = new ArrayList<>();
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

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
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
                "Nombre='" + nombre + '\'' +
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
}
