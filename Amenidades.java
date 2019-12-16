
package com.sc202.proyectofinal4;

public class Amenidades {
    private int id;
    private String nombre;
    private int costo;

    public Amenidades() {
    }

    public Amenidades(int id, String nombre, int costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    
    @Override
    public String toString() {
        return id +")\n - Amenidad: " + nombre + "\n - Costo: " + costo;
    }    
}// fin clase
