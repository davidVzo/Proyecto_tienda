package datos;

import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class UsuarioDaoJDBC {

    private static final String SQL_SELECT = "SELECT idUsuario,idPerfil_u ,cedula ,nombres, apellidos,direccion, telefono,correo,usuario,clave,foto FROM usuario";
    private static final String SQL_SELECT_JOIN = "SELECT usuario.idUsuario,usuario.cedula ,usuario.nombres, usuario.apellidos,usuario.direccion, usuario.telefono,usuario.correo,usuario.usuario,usuario.clave,usuario.foto, perfil.nombrePerfil FROM usuario INNER JOIN perfil ON usuario.idPerfil_u = perfil.idPerfil";
    private static final String SQL_SELECT_BY_ID = "SELECT idUsuario,idPerfil_u ,cedula ,nombres, apellidos,direccion, telefono,correo,usuario,clave,foto FROM usuario WHERE idUsuario = ?";

    private static final String SQL_INSERT = "INSERT INTO usuario(idPerfil_u ,cedula ,nombres, apellidos,direccion, telefono, correo, usuario, clave, foto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE usuario SET idPerfil_u=? ,cedula=? ,nombres=?, apellidos=?,direccion=?, telefono=?,correo=?,usuario=?,clave=?,foto=? WHERE idUsuario=?";

    private static final String SQL_DELETE = "DELETE FROM usuario WHERE idUsuario = ?";

    //creamos metodo que permita listar datos
    public List<Usuario> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_JOIN);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("idUsuario");
                String nombrePerfil = rs.getString("nombrePerfil");
                String cedula = rs.getString("cedula");
                String nombres = rs.getString("nombres");
                String apellido = rs.getString("apellidos");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String user = rs.getString("usuario");
                String clave = rs.getString("clave");
                String foto = rs.getString("foto");
                //
                usuario = new Usuario(idUsuario, nombrePerfil, cedula, nombres, apellido, direccion, telefono, correo, user, clave, foto);
                usuarios.add(usuario);
            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios;
    }

    //metodo para insertar
    public int insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1, usuario.getIdPerfil_u());
            stmt.setString(2, usuario.getCedula());
            stmt.setString(3, usuario.getNombres());
            stmt.setString(4, usuario.getApellidos());
            stmt.setString(5, usuario.getDireccion());
            stmt.setString(6, usuario.getTelefono());
            stmt.setString(7, usuario.getCorreo());
            stmt.setString(8, usuario.getUsuario());
            stmt.setString(9, usuario.getClave());
            stmt.setString(10, usuario.getFoto());
            
            rows = stmt.executeUpdate();
            

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

//método para actualizar un usuario
    public int actualizar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        // variable seleciona un registro 
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, usuario.getIdPerfil_u());
            stmt.setString(2, usuario.getNombres());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getDireccion());
            stmt.setString(5, usuario.getTelefono());
            stmt.setString(6, usuario.getCorreo());
            stmt.setString(7, usuario.getUsuario());
            stmt.setString(8, usuario.getClave());
            stmt.setString(9, usuario.getFoto());

            rows = stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    //metodo para elminar a un usuario
    public int eliminar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        // variable seleciona u registro 
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, usuario.getIdUsuario());

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
