# ProyectoM5
                Proyecto Horóscopo Chino - Documentación


**Introducción**

El Proyecto Horóscopo Chino es una aplicación web interactiva desarrollada para ofrecer a los usuarios una consulta personalizada de su horóscopo chino a partir de su fecha de nacimiento. Basado en el ciclo de 12 años de la astrología china, donde cada año se asocia con uno de los doce animales del zodíaco, este sistema permite a los usuarios conocer detalles sobre su signo zodiacal y características relacionadas. La aplicación ha sido desarrollada utilizando Java y Jakarta Servlet para generar una experiencia web dinámica.


**Objetivo**

El objetivo de este proyecto es crear una plataforma intuitiva que permita a los usuarios obtener información personalizada sobre su signo en el horóscopo chino, basado en los datos almacenados en una base de datos estructurada y actualizable. Con esto, buscamos fomentar el conocimiento de la astrología china y ofrecer una experiencia digital atractiva y precisa.


**Funcionalidades**

La aplicación incluye varias funcionalidades clave que permiten al usuario una interacción completa y sin fricciones:
•	Consulta de horóscopo: los usuarios pueden introducir su fecha de nacimiento y obtener su signo del zodíaco chino.
•	Descripción detallada del signo: cada signo zodiacal tiene una descripción que incluye características generales y rasgos de personalidad.
•	Acceso a información adicional: información sobre el origen y significado cultural de cada signo, así como sus compatibilidades con otros signos, para enriquecer la experiencia del usuario.


**Arquitectura del Proyecto**

El proyecto sigue una arquitectura basada en la tecnología Java en combinación con el framework Jakarta Servlet, lo que permite la creación de una interfaz web dinámica y modular. La base de datos se diseñó en MySQL, y la aplicación se despliega sobre el servidor web Apache Tomcat.
Componentes Principales
1.	Front-end: La interfaz de usuario está compuesta por páginas HTML dinámicas con formularios y estilos en CSS. Las peticiones al servidor se gestionan a través de formularios HTML y el uso de HTTP.
2.	Back-end: La lógica de negocio y la gestión de datos se implementan en Java utilizando Jakarta Servlets. Las clases Java controlan las consultas de usuario y la respuesta a sus peticiones de manera eficiente.
3.	Base de Datos: Se utiliza MySQL para almacenar los datos del usuario y las descripciones de cada signo zodiacal. El diseño de la base de datos permite el acceso rápido a la información mediante consultas SQL.


**Clases y Métodos Principales**
El proyecto cuenta con varias clases y métodos que facilitan su funcionamiento:
* `CrearUsuarioServlet`: Servlet que gestiona la creación de un usuario temporal para realizar la consulta del horóscopo según su fecha de nacimiento. Además, este servlet coordina las solicitudes a la capa de acceso a datos y el flujo de información entre las clases.

* `Horoscopo`: clase que representa un item del zodíaco chino, con atributos como el id, el nombre, fecha de nacimeintio, etc.
* `Usuario`:  Clase que representa un signo del zodíaco chino, almacenando atributos clave como id, nombre, descripcion, y cualquier otra característica asociada. Esta clase ofrece métodos para recuperar y manipular la información de los signos.

* `UsuarioDAO`: Clase de acceso a datos que interactúa directamente con la base de datos MySQL. Esta clase se encarga de gestionar las consultas SQL para recuperar y almacenar información de los usuarios, optimizando las consultas y asegurando la integridad de los datos.


**Diagrama de Flujo**

A continuación, se muestra un diagrama de flujo que ilustra la secuencia de eventos que ocurren cuando un usuario consulta su horóscopo chino:

1.	El usuario solo ingresa al sistema con su nombre y contraseña validada; en caso de que no exista tiene la opicion de Registarse para luego poder ingresar.
2.	La aplicación envía una solicitud al servlet `CrearUsuarioServlet` para crear un nuevo usuario y consultar su horóscopo chino.
3.	El servlet `CrearUsuarioServlet` crea un nuevo usuario y llama al método `porId` de la clase `UsuarioDAO` para obtener la información del usuario.
4.	La clase `UsuarioDAO` consulta la base de datos y devue lve la información del usuario.
5.	El servlet `CrearUsuarioServlet` crea un nuevo item del zodíaco chino utilizando la información del usuario para obtener la descripción del signo del zodíaco chino correspondiente.
6.	La clase `CreaeUsuario` devuelve la descripción del signo del zodíaco chino correspondiente.
7.	El servlet `CrearUsuarioServlet` muestra la descripción del signo del zodíaco chino correspondiente al usuario en la página web.

**Base de Datos**

La base de datos de la aplicación se implementó en **MySQL** y contiene las siguientes tablas:

* `usuarios`: tabla que almacena la información de los usuarios, con columnas como `id`, `nombre` y `fecha_de_nacimiento`.
* `horoscopo`: tabla que almacena la información de los items del zodíaco chino, con columnas como `id`, `nombre` y `descripcion`.

**Despliegue**

La aplicación está diseñada para desplegarse en un entorno Apache Tomcat. A continuación, se detallan los pasos para el despliegue:
1.	Preparación de archivos: Copiar los archivos de la aplicación en el directorio webapps del servidor Tomcat.
2.	Inicio del servidor: Iniciar el servidor Apache Tomcat para cargar la aplicación.
3.	Acceso a la aplicación: Acceder a la aplicación desde cualquier navegador utilizando la URL asignada al servidor. Esta URL puede estar configurada en localhost para pruebas locales o en un dominio si está en un entorno de producción.

**Pruebas y Validación**

Durante el desarrollo del proyecto, se realizaron pruebas en las siguientes áreas:
•	Pruebas de integración: Las interacciones entre CrearUsuarioServlet, UsuarioDAO y HosocopoDAO  se validaron para asegurar que los datos fluyen correctamente entre los distintos componentes.
•	Pruebas funcionales: Se verificaron todos los flujos de la interfaz de usuario para asegurar que la consulta y el despliegue del horóscopo funcionaran de manera intuitiva y sin errores.


**Conclusión**

El Proyecto Horóscopo Chino es una aplicación web que permite a los usuarios obtener información detallada sobre su signo zodiacal chino mediante un sistema de consultas basado en Java y Jakarta Servlets. El desarrollo de la aplicación incluyó la implementación de una base de datos MySQL y su despliegue en Apache Tomcat, lo que asegura un rendimiento óptimo y la posibilidad de futuras ampliaciones. Este informe ha documentado la estructura de la aplicación, sus componentes principales, el flujo de datos y los detalles del despliegue, ofreciendo una guía completa de la implementación y operatividad del proyecto.

PD: puede acceder directamente al git@github.com:elioduran60/ProyectoM5.git 

Autores:
Elianny Urdaneta
Elio Duran

