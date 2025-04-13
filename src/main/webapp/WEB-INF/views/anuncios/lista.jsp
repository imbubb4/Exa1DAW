<%--
  Created by IntelliJ IDEA.
  User: TeeBe
  Date: 13/04/2025
  Time: 00:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Lista de Anuncios</title>
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
    .table thead {
      background-color: #0d6efd;
      color: white;
    }
  </style>
</head>
<body>
<div class="container mt-4">
  <!-- Header con título y botón -->
  <div class="row mb-4 align-items-center">
    <div class="col">
      <h1 class="text-primary">Lista de Anuncios</h1>
      <p class="text-muted">Administra todos los anuncios de tu sistema</p>
    </div>
    <div class="col-auto">
      <a href="${pageContext.request.contextPath}/anuncios/nuevo" class="btn btn-primary">
        Nuevo Anuncio
      </a>
    </div>
  </div>

  <!-- Card que contiene la tabla -->
  <div class="card mb-4">
    <div class="card-header py-3">
      <h5 class="mb-0">Anuncios Registrados</h5>
    </div>
    <div class="card-body">
      <c:choose>
        <c:when test="${empty anuncios}">
          <div class="text-center p-5">
            <h3>No hay anuncios disponibles</h3>
            <p class="text-muted">Empieza creando un nuevo anuncio con el botón superior.</p>
            <a href="${pageContext.request.contextPath}/anuncios/nuevo" class="btn btn-primary">
              Crear Primer Anuncio
            </a>
          </div>
        </c:when>
        <c:otherwise>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
              <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Contenido</th>
                <th class="text-center">Acciones</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="anuncio" items="${anuncios}">
                <tr>
                  <td>${anuncio.id}</td>
                  <td>${anuncio.titulo}</td>
                  <td>${anuncio.contenido}</td>
                  <td class="text-center">
                    <a href="${pageContext.request.contextPath}/anuncios/editar?id=${anuncio.id}"
                       class="btn btn-warning btn-sm">Editar</a>
                    <a href="${pageContext.request.contextPath}/anuncios/eliminar?id=${anuncio.id}"
                       class="btn btn-danger btn-sm"
                       onclick="return confirm('¿Está seguro de eliminar este anuncio?');">Eliminar</a>
                  </td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </c:otherwise>
      </c:choose>
    </div>
  </div>

  <!-- Footer -->
  <footer class="py-3 my-4 border-top">
    <p class="text-center text-muted">&copy; 2025 Sistema de Anuncios</p>
  </footer>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>