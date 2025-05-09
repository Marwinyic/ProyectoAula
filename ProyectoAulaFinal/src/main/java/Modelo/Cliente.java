/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Cliente extends Persona {
    private static final long serialVersionUID = 1L;
    
    public Cliente(int id, String nombre) {
        super(id, nombre); 
    }
    @Override
    public String toString() {
        return "Cliente - " + super.toString();
    }
}