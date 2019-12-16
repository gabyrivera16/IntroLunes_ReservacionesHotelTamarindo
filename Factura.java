
package com.sc202.proyectofinal4;

import static com.sc202.proyectofinal4.Reserva.obtenerCliente;

public class Factura {
    private int idFactura;
    private int idCliente;
    private String idHabitacion;
    private int cantDias;
    private int extras;
    private int monto;
    private String metodoDePago;

    public Factura() {
    }

    public Factura(int idFactura, int idCliente, String idHabitacion, int cantDias, int extras, int monto, String metodoDePago) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.idHabitacion = idHabitacion;
        this.cantDias = cantDias;
        this.extras = extras;
        this.monto = monto;
        this.metodoDePago = metodoDePago;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }
    
    @Override
    public String toString() {
        return "Id Factura: " + idFactura 
                + "\n   - Cliente: " + obtenerCliente(idCliente) 
                + "\n   - Número de Habitación: " + idHabitacion 
                + "\n   - Cantidad de Noches: " + cantDias 
                + "\n   - Monto a pagar: " + monto
                + "\n   - Metodo de pago: " + metodoDePago;
    }
}