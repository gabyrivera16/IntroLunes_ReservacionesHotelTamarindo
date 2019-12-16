
package com.sc202.proyectofinal4;

public class RentaVehiculo {
    private int id;
    private Vehiculo vehiculo;
    private int horas;
    private int totalPagar;

    public RentaVehiculo() {
    }

    public RentaVehiculo(int id, Vehiculo vehiculo, int horas, int totalPagar) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.horas = horas;
        this.totalPagar = totalPagar;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "\n - Vehiculo: " + vehiculo.getMarca() + " " + vehiculo.getModelo() 
             + "\n - Horas: " + horas 
             + "\n - Total a Pagar por la renta: " + totalPagar;
    }
 
}
