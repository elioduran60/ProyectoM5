package servlets;

import java.io.IOException;

import dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

@WebServlet("/IniciarSesion")
public class IniciarSesionServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.getRequestDispatcher("/HoroscopoChino").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                        throws ServletException, IOException {
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                System.out.println("username: " + username);
                System.out.println("password: " + password);
                
                if (username.isEmpty() || password.isEmpty()) {
                        req.setAttribute("usuario", "Los valores son obligatorios");
                        req.getRequestDispatcher("/HoroscopoChino").forward(req, resp);
                        return;
                }

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = null;
                try {
                        usuario = usuarioDAO.login(username, password);
                        System.out.println("usuario recibido: " + usuario);
                } catch (ClassNotFoundException e) {
                        System.err.println("Error al insertar el usuario");
                        System.err.println("Error: " + e.getMessage());
                }

                if (usuario != null && usuario.getPassword().equals(password)) {
                        HttpSession session = req.getSession();
                        session.setAttribute("usuario", usuario);
                        System.out.println("sesion usuario: " + session.getAttribute("usuario"));
                        resp.sendRedirect(req.getContextPath() + "/Menu");
                } 

                if (usuario != null && !usuario.getPassword().equals(password)) {
                        req.setAttribute("password", "Contraseña incorrecta");
                        System.out.println("Contraseña incorrecta");
                        req.getRequestDispatcher("/").forward(req, resp);
                }

                if (usuario == null) {
                        req.setAttribute("password", "Usuario no existe, debe registrarse");
                        System.out.println("Usuario no existe, debe registrarse");
                        req.getRequestDispatcher("/").forward(req, resp);
                }
                
        }
}