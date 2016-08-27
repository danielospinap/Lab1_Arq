<%-- 
    Document   : Index
    Created on : 26-ago-2016, 18:30:13
    Author     : PedroGallego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Principal</title>
    </head>
    <body>
        <h1>Consecionario de vehiculos</h1>
        <table>
            <tr>
            <form action="Cliente.jsp" method="POST">
            <input type="submit" 
                   value="Clientes" 
                   id="ClienteServlet"
                   name="ClienteServlet" />
            </form>
            <form action="Veiculo.jsp" method="POST">
            <input type="submit" 
                   value="Vehiculos" 
                   id="VehiculoServlet"
                   name="VehiculoServlet" />
            </form>
            <form action="Ventas.jsp" method="POST">
            <input type="submit" 
                   value="Ventas" 
                   id="VentaServlet"
                   name="VentaServlet" />
            </form>
        </tr>
    </table>
</body>
</html>
