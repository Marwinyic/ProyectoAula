
package Modelo;



public class Empleado extends Persona {
    private static final long serialVersionUID = 1L;
    
    public Empleado(int id, String nombre) {
        super(id, nombre); 
    }
    @Override
    public String toString() {
        return "Empleado - " + super.toString();
    }
}