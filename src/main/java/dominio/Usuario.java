/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Usuario
 */
public class Usuario {

    private int idUsuario;
    private int idPerfil_u;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String correo;
    private String usuario;
    private String clave;
    private String foto;
    private String nombrePerfil;

    //crearmos constructores
    //para obtener datos
    public Usuario() {
    }

    //constructor con solo idCliente

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    

    //constructor para obtener datos de la tabla .. todos menos el idClientye
    public Usuario(int idPerfil_u, String cedula, String nombres, String apellidos, String direccion, String telefono, String correo, String usuario, String clave, String foto) {    
        this.idPerfil_u = idPerfil_u;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.foto = foto;
    }
    
      

    //con todos los parametros
    public Usuario(int idUsuario, String nombrePerfil, String cedula, String nombres, String apellidos, String direccion, String telefono, String correo, String usuario, String clave, String foto) {
        this.idUsuario = idUsuario;
        this.nombrePerfil = nombrePerfil;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.foto = foto;
    }

    //metodos get y set

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPerfil_u() {
        return idPerfil_u;
    }

    public void setIdPerfil_u(int idPerfil_u) {
        this.idPerfil_u = idPerfil_u;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }
    
    
    //metodo toString

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", idPerfil_u=" + idPerfil_u + ", cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + ", usuario=" + usuario + ", clave=" + clave + ", foto=" + foto + '}';
    }

    
    
    
    
    
}
