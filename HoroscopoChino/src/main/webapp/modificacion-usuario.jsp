<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Usuario" %>
<% List<Usuario>
  usuarios = (List<Usuario
    >) request.getAttribute("usuarios");
    System.out.println("modificando usuaruios");
    System.out.println(usuarios);
%>
<% Boolean actualizado = (Boolean) request.getAttribute("actualizado");
System.out.println("actualizado en html: " + actualizado);
%>


    <!DOCTYPE html>
    <html>
      <head>
        <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous"
        />
        <script src="https://kit.fontawesome.com/8e71d59c62.js" crossorigin="anonymous"></script>
        <title>Modificar Usuarios</title>
      </head>

      <body>
        <nav
          class="navbar navbar-expand-lg bg-body-tertiary"
          style="background-color: #17a2b8 !important"
        >
          <div class="container-fluid">
            <a class="navbar-brand text-dark fw-bold" href="/HoroscopoChino"
              >Horóscopo Chino</a
            >
            <button
              class="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a
                    class="nav-link active text-dark fw-bold"
                    aria-current="page"
                    href="#"
                    >Tú Horóscopo Chino</a
                  >
                </li>
              </ul>
            </div>
          </div>
        </nav>
        <div class="container mt-3">
          <h1 class="text-center my-5">Lista de Usuarios</h1>
          <%  if (session.getAttribute("usuario") != null) { %>
          <table class="table table-striped mt-5">
            <thead>
              <tr>
                <th scope="col">Id</th>
                <th scope="col">Nombre</th>
                <th scope="col">userName</th>
                <th scope="col">Email</th>
                <th scope="col">Fecha de Nacimiento</th>
                <th scope="col">Editar</th>

              </tr>
            </thead>
            <tbody>
              <% if (usuarios != null) { for (Usuario usuario : usuarios) { %>
              <tr>
                <td><%= usuario.getId() %></td>
                <td><%= usuario.getNombre() %></td>
                <td><%= usuario.getUsername() %></td>
                <td><%= usuario.getEmail() %></td>
                <td><%= usuario.getFechaNacimiento() %></td>
                <td>
                  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#<%= usuario.getId() %>" data-bs-whatever="@mdo" ><i class="fa-solid fa-wrench"></i> Editar</button>
                </td>
              </tr>
                <div class="modal fade" id="<%= usuario.getId() %>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Editando usuario</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                      </div>
                      <div class="modal-body">
                        <form action="/HoroscopoChino/ModificarUsuario" method="post">
                            <div class="mb-3">
                                <label for="nombre" class="form-label">Nombre</label>
                                <input type="text" required class="form-control" id="nombre" name="nombre" value="<%=usuario.getNombre()%>">
                            </div>
                            <div class="mb-3">
                                <label for="username" class="form-label">Nombre de Usuario</label>
                                <input type="text" required class="form-control" id="username" name="username" value="<%=usuario.getUsername()%>">
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Correo Electrónico</label>
                                <input type="email" required class="form-control" id="email" name="email" value="<%=usuario.getEmail()%>">
                            </div>
                            <div class="mb-3">
                                <label for="fecha_nacimiento" class="form-label">Fecha de Nacimiento</label>
                                <input type="date" required class="form-control" id="fecha_nacimiento" name="fecha_nacimiento" value="<%=usuario.getFechaNacimiento()%>">
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" required class="form-control" id="password" name="password" value="<%=usuario.getPassword()%>">
                            </div>
                            <input type="hidden" name="id" value="<%=usuario.getId()%>">
                            <div class="modal-footer">
                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                              <input type="submit" value="Guardar" class="btn btn-info"></input>
                            </div>
                        </form>
                      </div>
                    </div>
                  </div>
                </div>
              <% } } else { %>
              <tr>
                <td colspan="5" class="text-center">
                  No hay usuarios registrados
                </td>
              </tr>
              <% } %>
            </tbody>
          </table>
          <% } %>
        </div>
        <footer class="mt-5">
          <div class="text-center w-25 mx-auto my-auto" style="height: 50px">
            <button class="btn btn-info">
              <a
                href="/HoroscopoChino/Menu"
                class="text-decoration-none text-dark fw-bold"
                >Regresar</a
              >
            </button>
          </div>
        </footer>

        <script>
          var usuario = "<%=usuarios%>";
          if (usuario === "null") {
            alert("No existen usuarios disponibles para mostrar");
            window.location.href = "/HoroscopoChino/Menu";
          }
        </script>

        <script
          src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
          integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
          crossorigin="anonymous"
        ></script>
      </body>
    </html> </Usuario
></Usuario>
