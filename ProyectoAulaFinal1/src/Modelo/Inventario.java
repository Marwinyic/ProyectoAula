
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Inventario {
    public ArrayList<Producto> productos;
    public double ganancias;

    public Inventario() {
        productos = new ArrayList<>();
        ganancias = 0.0;
    }
    public ArrayList<Producto> getListaProductos() {
        return productos;
    }
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.productos = listaProductos;
    }

    public void agregar(Producto p) {
        productos.add(p);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) return p;
        }
        return null;
    }
    public boolean eliminarProducto(int id) {
        Producto p = buscarPorId(id);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }

    public boolean venderProducto(int id, int cantidad) {
        Producto p = buscarPorId(id);
        if (p != null && p.getCantidad() >= cantidad) {
            p.setCantidad(p.getCantidad() - cantidad);
            ganancias += cantidad * p.getPrecio();
            return true;
        }
        return false;
    }
    

    public double getGanancias() {
        return ganancias;
    }
    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }

}
