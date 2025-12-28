<%@ page import="java.util.List" %>
<%@ page import="modelo.Usuario" %>
<%@ page import="modelo.Rol" %>

<!DOCTYPE html>
<html>
<head>
    <title>Asignar Rol</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Usuario" %>
<%@ page import="modelo.Rol" %>

<%@ include file="../includes/header.jsp" %>

<div class="container mt-5">
    <h3>Asignar Rol a Usuario</h3>

    <form action="UsuarioController" method="post">
        <input type="hidden" name="accion" value="guardarRol">

        <div class="mb-3">
            <label>Usuario</label>
            <select name="idUsuario" class="form-select">
                <%
                    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                    for (Usuario u : usuarios) {
                %>
                <option value="<%= u.getIdUsuario() %>">
                    <%= u.getNombre() %>
                </option>
                <% } %>
            </select>
        </div>

        <div class="mb-3">
            <label>Rol</label>
            <select name="idRol" class="form-select">
                <%
                    List<Rol> roles = (List<Rol>) request.getAttribute("roles");
                    for (Rol r : roles) {
                %>
                <option value="<%= r.getIdRol() %>">
                    <%= r.getNombre() %>
                </option>
                <% } %>
            </select>
        </div>

        <button class="btn btn-success">Asignar</button>
    </form>
</div>

</body>
</html>
