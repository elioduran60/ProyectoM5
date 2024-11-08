package servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import dao.ObtenerHoroscopoDAO;
import dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Horoscopo;
import modelo.Usuario;
/*
*Clase para manejar las solicitudes HTTP para faciltar la creacion de Usuarios.
*/
@WebServlet("/CreacionUsuario")  // La URL de registro de Usuario relacionada con la solicitud (jsp)
public class CrearUsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/creacion-usuario.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de fecha incorrecto; debe usar el siguiente formato: yyyy-mm-dd ");
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
        Usuario u = new Usuario(nombre, email, username, fecha_correcta, password, animal);
        System.out.println("Usuario creado: " + u);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Boolean usuarioCreado;
        try {
            usuarioCreado = usuarioDAO.agregarUsuario(u);
        } catch (ClassNotFoundException ex) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No se pudo crear el usuario");
            return;
        }
        if (usuarioCreado) {
            req.setAttribute("usuario", "Usuario creado correctamente.!");
            req.getRequestDispatcher("creacion-usuario.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No se pudo crear el usuario");
        }
    }
}