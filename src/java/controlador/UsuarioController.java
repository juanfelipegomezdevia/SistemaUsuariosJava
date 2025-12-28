package controlador;

import dao.UsuarioDAO;
import dao.RolDAO;
import dao.UsuarioRolDAO;
import modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private RolDAO rolDAO = new RolDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {

            case "listar":
                listarUsuarios(request, response);
                break;

            case "nuevo":
                mostrarFormulario(request, response);
                break;

            case "asignar":
                request.setAttribute("usuarios", usuarioDAO.listar());
                request.setAttribute("roles", rolDAO.listar());
                request.getRequestDispatcher("/usuario/asignarRol.jsp")
                       .forward(request, response);
                break;

            default:
                listarUsuarios(request, response);
                break;
        }
    }

    // Al inicio de la clase, junto a los otros DAOs
    private UsuarioRolDAO urDAO = new UsuarioRolDAO(); 

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String accion = request.getParameter("accion");

            if ("guardar".equals(accion)) {
                guardarUsuario(request, response);
            } 
            // AGREGAR ESTO:
            else if ("guardarRol".equals(accion)) {
                int idU = Integer.parseInt(request.getParameter("idUsuario"));
                int idR = Integer.parseInt(request.getParameter("idRol"));
                urDAO.asignar(idU, idR);
                response.sendRedirect("UsuarioController?accion=listar");
            }
        }

    // ================= MÉTODOS =================

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("usuarios", usuarioDAO.listar());
        request.getRequestDispatcher("/usuario/listar.jsp").forward(request, response);
    }

    private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Faltaba cargar estas listas para que el JSP no de error null
    request.setAttribute("usuarios", usuarioDAO.listar());
    request.setAttribute("roles", rolDAO.listar());
    request.getRequestDispatcher("/usuario/formulario.jsp").forward(request, response);
    }
    private void guardarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Usuario u = new Usuario();
        u.setNombre(request.getParameter("nombre"));
        u.setEmail(request.getParameter("email"));
        u.setPassword(request.getParameter("password"));
        u.setFechaCreacion(new Date());
        u.setEstado(true);

        usuarioDAO.guardar(u);

        response.sendRedirect("UsuarioController?accion=listar");
    }
}
