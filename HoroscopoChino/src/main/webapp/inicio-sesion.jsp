<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ page import="modelo.Usuario" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
    <title>Menu</title>
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

        <h1 class="text-center">
            ¿Qué deseas hacer, <%= usuario.getNombre() %>?
        </h1>

        <div class="row text-center mt-4">
            <div class="col">
                <button class="btn btn-info text-dart"><a href="/HoroscopoChino/VerHoroscopo" class="text-decoration-none text-dart fw-bold !iomprtant; ">Conoce tu Animal</a></button>
            </div>
            <div class="col">
                <button class="btn btn-info text-dart"><a  href="/HoroscopoChino/ListarUsuario" class="text-decoration-none text-dart fw-bold">Lista de Usuarios</a></button>
            </div>
            <div class="col">
                <button class="btn btn-info text-dart"><a href="/HoroscopoChino/ModificarUsuario" class="text-decoration-none text-dart fw-bold">Modificar Usuario</a></button>
            </div>
            <div class="col">
                <button class="btn btn-info text-dart"><a href="/HoroscopoChino/EliminarUsuario" class="text-decoration-none text-dart fw-bold">Eliminar Usuario</a></button>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
                        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
                        crossorigin="anonymous"></script>
    </div>
    <footer class="mt-5">
        <div class="text-center w-25 mx-auto my-auto" style="height: 50px;">
            <button class="btn btn-info">
                    <a href="/HoroscopoChino" class="text-decoration-none text-dark fw-bold">Volver
                        a inicio</a>
            </button>
        </div>
    </footer>
</body>

</html>
