<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_EC" />
<!DOCTYPE html>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/buttons/2.0.1/css/buttons.dataTables.min.css">
 <style>
            table.dataTable{
                font-size: 0.8em;
            }
        </style>
<div class="ml-4 mt-4 mr-4 mb-4">
    <div class="card-body">
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#agregarProductosModal">
                    <span class="icon text-white-50">
                        <i class="fas fa-arrow-right"></i>
                    </span>
                    <span class="text">Agregar Producto</span>
                </button>
                

            </div>
    <div class="row">

        <div class="col-sm-12">
            <div class="card">
                <div class="card-body">
                    <div class=""> 

                    </div>
                    <table class="table table-hover text-center" style="width: 100%" id="example"  >
                        <thead>
                            <tr class="text-center">
                                <th>Código Producto</th>
                                <th>Proveedor</th>
                                <th>Estado</th>
                                <th>Nombre</th>
                                <th>Categoria</th>
                                <th>Descripcion</th>
                                <th>Cantidad Disponible</th>
                                <th>Precio</th>
                           
                                <th>Editar</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody> 
                            <c:forEach var="producto" items="${productos}">
                                <tr>

                                    <td>${producto.codProducto} </td>
                                    <td>${producto.proveedor_p}</td>
                                    <td> ${producto.estado}</td>
                                    <td> ${producto.nombreProducto} </td><!-- comment -->
                                    <td> ${producto.categoria}</td>
                                    <td> ${producto.descripcion}</td>
                                    <td> ${producto.can_disponible}</td>
                                    <td> ${producto.precio}</td>
                          

                                    <td> 
                                       <a href="" class="btn btn-info btn-circle">
                                            <i class="fas fa-pencil-alt"></i>
                                        </a>
                                    </td> 
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminarProducto&codPRODUCTO=${producto.codProducto}" class="btn btn-danger btn-circle">
                                            <i class="fas fa-trash"></i>
                                        </a>
                                    </td>

                                </tr> </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            
    </div>      
</div>   

<jsp:include page="/WEB-INF/paginas/producto/agregarProductos.jsp"/>

<%@ include file="commons/footer.jspf"%>







