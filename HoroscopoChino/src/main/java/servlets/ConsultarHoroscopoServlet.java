package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
*Clase para manejar las solicitudes HTTP para consultar el horoscopo en respuesta a solicitudes HTTP.
*/
@WebServlet("/VerHoroscopo")
public class ConsultarHoroscopoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/consulta-horoscopo.jsp").forward(req, resp);
    }
    


}
