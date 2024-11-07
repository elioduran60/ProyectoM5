package servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import dao.ObtenerHoroscopoDAO;
import dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Horoscopo;
import modelo.Usuario;

@WebServlet("/ModificarUsuario")
public class ModificarUsuarioServlet extends HttpServlet {

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
                req.getRequestDispatcher("/modificacion-usuario.jsp").forward(req, resp);
            } else {
                req.setAttribute("usuarios", null);
                req.getRequestDispatcher("/modificacion-usuario.jsp").forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            System.err.println("Error al mostrar los usuarios");
            System.err.println("Error: " + e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/Menu");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fecha_nacimiento = req.getParameter("fecha_nacimiento");
        Date fecha_correcta;
        try {
            LocalDate.parse(fecha_nacimiento);
            fecha_correcta = Date.valueOf(fecha_nacimiento);
        } catch (DateTimeParseException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Formato de fecha incorrecto; debe usar el siguiente formato: yyyy-mm-dd ");
            return;
        }
        ObtenerHoroscopoDAO horoscopoDAO = new ObtenerHoroscopoDAO();
        Horoscopo horoscopo = horoscopoDAO.horoscopoPorFecha(fecha_correcta);
        if (!horoscopo.isPresent()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No se encontró un horóscopo para la fecha de nacimiento");
            return;
        }
        String animal = null;
        if (horoscopo.isPresent()) {
            animal = horoscopo.getAnimal();
        }
        Usuario usuarioCreadoNuevo = new Usuario(nombre, email, username, fecha_correcta, password, animal);
        usuarioCreadoNuevo.setId(Long.valueOf(req.getParameter("id")));
        System.out.println("Usuario creado en Modificar: " + usuarioCreadoNuevo);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuariosEncontrados;

        Boolean usuarioActualizado;
        try {
            usuarioActualizado = usuarioDAO.actualizarUsuario(usuarioCreadoNuevo);
            System.out.println("Usuario actualizado en modificar: " + usuarioActualizado);

        } catch (ClassNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No se pudo crear el usuario");
            return;
        }

        try {
            usuariosEncontrados = usuarioDAO.mostrarUsuarios();
            System.out.println("Usuarios encontrados en modificar: " + usuariosEncontrados);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al mostrar los usuarios");
            System.err.println("Error: " + e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/Menu");
            return;
        }

        if (usuarioActualizado) {
            req.setAttribute("actualizado", usuarioActualizado);
            req.setAttribute("usuarios", usuariosEncontrados);
            req.getRequestDispatcher("modificacion-usuario.jsp").forward(req, resp);
        } else {
            req.setAttribute("actualizado", usuarioActualizado);
            req.setAttribute("usuarios", usuariosEncontrados);
            req.getRequestDispatcher("modificacion-usuario.jsp").forward(req, resp);
        }
    }

}
