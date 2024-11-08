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
*Clase para manejar las solicitudes HTTP para generar Lista de Usuarios.
*/
@WebServlet("/ListarUsuario")
public class ListarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

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
                req.getRequestDispatcher("/listar-usuario.jsp").forward(req, resp);
            } else {
                req.setAttribute("usuarios", null);
                req.getRequestDispatcher("/listar-usuario.jsp").forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            System.err.println("Error al mostrar los usuarios");
            System.err.println("Error: " + e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/Menu");
        }
    }
}
