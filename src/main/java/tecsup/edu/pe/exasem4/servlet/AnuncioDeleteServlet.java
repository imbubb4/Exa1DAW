package tecsup.edu.pe.exasem4.servlet;

import tecsup.edu.pe.exasem4.dao.AnuncioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/anuncios/eliminar")
public class AnuncioDeleteServlet extends HttpServlet {
    private final AnuncioDAO anuncioDAO = new AnuncioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        anuncioDAO.eliminarAnuncio(id);
        response.sendRedirect(request.getContextPath() + "/anuncios");
    }
}