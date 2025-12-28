package controlador;

import dao.RolDAO;
import modelo.Rol;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/RolController")
public class RolController extends HttpServlet {

    RolDAO rolDAO = new RolDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("roles", rolDAO.listar());
        request.getRequestDispatcher("rol/listar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Rol r = new Rol();
        r.setNombre(request.getParameter("nombre"));
        r.setDescripcion(request.getParameter("descripcion"));

        rolDAO.guardar(r);
        response.sendRedirect("RolController");
    }
}
