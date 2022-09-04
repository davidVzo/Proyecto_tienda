/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Usuario
 */
public class DetalleVenta {
    private String codDetalleVenta;
    private int venta_d;
    private String producto_d;
    private int can_vendida;
    private double total;
    
    //constructores

    public DetalleVenta() {
    }

    public DetalleVenta(String codDetalleVenta) {
        this.codDetalleVenta = codDetalleVenta;
    }

    public DetalleVenta(int venta_d, String producto_d, int can_vendida, double total) {
        this.venta_d = venta_d;
        this.producto_d = producto_d;
        this.can_vendida = can_vendida;
        this.total = total;
    }

    public DetalleVenta(String codDetalleVenta, int venta_d, String producto_d, int can_vendida, double total) {
        this.codDetalleVenta = codDetalleVenta;
        this.venta_d = venta_d;
        this.producto_d = producto_d;
        this.can_vendida = can_vendida;
        this.total = total;
    }
    // metodos

    public String getCodDetalleVenta() {
        return codDetalleVenta;
    }

    public void setCodDetalleVenta(String codDetalleVenta) {
        this.codDetalleVenta = codDetalleVenta;
    }

    public int getVenta_d() {
        return venta_d;
    }

    public void setVenta_d(int venta_d) {
        this.venta_d = venta_d;
    }

    public String getProducto_d() {
        return producto_d;
    }

    public void setProducto_d(String producto_d) {
        this.producto_d = producto_d;
    }

    public int getCan_vendida() {
        return can_vendida;
    }

    public void setCan_vendida(int can_vendida) {
        this.can_vendida = can_vendida;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "codDetalleVenta=" + codDetalleVenta + ", venta_d=" + venta_d + ", producto_d=" + producto_d + ", can_vendida=" + can_vendida + ", total=" + total + '}';
    }
    
    
}
