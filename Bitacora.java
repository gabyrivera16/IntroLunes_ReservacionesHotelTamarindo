
package com.sc202.proyectofinal4;

import static com.sc202.proyectofinal4.Reserva.obtenerCliente;

public class Bitacora {
    private int registro;
    private int idCliente;
    private String servicio;
    private int costo;
    

    public Bitacora() {
    }

    public Bitacora(int registro, int idCliente, String servicio, int costo) {
        this.registro = registro;
        this.idCliente = idCliente;
        this.servicio = servicio;
        this.costo = costo;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
    @Override
    public String toString() {
        return "Registro: " + registro 
                + " - Cliente: " + obtenerCliente(idCliente) 
                + " - Servicio: " + servicio 
                + " - Costo: " + costo;
    }
}
