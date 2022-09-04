/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class DetalleVentaDaoJDBC {
    private static final String SQL_SELECT = "SELECT codDetalleVenta,venta_d, producto_d, can_vendida,total FROM detalleeventa";

    private static final String SQL_SELECT_BY_ID = "SELECT codDetalleVenta,venta_d, producto_d, can_vendida,total FROM detalleeventa WHERE codDetalleVenta = ?";

    private static final String SQL_INSERT = "INSERT INTO detalleventa (codDetalleVenta,venta_d, producto_d, can_vendida,total) VALUES(?,?,?,?,?)";
    

    private static final String SQL_UPDATE = "UPDATE detalleventa SET codDetalleVenta=?,venta_d=?, producto_d=?, can_vendida=?,total=? WHERE codDetalleVenta=?";

    private static final String SQL_DELETE = "DELETE FROM detalleventa WHERE codDetalleVenta = ?";
    
    //creamos metodo que permita listar datos
    public List<DetalleVenta> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DetalleVenta detalleventa = null;
        List<DetalleVenta> detalleventas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codDetalleVenta = rs.getString("codDetalleVenta");
                int venta_d = rs.getInt("venta_d");
                String producto_d = rs.getString("producto_d");
                int can_vendida = rs.getInt("can_vendida");
                double total = rs.getDouble("total");
                //
                detalleventa = new DetalleVenta(codDetalleVenta, venta_d, producto_d, can_vendida, total);
                detalleventas.add(detalleventa);
            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return detalleventas;
    }
    //metodo para insertar
    public int insertar(DetalleVenta detalleventa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, detalleventa.getCodDetalleVenta());
            stmt.setInt(2, detalleventa.getVenta_d());
            stmt.setString(3, detalleventa.getProducto_d());
            stmt.setInt(4, detalleventa.getCan_vendida());
            stmt.setDouble(5, detalleventa.getTotal());
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
    public int actualizar(DetalleVenta detalleventa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        // variable seleciona un registro 
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, detalleventa.getCodDetalleVenta());
            stmt.setInt(2, detalleventa.getVenta_d());
            stmt.setString(3, detalleventa.getProducto_d());
            stmt.setInt(4, detalleventa.getCan_vendida());
            stmt.setDouble(5, detalleventa.getTotal());
            

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
    public int eliminar(DetalleVenta detalleventa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        // variable seleciona u registro 
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, detalleventa.getCodDetalleVenta());

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
