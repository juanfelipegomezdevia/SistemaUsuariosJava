<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Nuevo Usuario</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Estilos propios -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<%@ include file="../includes/header.jsp" %>

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h4>Crear Usuario</h4>
        </div>

        <div class="card-body">

            <form action="${pageContext.request.contextPath}/UsuarioController" method="post">

                <input type="hidden" name="accion" value="guardar">

                <div class="mb-3">
                    <label class="form-label">Nombre</label>
                    <input type="text" name="nombre" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" name="email" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Contraseña</label>
                    <input type="password" name="password" class="form-control" required>
                </div>

                <div class="d-flex justify-content-between">
                    <a href="${pageContext.request.contextPath}/UsuarioController?accion=listar"
                       class="btn btn-secondary">
                        Cancelar
                    </a>

                    <button type="submit" class="btn btn-success">
                        Guardar Usuario
                    </button>
                </div>

            </form>

        </div>
    </div>
</div>

</body>
</html>
