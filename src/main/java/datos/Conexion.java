/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Usuario
 */
public class Conexion {

    //creamos ua variable para guardar la ruta de la conexion
    //final esta variable no puede ser cambiada 
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tienda?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    //creamos un metodo para obtener 
    public static DataSource getDataSource() {
        //haremos un pool de conexion
        //inicializamos el objeto DataSorce
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        //que se conecten solo 50 personas
        ds.setInitialSize(50);
        return ds;
    }

    //creamos un metodo para obtener la conexion
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    //creamos metodo para cerrar el ResultSet
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //creamos metodo para cerrar PreparedStatement
    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //cerrar conexion
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
