
package com.sc202.proyectofinal2;


public class Habitacion {
    
private int id;
    private String tipo;
    private int nCamas;
    private boolean disponibilidad;
    private int precioxNoche;

    public Habitacion() {
    }

    public Habitacion(int id, String tipo, int nCamas, boolean disponibilidad, int precioxNoche) {
        this.id = id;
        this.tipo = tipo;
        this.nCamas = nCamas;
        this.disponibilidad = disponibilidad;
        this.precioxNoche = precioxNoche;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getnCamas() {
        return nCamas;
    }

    public void setnCamas(int nCamas) {
        this.nCamas = nCamas;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getPrecioxNoche() {
        return precioxNoche;
    }

    public void setPrecioxNoche(int precioxNoche) {
        this.precioxNoche = precioxNoche;
    }

    
    
}

