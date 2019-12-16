
package com.sc202.proyectofinal4;

public class Tours {
    private int id;
    private String nombre;
    private String duracion;
    private String destino;
    private int costo;
    private int registrados;
    private int cupos;
    private boolean disponible;

    public Tours() {
    }

    public Tours(int id, String nombre, String duracion, String destino, int costo, int registrados, int cupos, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.destino = destino;
        this.costo = costo;
        this.registrados = registrados;
        this.cupos = cupos;
        this.disponible = disponible;
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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getRegistrados() {
        return registrados;
    }

    public void setRegistrados(int registrados) {
        this.registrados = registrados;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    @Override
    public String toString() {
        return id + ")\n - Actividad: " + nombre 
                + "\n - Duracion: " + duracion 
                + "\n - Destino: " + destino 
                + "\n - Costo: " + costo;
    }
}