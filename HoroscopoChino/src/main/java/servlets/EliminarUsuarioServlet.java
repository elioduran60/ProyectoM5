package servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

/*
*Clase para manejar las solicitudes HTTP para Eliminar los Usuarios existentes.
*/
@WebServlet("/EliminarUsuario")
public class EliminarUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = Arrays.asList();

        try {
            usuarios = usuarioDAO.mostrarUsuarios();
        } catch (ClassNotFoundException e) {
            System.err.println("Error al mostrar los usuarios");
            System.err.println("Error: " + e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/Menu");
        }

        try {

            if (!usuarios.isEmpty()) {
                req.setAttribute("usuarios", usuarios);
                System.out.println("--------------------------------- usuarios existen---");
                req.getRequestDispatcher("/eliminacion-usuario.jsp").forward(req, resp);
            } else {
                req.setAttribute("usuarios", null);
                req.getRequestDispatcher("/eliminacion-usuario.jsp").forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            System.err.println("Error al mostrar los usuarios");
            System.err.println("Error: " + e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/Menu");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Long id = Long.valueOf(req.getParameter("id"));
        System.out.println("id: " + id);
        List<Usuario> usuarios;

        try {
            Boolean eliminado = usuarioDAO.eliminarUsuario(id);
            usuarios = usuarioDAO.mostrarUsuarios();
            System.out.println("-----------------------eliminando-------------------------");
            
            req.setAttribute("eliminado", eliminado);
            req.setAttribute("usuarios", usuarios);
            req.getRequestDispatcher("/eliminacion-usuario.jsp").forward(req, resp);

        } catch (ServletException | IOException | ClassNotFoundException e) {
            System.err.println("Error al eliminar la cuenta");
            System.err.println("Error: " + e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/Menu");
        }

        req.getRequestDispatcher("/eliminacion-usuario.jsp").forward(req, resp);
    }
}
