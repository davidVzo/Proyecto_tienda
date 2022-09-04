/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Usuario
 */
public class Venta {

    private int idVenta;
    private int idUsuario_v;
    private String fechaVenta;
    private double subtotal;
    private double descuento;
    private double total;
    
    //constructores

    public Venta() {
    }

    public Venta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(int idUsuario_v, String fechaVenta, double subtotal, double descuento, double total) {
        this.idUsuario_v = idUsuario_v;
        this.fechaVenta = fechaVenta;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
    }

    public Venta(int idVenta, int idUsuario_v, String fechaVenta, double subtotal, double descuento, double total) {
        this.idVenta = idVenta;
        this.idUsuario_v = idUsuario_v;
        this.fechaVenta = fechaVenta;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
    }
    //metodos

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdUsuario_v() {
        return idUsuario_v;
    }

    public void setIdUsuario_v(int idUsuario_v) {
        this.idUsuario_v = idUsuario_v;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", idUsuario_v=" + idUsuario_v + ", fechaVenta=" + fechaVenta + ", subtotal=" + subtotal + ", descuento=" + descuento + ", total=" + total + '}';
    }
    

}
