<script>

            function mostrarContrasena() {
                var tipo = document.getElementById("pwd");
                if (tipo.type == "password") {
                    tipo.type = "text";
                } else {
                    tipo.type = "password";
                }
            }
        </script> 

<div class="modal fade" id="agregarUsuariosModal"  tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Agregar Cliente</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" class="was-validated">
                    <div class="form-row">
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault01">Cedula</label>
                            <input type="text" class="form-control" id="validationDefault01" name="cedula" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault01">Nombres</label>
                            <input type="text" class="form-control" id="validationDefault01" name="nombres" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault02">Apellidos</label>
                            <input type="text" class="form-control" id="validationDefault02" name="apellidos" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault03">Dirección</label>
                            <input type="text" class="form-control" id="validationDefault03" name="direccion" >
                        </div>
                    </div>
                    <div class="form-row">
                        
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault04">Teléfono</label>
                            <input type="text" class="form-control" id="validationDefault05" name="telefono" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault05">Correo</label>
                            <input type="email" class="form-control" id="validationDefault05" placeholder="ejemplo@gmail.com" name="correo" >
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault03">Usuario</label>
                            <input type="text" class="form-control" id="validationDefault03" name="usuario" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault04">Clave</label>
                            <input type="password" class="form-control"  id="pwd" name="contraseña" required>
                            <span>
                            <i class="fa fa-eye" aria-hidden="true"  onclick="mostrarContrasena()" id="eye"></i>
                        </span>
                        </div>
                    </div>
                    
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        <button type="submit" class="btn btn-primary">Guardar Datos</button>
                    </div>
                </form>

            </div>
            
        </div>
    </div>
</div>
