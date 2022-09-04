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

<div class="modal fade" id="agregarProductosModal"  tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Agregar Cliente</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="${pageContext.request.contextPath}/ServletControlador?accion=insertarProducto" class="was-validated">
                    <div class="form-row">
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault01">Código</label>
                            <input type="text" class="form-control" id="validationDefault01" name="codigo" required>
                        </div>
                        
                        <div class="col-md-6 mb-3">
                             <label>Estado</label>
                            <select class="form-control" name="estado">
                                <option value="1">ACTIVO</option>
                                <option value="0">INACTIVO</option>                              
                            </select>
                        </div>
                        
                        
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault02">Nombre</label>
                            <input type="nombre" class="form-control" id="validationDefault02" name="nombre" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault03">Categoria</label>
                            <input type="text" class="form-control" id="validationDefault03" name="categoria" >
                        </div>
                    </div>
                    <div class="form-row">
                         <div class="col-md-6 mb-3">
                            <label for="validationDefault04">Descripción</label>
                            <input type="text" class="form-control" id="validationDefault05" name="descripcion" required>
                        </div>
                        
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault04">Cantidad Disponible</label>
                            <input type="text" class="form-control" id="validationDefault05" name="disponible" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault05">Precio</label>
                            <input type="text" class="form-control" id="validationDefault05"  name="precio" required >
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault03">Proveedor</label>
                            <input type="text" class="form-control" id="validationDefault03" name="proveedor" required>
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
