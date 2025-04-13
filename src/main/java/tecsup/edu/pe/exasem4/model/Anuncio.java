package tecsup.edu.pe.exasem4.model;

public class Anuncio {
    private int id;
    private String titulo;
    private String contenido;
    private int departamentoId;
    private int usuarioId;

    // Constructor vacío
    public Anuncio() {
    }

    // Constructor con todos los campos
    public Anuncio(int id, String titulo, String contenido, int departamentoId, int usuarioId) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.departamentoId = departamentoId;
        this.usuarioId = usuarioId;
    }

    // Constructor sin ID (útil para crear nuevos anuncios)
    public Anuncio(String titulo, String contenido, int departamentoId, int usuarioId) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.departamentoId = departamentoId;
        this.usuarioId = usuarioId;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", departamentoId=" + departamentoId +
                ", usuarioId=" + usuarioId +
                '}';
    }
}