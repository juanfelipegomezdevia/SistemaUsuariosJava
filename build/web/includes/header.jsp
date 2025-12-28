<%-- Cambia esto en Header.jsp --%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/UsuarioController">
            Sistema Usuarios
        </a>

        <div class="navbar-nav">
            <a class="nav-link" href="${pageContext.request.contextPath}/UsuarioController">
                Usuarios
            </a>

            <a class="nav-link" href="${pageContext.request.contextPath}/RolController">
                Roles
            </a>

            <a class="nav-link" href="${pageContext.request.contextPath}/UsuarioController?accion=asignar">
                Asignar Rol
            </a>
        </div>
    </div>
</nav>
