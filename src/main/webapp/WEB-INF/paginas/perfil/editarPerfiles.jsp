


<!DOCTYPE html>

<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Listado de Perfiles</title>

        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">



    </head>

    <body id="page-top">
        <div id="wrapper">
            <jsp:include page="/WEB-INF/paginas/comunes/header.jsp"/>
            <!-- Begin Page Content -->
            <div class="container-fluid">

                <div class="container">
                    <div class="row">
                        <div class="card" >
                            <div class="card-header" >
                                <h1 class="h3 mb-2 text-gray-800">Editar Cliente</h1>

                                <form method="post" action="${pageContext.request.contextPath}/ServletControlador?accion=editarPerfil&idperfil=${perfil.idPerfil}" class="was-validated">
                                    <jsp:include page="/WEB-INF/paginas/comunes/botonesCabeceroEditar.jsp"/>

                                    <div class="form-row">
                                        <div class="col-md-6 mb-3">
                                            <label for="validationDefault01">Nombre</label>
                                            <input type="text" class="form-control" id="validationDefault01" name="nombre" value="${perfil.nombre}"" required>
                                        </div>
                                        <div class="col-md-6 mb-3">
                                            <label for="validationDefault02">Descripcion</label>
                                            <input type="text" class="form-control" id="validationDefault02" name="descripcion" value="${perfil.descripcion}"" >
                                        </div>
                                    </div>


                                </form>

                            </div>


                        </div>

                    </div>
                </div>


            </div>

        </div>
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>
        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">¿Seguro de salir?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>

                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                        <a class="btn btn-primary" href="login.html">Salir</a>
                    </div>
                </div>
            </div>
        </div>

        <!--     Core plugin JavaScript
        -->    <script src="vendor/jquery-easing/jquery.easing.min.js"></script><!--
        
             Custom scripts for all pages
        -->    <script src="js/sb-admin-2.min.js"></script>

    </body>
    <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
</html>



