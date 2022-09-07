/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Perfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PerfilDaoJDBC {
    private static final String SQL_SELECT = "SELECT idPerfil ,nombrePerfil, descripcionPerfil FROM perfil";

    private static final String SQL_SELECT_BY_ID = "SELECT idPerfil ,nombrePerfil, descripcionPerfil FROM perfil WHERE idPerfil = ?";

    private static final String SQL_INSERT = "INSERT INTO perfil (nombrePerfil, descripcionPerfil) VALUES(?, ?)";

    private static final String SQL_UPDATE = "UPDATE perfil SET nombrePerfil=?, descripcionPerfil=? WHERE idPerfil=?";

    private static final String SQL_DELETE = "DELETE FROM perfil WHERE idPerfil = ?";
    
    //creamos metodo que permita listar datos
    public List<Perfil> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Perfil perfil = null;
        List<Perfil> perfiles = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPerfil = rs.getInt("idPerfil");
                String nombre = rs.getString("nombrePerfil");
                String descripcion = rs.getString("descripcionPerfil");
                //
                perfil = new Perfil(idPerfil, nombre, descripcion);
                perfiles.add(perfil);
            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return perfiles;
    }
    //metodo para insertar
    public int insertar(Perfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, perfil.getIdPerfil());
            stmt.setString(1, perfil.getNombre());
            stmt.setString(2, perfil.getDescripcion());
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
    public int actualizar(Perfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        // variable seleciona un registro 
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, perfil.getNombre());
            stmt.setString(2, perfil.getDescripcion());
            stmt.setInt(3, perfil.getIdPerfil());
            

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
    public int eliminar(Perfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        // variable seleciona u registro 
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, perfil.getIdPerfil());

            rows = stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
       public Perfil encontrar(Perfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, perfil.getIdPerfil());
            rs = stmt.executeQuery();

            rs.absolute(1);

            //obtenemos mediante el java beasn 
            String nombre = rs.getString("nombrePerfil");
            String descripcion = rs.getString("descripcionPerfil");
         
            //Seteamos los valores 
            perfil.setNombre(nombre);
            perfil.setDescripcion(descripcion);
        
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return perfil; 

    }
    
}
