<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sistema de Usuarios</title>
    <meta charset="UTF-8">
</head>
<body>

    <%-- Redirección automática al controlador MVC --%>
    <%
        response.sendRedirect("UsuarioController?accion=listar");
    %>

</body>
</html>
