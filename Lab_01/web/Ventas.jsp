<%-- 
    Document   : Ventas
    Created on : 26-ago-2016, 20:26:21
    Author     : PedroGallego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>|
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
    </head>
    <body>
        <div class="container well">
            <h1>Informacion de las ventas</h1>
            <form action="./VentaServlet" method="POST">
                <table>
                    <tr>
                        <th> Numero de compra</th>
                        <th><input type="text" class="form-control" placeholder="Solo para la busqueda" required="false" name="nCompra" value="${venta.getNVenta()}"/> </th>
                    </tr>
                    <tr>
                        <th> Cliente que realiza la compra *</th>
                        <th>   <select name="Cliente">
                                <c:forEach items="${allClientes}" var="cliente">
                                    <option value="${cliente.getClienteid()}">${cliente.getClienteid()}  ${cliente.getNombre()}</option>
                                </c:forEach>
                            </select> </th>
                    </tr>
                    <tr>
                        <th> Vehiculo comprado *</th>
                        <th>   <select name="Vehiculo">
                                <c:forEach items="${allVehiculos}" var="vehiculo">
                                    <option value="${vehiculo.getMatricula()}">${vehiculo.getMatricula()}  ${vehiculo.getNombre()}</option>
                                </c:forEach>
                            </select> </th>
                    </tr>
                    <tr>
                        <th> Fecha (AAAA/MM/DD) *</th>
                        <th><input type="text" name="fecha" class="form-control" placeholder="Fecha" required="false" value="${venta.getFecha()}"/> </th>
                    </tr>
                    <tr>
                    <div class="break"></div>                        
                    </div>
                    <tr>
                        <td colspan="2">
                            <input class="btn icon-btn btn-success" type="submit" name="action" value="Agregar">

                            <input class="btn icon-btn btn-info" type="submit" name="action" value="Editar">

                            <input class="btn icon-btn btn-danger" type="submit" name="action" value="Eliminar">

                            <input class="btn icon-btn btn-primary" type="submit" name="action" value="Buscar">
                            <p>* Campos obligatorios.</p>
                        </td>
                    </tr>

                </table>
            </form>
            <br>

            <table border="1" class="table table-striped">
                <th scope="row">Venta Nº</th>
                <th>Fecha</th>
                <th>Cedula cliente</th>
                <th>Matricula vehiculo</th>
                    <c:forEach items="${allVentas}" var="venta">
                    <tr>
                        <td>${venta.getNVenta()}</td>
                        <td>${venta.getFecha()}</td>
                        <td>${venta.getCedulaCliente()}</td>
                        <td>${venta.getMatriculaVehiculo()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <a href="Principal.jsp">Inicio</a>
    </body>
</html>
