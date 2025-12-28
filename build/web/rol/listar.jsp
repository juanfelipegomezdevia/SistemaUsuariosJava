<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Rol" %>

<!DOCTYPE html>
<html>
<head>
    <title>Roles</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Rol" %>

<%@ include file="../includes/header.jsp" %>

<div class="container mt-5">
    <h3>Roles del Sistema</h3>

    <table class="table table-bordered">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripción</th>
            </tr>
        </thead>

        <tbody>
        <%
            List<Rol> roles = (List<Rol>) request.getAttribute("roles");
            for (Rol r : roles) {
        %>
            <tr>
                <td><%= r.getIdRol() %></td>
                <td><%= r.getNombre() %></td>
                <td><%= r.getDescripcion() %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

</body>
</html>
