
package com.sc202.proyectofinal4;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellido;
    private int telefono;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String apellido, int telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cedula: " + idCliente 
                + "\n - Nombre: " + nombre 
                + "\n - Apellido: " + apellido 
                + "\n - Telefono: " + telefono;
    }
    
    
}

