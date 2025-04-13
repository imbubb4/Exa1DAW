package tecsup.edu.pe.exasem4.servlet;

import tecsup.edu.pe.exasem4.dao.AnuncioDAO;
import tecsup.edu.pe.exasem4.model.Anuncio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/anuncios/editar")
public class AnuncioEditServlet extends HttpServlet {
    private final AnuncioDAO anuncioDAO = new AnuncioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Anuncio anuncio = anuncioDAO.obtenerAnuncioPorId(id);

        if (anuncio != null) {
            request.setAttribute("anuncio", anuncio);
            request.getRequestDispatcher("/WEB-INF/views/anuncios/formulario.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/anuncios");
        }
    }
}