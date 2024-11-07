# ProyectoM5
Proyecto Horóscopo Chino - Documentación


**Introducción**

El proyecto Horóscopo Chino es una aplicación web que permite a los usuarios consultar su horóscopo chino según su fecha de nacimiento. El horóscopo chino es un sistema astronómico que se basa en un ciclo de 12 años, cada uno representado por un animal del zodíaco chino.

**Funcionalidades**

* Consulta de horóscopo chino según la fecha de nacimiento del usuario
* Descripción detallada del signo del zodíaco chino correspondiente a la fecha de nacimiento del usuario
* Información adicional sobre las características y rasgos de personalidad asociados a cada signo del zodíaco chino

**Arquitectura del Proyecto**

* El proyecto se desarrolló utilizando la tecnología Java y el framework Jakarta Servlet.
* La base de datos se implementó utilizando MySQL.
* La aplicación se despliega en un servidor web Apache Tomcat.

**Clases y Métodos Principales**

* `CrearUsuarioServlet`: servlet que se encarga de crear un nuevo usuario y consultar su horóscopo chino.
* `UsuarioDAO`: clase que se encarga de interactuar con la base de datos para obtener información sobre los usuarios y sus horóscopos chinos.
* `Item`: clase que representa un item del zodíaco chino, con atributos como el id, el nombre y la descripción.
* `Usuario`: clase que representa un usuario, con atributos como el id, el nombre y la fecha de nacimiento.

**Diagrama de Flujo**

A continuación, se muestra un diagrama de flujo que ilustra la secuencia de eventos que ocurren cuando un usuario consulta su horóscopo chino:

1. El usuario ingresa su fecha de nacimiento en la página web.
2. La aplicación envía una solicitud al servlet `CrearUsuarioServlet` para crear un nuevo usuario y consultar su horóscopo chino.
3. El servlet `CrearUsuarioServlet` crea un nuevo usuario y llama al método `porId` de la clase `UsuarioDAO` para obtener la información del usuario.
4. La clase `UsuarioDAO` consulta la base de datos y devuelve la información del usuario.
5. El servlet `CrearUsuarioServlet` crea un nuevo item del zodíaco chino utilizando la información del usuario y llama al método `get` de la clase `Item` para obtener la descripción del signo del zodíaco chino correspondiente.
6. La clase `Item` devuelve la descripción del signo del zodíaco chino correspondiente.
7. El servlet `CrearUsuarioServlet` muestra la descripción del signo del zodíaco chino correspondiente al usuario en la página web.

**Base de Datos**

La base de datos se diseñó con las siguientes tablas:

* `usuarios`: tabla que almacena la información de los usuarios, con columnas como `id`, `nombre` y `fecha_de_nacimiento`.
* `items`: tabla que almacena la información de los items del zodíaco chino, con columnas como `id`, `nombre` y `descripcion`.

**Despliegue**

La aplicación se despliega en un servidor web Apache Tomcat. Para desplegar la aplicación, sigue los siguientes pasos:

1. Copia la aplicación en el directorio `webapps` del servidor Tomcat.
2. Inicia el servidor Tomcat.
3. Accede a la aplicación mediante un navegador web.

**Conclusión**

El proyecto Horóscopo Chino es una aplicación web que permite a los usuarios consultar su horóscopo chino según su fecha de nacimiento. La aplicación se desarrolló utilizando la tecnología Java y el framework Jakarta Servlet, y se despliega en un servidor web Apache Tomcat. La documentación proporcionada describe la arquitectura del proyecto, las clases y métodos principales, el diagrama de flujo y la base de datos.
