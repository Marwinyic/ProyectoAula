
package Controlador;
import javax.swing.table.DefaultTableModel;
import Vista.Principal;

import java.util.*;
import javax.swing.JTable;
import javax.swing.*;
import Modelo.*;
import java.io.*;

public class controladorInventario {
    private List<Modelo.Cliente> listac;
    private List<Modelo.Empleado>listae;

    
    public Inventario inventario = new Inventario();
    public DefaultTableModel tableModel;
    public JTable table;
    public Principal vista;
    
    public controladorInventario(Principal vista) {
        EstadoSistema estado = ArchivoSistema.leerEstado();
        this.inventario.setListaProductos(estado.getProductos());
        this.inventario.setGanancias(estado.getGanancias());
        this.listac = estado.getClientes();
        this.listae = estado.getEmpleados();
        this.vista = vista;
    }
    
    
    
    public void agregarProducto() {
        try {
            int id = pedirEntero("ID del producto:");
        
            if (existeProductoConId(id)) {
                JOptionPane.showMessageDialog(null, "Error: Ya existe un producto con este ID.");
                return;
            }
            String nombre = pedirTexto("Nombre del producto:");
            double precio = pedirDecimal("Precio:");
            int cantidad = pedirEntero("Cantidad:");

            Producto nuevo = new Producto(id, nombre, precio, cantidad);
            inventario.agregar(nuevo);
            ArchivoSistema.guardarEstado(inventario, listac, listae);         
            JOptionPane.showMessageDialog(null, "Producto agregado.");
            vista.actualizarTabla(inventario.getListaProductos());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Operación cancelada o datos inválidos.");
        }
    }
    public void eliminarProducto() {
        try {
            int id = pedirEntero("ID del producto a eliminar:");
            Producto producto = inventario.buscarPorId(id);
        
            if (producto != null) {
                int confirmacion = JOptionPane.showConfirmDialog(
                    null, 
                    "¿Está seguro de eliminar el siguiente producto?\n\n" +
                    "ID: " + producto.getId() + "\n" +
                    "Nombre: " + producto.getNombre() + "\n" +
                    "Precio: $" + producto.getPrecio() + "\n" +
                    "Cantidad: " + producto.getCantidad(),
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    boolean eliminado = inventario.eliminarProducto(id);
                    if (eliminado) {
                        ArchivoSistema.guardarEstado(inventario, listac, listae);
                        vista.actualizarTabla(inventario.getListaProductos());
                        JOptionPane.showMessageDialog(null, 
                            "Producto eliminado correctamente.",
                            "Eliminación exitosa",
                            JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, 
                         "Eliminación cancelada.",
                         "Operación cancelada",
                         JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, 
                "No se encontró un producto con ese ID.",
                "Producto no encontrado",
                JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
            "Operación cancelada o ID inválido: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
        }
    } 

    public void editarProducto() {
        try {
            int id = pedirEntero("ID del producto a editar:");
            Producto p = inventario.buscarPorId(id);
            if (p != null) {
                String nombre = pedirTexto("Nuevo nombre:");
                double precio = pedirDecimal("Nuevo precio:");
                int cantidad = pedirEntero("Nueva cantidad:");
                p.setNombre(nombre);
                p.setPrecio(precio);
                p.setCantidad(cantidad);
                ArchivoSistema.guardarEstado(inventario, listac, listae);
                vista.actualizarTabla(inventario.getListaProductos());
                JOptionPane.showMessageDialog(null, "Producto editado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Operación cancelada o datos inválidos.");
        }
    }

    public void buscarProducto() {
        try {
            int id = pedirEntero("ID a buscar:");
            Producto p = inventario.buscarPorId(id);
            if (p != null) {
                JOptionPane.showMessageDialog(null, "Producto encontrado:\n" + p);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Búsqueda cancelada o ID inválido.");
        }
    }

    public void venderProducto() {
        try {
            int id = pedirEntero("ID del producto:");
            int cantidad = pedirEntero("Cantidad a vender:");
            boolean vendido = inventario.venderProducto(id, cantidad);
            if (vendido) {
                ArchivoSistema.guardarEstado(inventario, listac, listae);

                JOptionPane.showMessageDialog(null, "Venta exitosa.");
                vista.actualizarTabla(inventario.getListaProductos());
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la venta.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Operación cancelada o datos inválidos.");
        }
    } 
    public void registrarEmpleado() {
    try {
        int id = pedirEntero("ID del empleado:");
        if (existeEmpleadoConId(id)) {
            JOptionPane.showMessageDialog(null, "Error: Ya existe un Empleado con este ID.");
            return;
        }
        String nombre = pedirTexto("Nombre del empleado:");
        Persona nuevo = new Empleado(id, nombre);
        listae.add((Empleado) nuevo);
        ArchivoSistema.guardarEstado(inventario, listac, listae);
        JOptionPane.showMessageDialog(null, "Registro exitoso.");
    } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro cancelado o datos inválidos.");
        }
    }
    public void registrarCliente() {
    try {
        int id = pedirEntero("ID del cliente:");
        if (existeEmpleadoConId(id)) {
            JOptionPane.showMessageDialog(null, "Error: Ya existe un Empleado con este ID.");
            return;
        }
        String nombre = pedirTexto("Nombre del cliente:");
        Persona nuevo = new Cliente(id, nombre);
        listac.add((Cliente) nuevo);
        ArchivoSistema.guardarEstado(inventario, listac, listae);
        JOptionPane.showMessageDialog(null, "Registro exitoso.");

    } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro cancelado o datos inválidos.");
        }
    }
    public void eliminarCliente() {
    try {
        int id = pedirEntero("ID del cliente a eliminar:");
        
        Cliente clienteAEliminar = null;
        for (Cliente c : listac) {
            if (c.getId() == id) {
                clienteAEliminar = c;
                break;
            }
        }
        
        if (clienteAEliminar != null) {
            int confirmacion = JOptionPane.showConfirmDialog(
                null, 
                "¿Está seguro de eliminar al cliente?\n" + clienteAEliminar,
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                listac.remove(clienteAEliminar);
                ArchivoSistema.guardarEstado(inventario, listac, listae);
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un cliente con ese ID.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Operación cancelada o ID inválido.");
    }
}

public void eliminarEmpleado() {
    try {
        int id = pedirEntero("ID del empleado a eliminar:");
        
        Empleado empleadoAEliminar = null;
        for (Empleado e : listae) {
            if (e.getId() == id) {
                empleadoAEliminar = e;
                break;
            }
        }
        
        if (empleadoAEliminar != null) {
            int confirmacion = JOptionPane.showConfirmDialog(
                null, 
                "¿Está seguro de eliminar al empleado?\n" + empleadoAEliminar,
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                listae.remove(empleadoAEliminar);
                ArchivoSistema.guardarEstado(inventario, listac, listae);
                JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un empleado con ese ID.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Operación cancelada o ID inválido.");
    }
}
    
    

    public void mostrarGanancias() {
        JOptionPane.showMessageDialog(null, "Ganancias acumuladas: $" + inventario.getGanancias());
    }
    public List<Cliente> getListaClientes() {
        return listac;
    }
    public List<Empleado> getListaEmpleados() {
        return listae;
    }
    private int pedirEntero(String mensaje) throws Exception {
        while (true) {
            String input = JOptionPane.showInputDialog(mensaje);
            if (input == null) throw new RuntimeException("Cancelado");
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingresa un número entero válido.");
            }
        }
    }

    private double pedirDecimal(String mensaje) throws Exception {
        while (true) {
            String input = JOptionPane.showInputDialog(mensaje);
            if (input == null) throw new RuntimeException("Cancelado");
            try {
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingresa un número decimal válido.");
            }
        }
    }

    private String pedirTexto(String mensaje) throws Exception {
        while (true) {
            String input = JOptionPane.showInputDialog(mensaje);
            if (input == null) throw new Exception("Cancelado");
            if (!input.trim().isEmpty()) return input.trim();
            JOptionPane.showMessageDialog(null, "El campo no puede estar vacío.");
        }
    }
    private boolean existeProductoConId(int id) {
        return inventario.buscarPorId(id) != null;
    }
    private boolean existeClienteConId(int id) {
        return listac.stream().anyMatch(c -> c.getId() == id);
    }
    private boolean existeEmpleadoConId(int id) {
        return listae.stream().anyMatch(c -> c.getId() == id);
    }
    public void mostrarGananciasIniciales() {
        System.out.println("Ganancias cargadas: $" + inventario.getGanancias());
    }
    



}



