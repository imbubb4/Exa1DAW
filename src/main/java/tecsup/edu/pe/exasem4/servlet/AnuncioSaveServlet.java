package tecsup.edu.pe.exasem4.servlet;

import tecsup.edu.pe.exasem4.dao.AnuncioDAO;
import tecsup.edu.pe.exasem4.model.Anuncio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/anuncios/guardar")
public class AnuncioSaveServlet extends HttpServlet {
    private final AnuncioDAO anuncioDAO = new AnuncioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");  // Cambiado de descripcion a contenido

        // Valores por defecto o hardcodeados para departamento y usuario
        int departamentoId = 1;  // Usa un valor por defecto o apropiado para tu app
        int usuarioId = 1;       // Usa un valor por defecto o apropiado para tu app

        boolean resultado;

        if (idParam != null && !idParam.isEmpty()) {
            // Actualizar anuncio existente
            int id = Integer.parseInt(idParam);
            Anuncio anuncio = new Anuncio(id, titulo, contenido, departamentoId, usuarioId);
            resultado = anuncioDAO.actualizarAnuncio(anuncio);
        } else {
            // Crear nuevo anuncio
            Anuncio anuncio = new Anuncio(titulo, contenido, departamentoId, usuarioId);
            resultado = anuncioDAO.crearAnuncio(anuncio);
        }

        if (resultado) {
            response.sendRedirect(request.getContextPath() + "/anuncios");
        } else {
            request.setAttribute("error", "Error al guardar el anuncio");
            request.getRequestDispatcher("/WEB-INF/views/anuncios/formulario.jsp").forward(request, response);
        }
    }
}