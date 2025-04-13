<%--
  Created by IntelliJ IDEA.
  User: TeeBe
  Date: 13/04/2025
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Formulario de Anuncio</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .card {
      border: none;
      box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
    }
    .card-header {
      background-color: #0d6efd;
      color: white;
      font-weight: bold;
    }
    .required::after {
      content: " *";
      color: red;
    }
  </style>
</head>
<body>
<div class="container mt-4">
  <div class="row justify-content-center">
    <div class="col-lg-8">
      <!-- Header con título -->
      <div class="text-center mb-4">
        <h1 class="text-primary">
          <c:choose>
            <c:when test="${anuncio.id != null}">
              Editar Anuncio
            </c:when>
            <c:otherwise>
              Nuevo Anuncio
            </c:otherwise>
          </c:choose>
        </h1>
        <p class="text-muted">
          <c:choose>
            <c:when test="${anuncio.id != null}">
              Actualiza la información del anuncio seleccionado
            </c:when>
            <c:otherwise>
              Complete el formulario para crear un nuevo anuncio
            </c:otherwise>
          </c:choose>
        </p>
      </div>

      <!-- Mensaje de error, si existe -->
      <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
      </c:if>

      <!-- Formulario en una card -->
      <div class="card mb-4">
        <div class="card-header py-3">
          <h5 class="mb-0">Información del Anuncio</h5>
        </div>
        <div class="card-body p-4">
          <form action="${pageContext.request.contextPath}/anuncios/guardar" method="post">
            <c:if test="${anuncio.id != null}">
              <input type="hidden" name="id" value="${anuncio.id}">
            </c:if>

            <div class="mb-4">
              <label for="titulo" class="form-label required">Título</label>
              <input type="text" class="form-control" id="titulo" name="titulo"
                     value="${anuncio.titulo}" required
                     placeholder="Ingrese un título descriptivo">
              <div class="form-text">El título debe ser claro y representativo del contenido.</div>
            </div>

            <div class="mb-4">
              <label for="contenido" class="form-label required">Contenido</label>
              <textarea class="form-control" id="contenido" name="contenido"
                        rows="6" required
                        placeholder="Describa detalladamente el anuncio">${anuncio.contenido}</textarea>
              <div class="form-text">Describa de manera completa y clara la información del anuncio.</div>
            </div>

            <!-- Campos ocultos para departamentoId y usuarioId -->
            <input type="hidden" name="departamentoId" value="1">
            <input type="hidden" name="usuarioId" value="1">

            <div class="text-end mt-4">
              <a href="${pageContext.request.contextPath}/anuncios" class="btn btn-secondary">
                Cancelar
              </a>
              <button type="submit" class="btn btn-primary">
                Guardar
              </button>
            </div>
          </form>
        </div>
      </div>

      <!-- Footer -->
      <footer class="py-3 my-4 border-top">
        <p class="text-center text-muted">&copy; 2025 Sistema de Anuncios</p>
      </footer>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
