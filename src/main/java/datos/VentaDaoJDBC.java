/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import dominio.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class VentaDaoJDBC {
    private static final String SQL_SELECT = "SELECT idVenta ,idUsuario_v,fechaVenta, subtotal,descuento,total FROM venta";

    private static final String SQL_SELECT_BY_ID = "SELECT idVenta ,idUsuario_v,fechaVenta, subtotal,descuento,total FROM producto WHERE idVenta = ?";

    private static final String SQL_INSERT = "INSERT INTO venta (idUsuario_v,fechaVenta, subtotal,descuento,total) VALUES(?,?,?,?,?)";
    

    private static final String SQL_UPDATE = "UPDATE venta SET idUsuario_v=?,fechaVenta=?, subtotal=?,descuento=?,total=? WHERE idVenta=?";

    private static final String SQL_DELETE = "DELETE FROM venta WHERE idVenta = ?";
    
    //creamos metodo que permita listar datos
    public List<Venta> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Venta venta = null;
        List<Venta> ventas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idVenta = rs.getInt("idVenta");
                int idUsuario_v = rs.getInt("idUsuario_v");
                String fechaVenta = rs.getString("fechaVenta");
                double subtotal = rs.getDouble("subtotal");
                double descuento = rs.getDouble("descuento");
                double total = rs.getDouble("total");
                //
                venta = new Venta(idVenta, idUsuario_v, fechaVenta, subtotal, descuento, total);
                ventas.add(venta);
            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ventas;
    }
    //metodo para insertar
    public int insertar(Venta venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setInt(1, venta.getIdUsuario_v());
            stmt.setString(2, venta.getFechaVenta());
            stmt.setDouble(3, venta.getSubtotal());
            stmt.setDouble(4, venta.getDescuento());
            stmt.setDouble(5, venta.getTotal());
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
    public int actualizar(Venta venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        // variable seleciona un registro 
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setInt(1, venta.getIdUsuario_v());
            stmt.setString(2, venta.getFechaVenta());
            stmt.setDouble(3, venta.getSubtotal());
            stmt.setDouble(4, venta.getDescuento());
            stmt.setDouble(5, venta.getTotal());
            

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
    public int eliminar(Venta venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        // variable seleciona u registro 
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, venta.getIdVenta());

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
