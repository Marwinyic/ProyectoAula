package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class EstadoSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Producto> productos;
    private double ganancias;
    private List<Cliente> clientes;  
    private List<Empleado> empleados;

    public EstadoSistema(ArrayList<Producto> productos, double ganancias,List<Cliente> listac, List<Empleado> listae ) {
        this.productos = productos;
        this.ganancias = ganancias;
        this.clientes = listac;
        this.empleados = listae;
    }

    // Getters
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public double getGanancias() {
        return ganancias;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}