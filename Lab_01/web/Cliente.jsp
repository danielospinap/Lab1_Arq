<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>|
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <div class="container well">
            <h1>Informacion del cliente</h1>
            <form action="./ClienteServlet" method="POST">
                <table>
                    <tr>
                        <th> Identificacion</th>
                        <th><input type="text" class="form-control" placeholder="Identificacion" required="true" name="Identificacion" value="${cliente.getClienteid()}"/> </th>
                    </tr>
                    <tr>
                        <th> Nombres</th>
                        <th> <input type="text" name="nombre" class="form-control" placeholder="Nombre" required="false" value="${cliente.getNombre()}"/></th>
                    </tr>
                    <tr>
                        <th> Apellidos</th>
                        <th><input type="text" name="apellido" class="form-control" placeholder="Apellidos" required="false" value="${cliente.getApellidos()}"/> </th>
                    </tr>
                    <tr>
                        <th> Correo electronico</th>
                        <th> <input type="text" name="correo" class="form-control" placeholder="Correo electronico" required="false" value="${cliente.getCorreo()}"/></th>
                    </tr>
                    <tr>
                        <th> Telefono</th>
                        <th> <input type="text" name="telefono" class="form-control" placeholder="Telefono" required="false" value="${cliente.getTelefono()}"/></th>
                    </tr>
                    <tr>
                        <th> Direccion</th>
                        <th> <input type="text" name="direccion" class="form-control" placeholder="Direccion" required="false" value="${cliente.getDireccion()}"/></th>
                    </tr>
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
            <br>

            <table border="1" class="table table-striped">
                <th scope="row">Identificacion</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Correo</th>
                <th>Telefono</th>
                <c:forEach items="${allClientes}" var="cliente">
                    <tr>
                        <td>${cliente.getClienteid()}</td>
                        <td>${cliente.getNombre()}</td>
                        <td>$cliente.getApellido()}</td>
                        <td>${cliente.getCorreo()}</td>
                        <td>${cliente.getTelefono()}</td>
                        <td>${cliente.getDireccion()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <a href="Principal.jsp">Inicio</a>
    </body>
</html>