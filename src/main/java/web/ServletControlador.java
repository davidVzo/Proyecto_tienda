package web;

import datos.UsuarioDaoJDBC;
import datos.PerfilDaoJDBC;
import datos.ProductoDaoJDBC;
import datos.VentaDaoJDBC;
import datos.DetalleVentaDaoJDBC;
import dominio.Usuario;
import dominio.Perfil;
import dominio.Producto;
import dominio.Venta;
import dominio.DetalleVenta;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        // verificar si la accion es 
        if (accion != null) {
            switch (accion) {

                case "listaP":
                    this.listarPerfil(request, response);
                    break;
                case "listaU":
                    this.listarUsuario(request, response);
                    break;
                case "eliminarUsuario":
                    this.eliminarUsuario(request, response);
                    break;
                case "listaProd":
                    this.listarProducto(request, response);
                    break;
                case "listaV":
                    this.listarVenta(request, response);
                    break;
                case "listaDV":
                    this.listarDetalle(request, response);
                    break;
                default:
                    this.listarUsuario(request, response);
            }
        } else {
            this.listarUsuario(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //creamos una variable para capturar 
        String accion = request.getParameter("accion");
        // verificar si la accion es 
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarUsuario(request, response);
                    break;
                case "insertarPerfil":
                    this.insertarPerfil(request, response);
                    break;
                case "insertarProducto":
                    this.insertarProducto(request, response);
                    break;

                default:
                    this.listarUsuario(request, response);
            }
        } else {
            this.listarUsuario(request, response);
        }

    }

    //metodo accionDefault
    private void listarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> usuarios;
        List<Perfil> perfiles;

        usuarios = new UsuarioDaoJDBC().listar();

        System.out.println("usuarios = " + usuarios);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuarios", usuarios);

        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("usuarios.jsp");

    }

    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos los datos de un formulario
        int idPerfil = 2;
        String cedula = request.getParameter("cedula");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String user = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");
        String foto = "";

        String direccionFinal;
        String correoFinal;

        if (direccion != null && !"".equals(direccion)) {
            direccionFinal = direccion;
        } else {
            direccionFinal = "";
        }
        if (correo != null && !"".equals(correo)) {
            correoFinal = correo;
        } else {
            correoFinal = "";
        }

        //creamos un obteto 
        Usuario usuario = new Usuario(idPerfil, cedula, nombres, apellidos, direccionFinal, telefono, correoFinal, user, contraseña, foto);
        //insertamos el nuevo objeto a nuestra base de datos 
        int registrosModificados = new UsuarioDaoJDBC().insertar(usuario);
        //imprimimos en consola 
        System.out.println("registrosModificados " + registrosModificados);

        String accion = "";
        this.listarUsuario(request, response);

    }

    private void insertarPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos los datos de un formulario
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String descripcionFinal;
        if (descripcion != null && !"".equals(descripcion)) {
            descripcionFinal = descripcion;
        } else {
            descripcionFinal = "";
        }
        //creamos un obteto 
        Perfil perfil = new Perfil(nombre, descripcion);
        //insertamos el nuevo objeto a nuestra base de datos 
        int registrosModificados = new PerfilDaoJDBC().insertar(perfil);
        //imprimimos en consola 
        System.out.println("registrosModificados " + registrosModificados);
        String accion = "";
        this.listarPerfil(request, response);

    }

    private void insertarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos los datos de un formulario
        String codigo = request.getParameter("codigo");

        int proveedor = Integer.parseInt(request.getParameter("proveedor"));
        int estado = Integer.parseInt(request.getParameter("estado"));
        String nombre = request.getParameter("nombre");
        String categoria = request.getParameter("categoria");
        String descripcion = request.getParameter("descripcion");
        int cantidad = Integer.parseInt(request.getParameter("disponible"));
        double precio = Double.parseDouble(request.getParameter("precio"));

        String descripcionFinal;

        if (categoria != null && !"".equals(categoria)) {
            descripcionFinal = descripcion;
        } else {
            descripcionFinal = "";
        }
        //creamos un obteto 
        Producto producto = new Producto(codigo, proveedor, estado, nombre, categoria, descripcionFinal, cantidad, precio);
        //insertamos el nuevo objeto a nuestra base de datos 
        int registrosModificados = new ProductoDaoJDBC().insertar(producto);
        //imprimimos en consola 
        System.out.println("registrosModificados " + registrosModificados);
        String accion = "";
        this.listarProducto(request, response);

    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //capturamos los datos del id cliente 
        int idUsuario = Integer.parseInt(request.getParameter("idusuario"));
        Usuario usuario = new Usuario(idUsuario);
        //Eliminamos 
        int registrosModificados = new UsuarioDaoJDBC().eliminar(usuario);
        //imprimios los reggistros actualizados 
        System.out.println("registros" + registrosModificados);
        String accion = "";
        this.listarUsuario(request, response);

    }

    private void listarPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Perfil> perfiles;

        perfiles = new PerfilDaoJDBC().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("perfiles", perfiles);

        response.sendRedirect("perfiles.jsp");

    }

    private void listarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        List<Producto> productos;
        productos = new ProductoDaoJDBC().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("productos", productos);

        response.sendRedirect("productos.jsp");
    }

    private void listarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Venta> ventas;

        ventas = new VentaDaoJDBC().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("ventas", ventas);

        response.sendRedirect("ventas.jsp");

    }

    private void listarDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DetalleVenta> detalles;

        detalles = new DetalleVentaDaoJDBC().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("Detalle ventas", detalles);

        response.sendRedirect("detalles.jsp");

    }

}
