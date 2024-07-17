<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ForoHub</title>
</head>
<body>
    <h1>ForoHub</h1>
    <p>ForoHub es una aplicación web para gestionar tópicos con operaciones CRUD, implementando seguridad JWT para autenticación.</p>

    <h2>Características</h2>
    <ul>
        <li><strong>Gestión de Tópicos:</strong> CRUD completo para crear, leer, actualizar y eliminar tópicos.</li>
        <li><strong>Seguridad JWT:</strong> Autenticación basada en JSON Web Tokens para proteger las rutas y operaciones.</li>
        <li><strong>Documentación Swagger:</strong> Interfaz intuitiva para explorar y probar los endpoints de la API.</li>
        <li><strong>Tecnologías Utilizadas:</strong> Spring Boot, Spring Security, JWT, Hibernate, MySQL, Swagger.</li>
    </ul>

    <h2>Requisitos</h2>
    <ul>
        <li>Java JDK 11 o superior</li>
        <li>Maven</li>
        <li>MySQL</li>
    </ul>

    <h2>Configuración</h2>
    <ol>
        <li>
            <strong>Clonar el Repositorio:</strong>
            <pre><code>git clone https://github.com/tu-usuario/forohub.git
cd forohub</code></pre>
        </li>
        <li>
            <strong>Configurar la Base de Datos:</strong>
            <ul>
                <li>Crear una base de datos MySQL.</li>
                <li>Actualizar las configuraciones de conexión en <code>application.properties</code>.</li>
            </ul>
        </li>
        <li>
            <strong>Compilar y Ejecutar:</strong>
            <pre><code>mvn spring-boot:run</code></pre>
        </li>
        <li>
            <strong>Explorar la API:</strong>
            <ul>
                <li>Accede a la documentación Swagger: <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a></li>
            </ul>
        </li>
        <li>
            <strong>Autenticación:</strong>
            <ul>
                <li>Obtén un token JWT utilizando la ruta <code>/auth/login</code>.</li>
                <li>Incluye el token en las cabeceras de las peticiones a las rutas protegidas.</li>
            </ul>
        </li>
    </ol>

    <h2>Uso</h2>
    <h3>Crear un Tópico:</h3>
    <pre><code>POST /api/topics
Content-Type: application/json
Authorization: Bearer &lt;tu_token_jwt&gt;

{
  "title": "Título del Tópico",
  "content": "Contenido del Tópico"
}</code></pre>

    <h3>Obtener Todos los Tópicos:</h3>
    <pre><code>GET /api/topics
Authorization: Bearer &lt;tu_token_jwt&gt;</code></pre>

    <h3>Actualizar un Tópico:</h3>
    <pre><code>PUT /api/topics/{id}
Content-Type: application/json
Authorization: Bearer &lt;tu_token_jwt&gt;

{
  "title": "Nuevo Título",
  "content": "Nuevo Contenido"
}</code></pre>

    <h3>Eliminar un Tópico:</h3>
    <pre><code>DELETE /api/topics/{id}
Authorization: Bearer &lt;tu_token_jwt&gt;</code></pre>

    <h2>Contribución</h2>
    <p>Si quieres contribuir a ForoHub, por favor sigue estos pasos:</p>
    <ol>
        <li>Haz un fork del repositorio.</li>
        <li>Crea una nueva rama (<code>git checkout -b feature/nueva-funcionalidad</code>).</li>
        <li>Haz tus cambios y confirma (<code>git commit -am 'Agrega nueva funcionalidad'</code>).</li>
        <li>Haz push a la rama (<code>git push origin feature/nueva-funcionalidad</code>).</li>
        <li>Crea un nuevo Pull Request.</li>
    </ol>

    <h2>Licencia</h2>
    <p>Distribuido bajo la licencia MIT. Ver <code>LICENSE</code> para más información.</p>
</body>
</html>
