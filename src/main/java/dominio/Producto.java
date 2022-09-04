/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Usuario
 */
public class Producto {

    private String codProducto;
    private int proveedor_p;
    private int estado;
    private String nombreProducto;
    private String categoria;
    private String descripcion;
    private int can_disponible;
    private double precio;

    //constructores

    public Producto() {
    }

    public Producto(int proveedor_p, int estado, String nombreProducto, String categoria, String descripcion, int can_disponible, double precio) {
        this.proveedor_p = proveedor_p;
        this.estado = estado;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.can_disponible = can_disponible;
        this.precio = precio;
    }

    public Producto(String codProducto) {
        this.codProducto = codProducto;
    }

    public Producto(String codProducto, int proveedor_p, int estado, String nombreProducto, String categoria, String descripcion, int can_disponible, double precio) {
        this.codProducto = codProducto;
        this.proveedor_p = proveedor_p;
        this.estado = estado;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.can_disponible = can_disponible;
        this.precio = precio;
    }
    //metodos 

    public String getCodProducto() {
        return codProducto;
    }

    public int getProveedor_p() {
        return proveedor_p;
    }

    public int getEstado() {
        return estado;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCan_disponible() {
        return can_disponible;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "codProducto=" + codProducto + ", proveedor_p=" + proveedor_p + ", estado=" + estado + ", nombreProducto=" + nombreProducto + ", categoria=" + categoria + ", descripcion=" + descripcion + ", can_disponible=" + can_disponible + ", precio=" + precio + '}';
    }
    
}
