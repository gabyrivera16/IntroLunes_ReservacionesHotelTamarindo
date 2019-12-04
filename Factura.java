
package com.sc202.proyectofinal2;


public class Factura {
    
private int idFactura;
    private String Cliente;
    private int idHabitacion;
    private int cantDias;
    private int monto;

    public Factura() {
    }

    public Factura(int idFactura, String Cliente, int idHabitacion, int cantDias, int monto) {
        this.idFactura = idFactura;
        this.Cliente = Cliente;
        this.idHabitacion = idHabitacion;
        this.cantDias = cantDias;
        this.monto = monto;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Id Factura: " + idFactura 
                + "\n   - Cliente: " + Cliente 
                + "\n   - Número de Habitación: " + idHabitacion 
                + "\n   - Cantidad de Noches: " + cantDias 
                + "\n   - Monto a pagar: " + monto;
        
}
    
    
}
