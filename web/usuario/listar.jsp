<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Usuario" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Usuarios</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Estilos propios -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<%@ include file="../includes/header.jsp" %>

<div class="container mt-5">

    <div class="d-flex justify-content-between mb-3">
        <h3>Usuarios Registrados</h3>
        <a href="${pageContext.request.contextPath}/UsuarioController?accion=nuevo"
           class="btn btn-primary">
            Nuevo Usuario
        </a>
    </div>

    <table class="table table-bordered table-striped shadow">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Fecha</th>
                <th>Estado</th>
            </tr>
        </thead>

        <tbody>
        <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            if (usuarios != null) {
                for (Usuario u : usuarios) {
        %>
            <tr>
                <td><%= u.getIdUsuario() %></td>
                <td><%= u.getNombre() %></td>
                <td><%= u.getEmail() %></td>
                <td><%= u.getFechaCreacion() %></td>
                <td><%= u.isEstado() ? "Activo" : "Inactivo" %></td>
            </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>

</div>

</body>
</html>
