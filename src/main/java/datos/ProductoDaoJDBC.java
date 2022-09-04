/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductoDaoJDBC {

    private static final String SQL_SELECT = "SELECT codProducto ,proveedor_p,estado, nombreProducto,categoria,descripcion,can_disponible,precio FROM producto";

    private static final String SQL_SELECT_BY_ID = "SELECT codProducto ,proveedor_p,estado, nombreProducto,categoria,descripcion,can_disponible,precio FROM producto WHERE codProducto = ?";

    private static final String SQL_INSERT = "INSERT INTO producto ( codProducto, estado , nombreProducto , categoria , descripcion , can_disponible , precio , proveedor_p) VALUES (?,?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE producto SET estado=?, nombreProducto=?,categoria=?,descripcion=?,can_disponible=?,precio=?,proveedor_p=? WHERE codProducto=?";

    private static final String SQL_DELETE = "DELETE FROM producto WHERE codProducto = ?";

    //creamos metodo que permita listar datos
    public List<Producto> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                String codProducto = rs.getString("codProducto");
                int proveedor_p = rs.getInt("proveedor_p");
                int estado = rs.getInt("estado");
                String nombreProducto = rs.getString("nombreProducto");
                String categoria = rs.getString("categoria");
                String descripcion = rs.getString("descripcion");
                int can_disponible = rs.getInt("can_disponible");
                double precio = rs.getDouble("precio");

                //
                producto = new Producto(codProducto, proveedor_p, estado, nombreProducto, categoria, descripcion, can_disponible, precio);
                productos.add(producto);
            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return productos;
    }

    //metodo para insertar
    public int insertar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getCodProducto());
            stmt.setInt(2, producto.getEstado());
            stmt.setString(3, producto.getNombreProducto());
            stmt.setString(4, producto.getCategoria());
            stmt.setString(5, producto.getDescripcion());
            stmt.setInt(6, producto.getCan_disponible());
            stmt.setDouble(7, producto.getPrecio());
            stmt.setInt(8, producto.getProveedor_p());
            rows = stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    //método para actualizar 
    public int actualizar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        // variable seleciona un registro 
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, producto.getProveedor_p());
            stmt.setInt(2, producto.getEstado());
            stmt.setString(3, producto.getNombreProducto());
            stmt.setString(4, producto.getCategoria());
            stmt.setString(5, producto.getDescripcion());
            stmt.setInt(6, producto.getCan_disponible());
            stmt.setDouble(7, producto.getPrecio());

            rows = stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    //metodo para elminar
    public int eliminar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        // variable seleciona u registro 
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, producto.getCodProducto());

            rows = stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

}
