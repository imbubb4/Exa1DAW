package tecsup.edu.pe.exasem4.dao;

import tecsup.edu.pe.exasem4.model.Anuncio;
import tecsup.edu.pe.exasem4.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnuncioDAO {

    // Crear un nuevo anuncio
    public boolean crearAnuncio(Anuncio anuncio) {
        String sql = "INSERT INTO anuncios (titulo, descripcion, departamento_id, usuario_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, anuncio.getTitulo());
            statement.setString(2, anuncio.getContenido());
            statement.setInt(3, anuncio.getDepartamentoId());
            statement.setInt(4, anuncio.getUsuarioId());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los anuncios
    public List<Anuncio> obtenerTodosLosAnuncios() {
        List<Anuncio> anuncios = new ArrayList<>();
        String sql = "SELECT * FROM anuncios";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Anuncio anuncio = new Anuncio(
                        resultSet.getInt("id"),
                        resultSet.getString("titulo"),
                        resultSet.getString("descripcion"),
                        resultSet.getInt("departamento_id"),
                        resultSet.getInt("usuario_id")
                );
                anuncios.add(anuncio);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return anuncios;
    }

    // Obtener un anuncio por ID
    public Anuncio obtenerAnuncioPorId(int id) {
        String sql = "SELECT * FROM anuncios WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Anuncio(
                            resultSet.getInt("id"),
                            resultSet.getString("titulo"),
                            resultSet.getString("descripcion"),
                            resultSet.getInt("departamento_id"),
                            resultSet.getInt("usuario_id")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Actualizar un anuncio
    public boolean actualizarAnuncio(Anuncio anuncio) {
        String sql = "UPDATE anuncios SET titulo = ?, descripcion = ?, departamento_id = ?, usuario_id = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, anuncio.getTitulo());
            statement.setString(2, anuncio.getContenido());
            statement.setInt(3, anuncio.getDepartamentoId());
            statement.setInt(4, anuncio.getUsuarioId());
            statement.setInt(5, anuncio.getId());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar un anuncio
    public boolean eliminarAnuncio(int id) {
        String sql = "DELETE FROM anuncios WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}