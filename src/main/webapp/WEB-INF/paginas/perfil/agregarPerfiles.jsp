
<div class="modal fade" id="agregarPerfilesModal"  tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Agregar Perfil</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="${pageContext.request.contextPath}/ServletControlador?accion=insertarPerfil" class="was-validated">
                    <div class="form-row">
                        
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault01">Nombre</label>
                            <input type="text" class="form-control" id="validationDefault01" name="nombre" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="validationDefault02">Descripción</label>
                            <input type="text" class="form-control" id="validationDefault02" name="descripcion" >
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
