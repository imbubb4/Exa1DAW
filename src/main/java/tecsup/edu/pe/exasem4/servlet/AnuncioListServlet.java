package tecsup.edu.pe.exasem4.servlet;

import tecsup.edu.pe.exasem4.dao.AnuncioDAO;
import tecsup.edu.pe.exasem4.model.Anuncio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AnuncioListServlet", urlPatterns = {"/anuncios"})
public class AnuncioListServlet extends HttpServlet {
    private final AnuncioDAO anuncioDAO = new AnuncioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Anuncio> anuncios = anuncioDAO.obtenerTodosLosAnuncios();
        request.setAttribute("anuncios", anuncios);
        request.getRequestDispatcher("/WEB-INF/views/anuncios/lista.jsp").forward(request, response);
    }
}