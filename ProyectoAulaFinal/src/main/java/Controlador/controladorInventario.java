
package Controlador;
import Modelo.Cliente;
import Modelo.Empleado;
import javax.swing.table.DefaultTableModel;
import Modelo.Producto;
import Modelo.Inventario;
import com.mycompany.hola.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class controladorInventario {
    private List<Modelo.Cliente> listac;
    private List<Modelo.Empleado>listae;

    
    public Inventario inventario = new Inventario();
    public DefaultTableModel tableModel;
    public JTable table;
    public Principal vista;

    
    public controladorInventario(Principal vista) {
        this.listac = new ArrayList<>();
        this.listae = new ArrayList<>();
        this.vista = vista;
    }
    
    public  void agregarProducto() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID del producto:"));
        String nombre = JOptionPane.showInputDialog("Nombre del producto:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));

        Producto nuevo = new Producto(id, nombre, precio, cantidad);
        inventario.agregar(nuevo);
        JOptionPane.showMessageDialog(null, "Producto agregado.");
        vista.actualizarTabla(inventario.getProductos());

    }

    public void editarProducto() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID del producto a editar:"));
        Producto p = inventario.buscarPorId(id);
        if (p != null) {
            String nombre = JOptionPane.showInputDialog("Nuevo nombre:", p.getNombre());
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:", p.getPrecio()));
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Nueva cantidad:", p.getCantidad()));
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCantidad(cantidad);
            vista.actualizarTabla(inventario.getProductos());
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        }
    }

    public void buscarProducto() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID a buscar:"));
        Producto p = inventario.buscarPorId(id);
        if (p!= null) {
            JOptionPane.showMessageDialog(null,"Producto encontrado: \n" + p);
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        }
    }

    public void venderProducto() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID del producto:"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a vender:"));
        boolean vendido = inventario.venderProducto(id, cantidad);
        if (vendido) {
            JOptionPane.showMessageDialog(null, "Venta exitosa.");
            vista.actualizarTabla(inventario.getProductos());
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la venta.");
        }
    }
    public void registrarEmpleado() {
        int idper = Integer.parseInt(JOptionPane.showInputDialog("ID del producto:"));
        String nombreper = JOptionPane.showInputDialog("Nombre del producto:");
        Modelo.Empleado nuevoEmpleado = new Modelo.Empleado(idper, nombreper );
        listae.add(nuevoEmpleado);
        JOptionPane.showMessageDialog(null, "Empleado registrado exitosamente.");
    }
    public void registrarCliente() {
        int idper = Integer.parseInt(JOptionPane.showInputDialog("ID del producto:"));
        String nombreper = JOptionPane.showInputDialog("Nombre del producto:");
        Modelo.Cliente nuevoCliente = new Modelo.Cliente(idper, nombreper);
        listac.add(nuevoCliente);
        JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente.");
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
            if (input == null) throw new Exception("Cancelado");
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingresa un número entero válido.");
            }
        }
    }

    private double pedirDecimal(String mensaje) throws Exception {
        while (true) {
            String input = JOptionPane.showInputDialog(mensaje);
            if (input == null) throw new Exception("Cancelado");
            try {
                return Double.parseDouble(input);
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
}



