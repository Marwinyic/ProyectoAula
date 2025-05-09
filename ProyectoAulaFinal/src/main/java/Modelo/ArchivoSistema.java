package Modelo;

import java.io.*;
import java.util.*;

public class ArchivoSistema {
    private static final String FILE_NAME = "sistema.dat";

    public static void guardarEstado(Inventario inventario, 
                                   List<Cliente> clientes, 
                                   List<Empleado> empleados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            EstadoSistema estado = new EstadoSistema(
                inventario.getListaProductos(),
                inventario.getGanancias(),
                clientes,
                empleados
            );
            oos.writeObject(estado);
        } catch (IOException e) {
            System.out.println("Error al guardar el estado del sistema: " + e.getMessage());
        }
    }

    public static EstadoSistema leerEstado() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new EstadoSistema(new ArrayList<>(), 0.0, new ArrayList<>(), new ArrayList<>());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (EstadoSistema) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el estado del sistema: " + e.getMessage());
            return new EstadoSistema(new ArrayList<>(), 0.0, new ArrayList<>(), new ArrayList<>());
        }
    }
}