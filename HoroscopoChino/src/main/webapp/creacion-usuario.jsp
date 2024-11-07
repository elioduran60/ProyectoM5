<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <% System.out.println("Cargando formulario de creación de usuario"); %>
        <% String message=(String) request.getAttribute("usuario"); %>
            <DOCTYPE html>
                <html>
                <head>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                        crossorigin="anonymous">
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                        crossorigin="anonymous"></script>
                    <title>RegistrarUsuario</title>
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
                    <h1 class="text-center my-5">Registro de Usuario</h1>
                    <div class="container">
                        <form action="/HoroscopoChino/CreacionUsuario" method="POST">
                            <div class="mb-3">
                                <label for="nombre" class="form-label">Nombre</label>
                                <input type="text" class="form-control" id="nombre" name="nombre">
                            </div>
                            <div class="mb-3">
                                <label for="username" class="form-label">Nombre de Usuario</label>
                                <input type="text" class="form-control" id="username" name="username">
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Correo Electrónico</label>
                                <input type="email" class="form-control" id="email" name="email">
                            </div>
                            <div class="mb-3">
                                <label for="fecha_nacimiento" class="form-label">Fecha de Nacimiento</label>
                                <input type="date" class="form-control" id="fecha_nacimiento" name="fecha_nacimiento">
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Contraseña</label>
                                <input type="password" class="form-control" id="password" name="password">
                            </div>
                            <div class="mb-3">
                                <label for="password2" class="form-label">Repita Contraseña</label>
                                <input type="password" class="form-control" id="password2" name="password2">
                            </div>
                            <input type="submit" value="Registrarse" class="btn btn-info"></input>
                        </form>
                    </div>
                    <div class="text-center w-25 mx-auto my-auto" style="height: 50px;">
                        <button class="btn btn-info">
                                <a href="/HoroscopoChino" class="text-decoration-none text-dark fw-bold">Volver
                                    a inicio</a>
                        </button>
                    </div>
                    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                        crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
                        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
                        crossorigin="anonymous"></script>
                    <script>
                        var message = '<%=message%>';
                        if (message !== 'null') {
                            alert(message);
                        }
                    </script>
                </body>

                </html>