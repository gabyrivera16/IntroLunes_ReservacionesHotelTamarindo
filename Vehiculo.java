
package com.sc202.proyectofinal4;

public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String transmision;
    private int costoHora;
    private int capacidad;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String modelo, String transmision, int costoHora, int capacidad) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.transmision = transmision;
        this.costoHora = costoHora;
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public int getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(int costoHora) {
        this.costoHora = costoHora;
    }

    @Override
    public String toString() {
        return "("+placa+") "+marca+" "+modelo+" para "+capacidad+" personas ( " + costoHora +" colones por hora ) ";
    }
    
    
}