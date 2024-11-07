<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
    <%@ page import="modelo.Usuario" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
                <!DOCTYPE html>
                <html>
                <head>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                        crossorigin="anonymous">
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                        crossorigin="anonymous"></script>
                    <title>Conoce tu animal</title>
                </head>

                <body>
                <nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: #17A2B8 !important;">
        <div class="container-fluid">
            <a class="navbar-brand text-dark fw-bold" href="/HoroscopoChino">Horóscopo Chino</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active text-dark fw-bold" aria-current="page" href="#">Tú Horóscopo Chino</a>
                </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container mt-3">
    <h1 class="text-center">Conoce a tu Animal del Horoscopo Chino</h1>
                    <h3 class="text-center">Tu animal es: <%= usuario.getAnimal() %>
                    </h3>
                    <div class="text-center">
                        <% if ("Rata".equals(usuario.getAnimal())) { %>
                            <img src="<c:url value='/imagenes/rata.jpg' />" alt='"Rata"'>
                            <% } else if ("Buey".equals(usuario.getAnimal())) { %>
                                <img src="<c:url value='/imagenes/buey.jpg' />" alt='"Buey"' + class="img-fluid" />
                                <% } else if ("Tigre".equals(usuario.getAnimal())) { %>
                                    <img src="<c:url value='/imagenes/tigre.jpg' />" alt="Tigre">
                                    <% } else if ("Conejo".equals(usuario.getAnimal())) { %>
                                        <img src="<c:url value='/imagenes/conejo.jpg' />" alt='"Conejo"'>
                                        <% } else if ("Dragón".equals(usuario.getAnimal())) { %>
                                            <img src="<c:url value='/imagenes/dragon.jpg' />" alt="Dragón">
                                            <% } else if ("Serpiente".equals(usuario.getAnimal())) { %>
                                                <img src="<c:url value='/imagenes/serpiente.jpg' />" alt="Serpiente">
                                                <% } else if ("Caballo".equals(usuario.getAnimal())) { %>
                                                    <img src="<c:url value='/imagenes/caballo.jpg' />" alt="Caballo">
                                                    <% } else if ("Cabra".equals(usuario.getAnimal())) { %>
                                                        <img src="<c:url value='/imagenes/cabra.jpg' />" alt="Cabra">
                                                        <% } else if ("Mono".equals(usuario.getAnimal())) { %>
                                                            <img src="<c:url value='/imagenes/mono.jpg' />" alt="Mono">
                                                            <% } else if ("Gallo".equals(usuario.getAnimal())) { %>
                                                                <img src="<c:url value='/imagenes/gallo.jpg' />"
                                                                    alt="Gallo">
                                                                <% } else if ("Perro".equals(usuario.getAnimal())) {
                                                                    %>
                                                                    <img src="<c:url value='/imagenes/perro.jpg' />"
                                                                        alt="Perro">
                                                                    <% } else if ("Cerdo".equals(usuario.getAnimal()))
                                                                        { %>
                                                                        <img src="<c:url value='/imagenes/cerdo.jpg' />"
                                                                            alt="Cerdo">
                                                                        <% } else { %>
                                                                            <p>Imagen no disponible</p>
                                                                            <% } %>
                    </div>
    </div>
                    

<footer class="mt-5">
        <div class="text-center w-25 mx-auto my-auto" style="height: 50px;">
            <button class="btn btn-info">
                    <a href="/HoroscopoChino/Menu" class="text-decoration-none text-dark fw-bold">Regresar</a>
            </button>
        </div>
    </footer>
                    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                        crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
                        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
                        crossorigin="anonymous"></script>
                </body>

                </html>