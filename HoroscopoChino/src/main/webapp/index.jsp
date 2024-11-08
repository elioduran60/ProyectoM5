<%-- Created by IntelliJ IDEA. User: elio1 Date: 05/11/2024 Time: 22:07 To change this template use File | Settings |
    File Templates. --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <% String password = (String) request.getAttribute("password"); %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous">
        <title>Index</title>
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
            <div class="container mt-5">
                <h1>Inicia Sesión</h1>
                <p>Es necesario que inicies sesión para revisar tu horóscopo chino. Si todavía no tienes cuenta, haz
                    clip <a href="/HoroscopoChino/CreacionUsuario">aquí.</a></p>
                <form action="/HoroscopoChino/IniciarSesion" method="POST">
                    <table borde="1">
                        <tr>
                            <td>Nombre de Usuario: </td>
                            <td><input type="text" required name="username"></td>
                        </tr>
                        <tr>
                            <td>Contraseña: </td>
                            <td><input type="password" required name="password"></td>
                        </tr>
                    </table>
                    <tr>
                        <td><button type="submit" class="btn btn-info">Ingresar</button></td>
                    </tr>
            </div>
            <script>
                var password = "<%=password%>";
                if (password === 'Contraseña incorrecta') {
                    alert('Contraseña incorrecta');
                }

                if (password === 'Usuario no existe, debe registrarse') {
                    alert('Usuario no existe, debe registrarse');
                }
            </script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
                    integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
                    crossorigin="anonymous"></script>
        </body>
    </html>