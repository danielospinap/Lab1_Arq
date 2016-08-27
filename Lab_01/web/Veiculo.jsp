<%-- 
    Document   : Veiculo
    Created on : 24-ago-2016, 23:35:53
    Author     : PedroGallego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Veiculos</title>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Agregar nuevo vehiculo</h1>
        <form action="./VehiculoServlet" method="POST">
            <table>
                <tr>
                    <th>Matricula</th>
                    <th><input type="text" class="form-control" placeholder="Matricula" required="true" name="Matricula" value="${veiculo.getMatricula()}"/> </th>
                </tr>
                <tr>
                    <th> Nombre</th>
                    <th> <input type="text" name="nombre" class="form-control" placeholder="Nombre" required="false" value="${veiculo.getNombre()}"/></th>
                </tr>
                <tr>
                    <th> Modelo</th>
                    <th><input type="text" name="modelo" class="form-control" placeholder="Modelo" required="false" value="${veiculo.getModelo()}"/> </th>
                </tr>
                <tr>
                    <th> Color</th>
                    <th> <input type="text" name="color" class="form-control" placeholder="Color" required="false" value="${veiculo.getColor()}"/></th>
                </tr>
                <tr>
                    <th> Costo</th>
                    <th> <input type="text" name="costo" class="form-control" placeholder="Costo" required="false" value="${veiculo.getCosto()}"/></th>
                </tr>
                <div class="break"></div>
                </div>
                <div class="select_group">
                    <div class="select">
                        <label for="Imagen">Imagen</label>
                        <input class="form-control" type="file" name="Imagen" id="imagen" />
                    </div> </div>
                <div class="break"></div>                        
                </div>
                <tr>
                    <td colspan="2">
                        <input class="btn icon-btn btn-success" type="submit" name="action" value="Agregar">

                        <input class="btn icon-btn btn-info" type="submit" name="action" value="Editar">

                        <input class="btn icon-btn btn-danger" type="submit" name="action" value="Eliminar">

                        <input class="btn icon-btn btn-primary" type="submit" name="action" value="Buscar">

                    </td>
                </tr>
            </table>
        </form>

        <table border="1">
            <tr align="center" valign="middle">
                <th colspan="4">Vehiculos</th>
            </tr>
            <tr>
                <th>Foto</td>
                <th>Descripcion</td>
            </tr>
            <c:forEach items="${allVeiculos}" var="veiculo">
                <tr>
                    <td> <img src="${veiculo.getImagen()}"/></td>
                    <td><br> Nombre: ${veiculo.getNombre()}
                        <br> Modelo: ${veiculo.getModelo()}
                        <br> Color:  ${veiculo.getColor()}
                        <br> Costo: ${veiculo.getCosto()}
                    </td>
                </tr> </c:forEach>
        </table>
        <a href="Principal.jsp">Inicio</a>
    </body>
</html>
