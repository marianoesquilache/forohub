# ForoHub

ForoHub es una aplicación web para gestionar tópicos con operaciones CRUD, implementando seguridad JWT para autenticación.

## Características

- **Gestión de Tópicos:** CRUD completo para crear, leer, actualizar y eliminar tópicos.
- **Seguridad JWT:** Autenticación basada en JSON Web Tokens para proteger las rutas y operaciones.
- **Documentación Swagger:** Interfaz intuitiva para explorar y probar los endpoints de la API.
- **Tecnologías Utilizadas:** Spring Boot, Spring Security, JWT, Hibernate, MySQL, Swagger.

## Requisitos

- Java JDK 11 o superior
- Maven
- MySQL

## Configuración

1. **Clonar el Repositorio:**
    ```sh
    git clone https://github.com/tu-usuario/forohub.git
    cd forohub
    ```

2. **Configurar la Base de Datos:**
    - Crear una base de datos MySQL.
    - Actualizar las configuraciones de conexión en `application.properties`.

3. **Compilar y Ejecutar:**
    ```sh
    mvn spring-boot:run
    ```

4. **Explorar la API:**
    - Accede a la documentación Swagger: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

5. **Autenticación:**
    - Obtén un token JWT utilizando la ruta `/auth/login`.
    - Incluye el token en las cabeceras de las peticiones a las rutas protegidas.

## Uso

### Crear un Tópico:
```http
POST /api/topics
Content-Type: application/json
Authorization: Bearer <tu_token_jwt>

{
  "title": "Título del Tópico",
  "content": "Contenido del Tópico"
}
Obtener Todos los Tópicos:
http
Copiar código
GET /api/topics
Authorization: Bearer <tu_token_jwt>
Actualizar un Tópico:
http
Copiar código
PUT /api/topics/{id}
Content-Type: application/json
Authorization: Bearer <tu_token_jwt>

{
  "title": "Nuevo Título",
  "content": "Nuevo Contenido"
}
Eliminar un Tópico:
http
Copiar código
DELETE /api/topics/{id}
Authorization: Bearer <tu_token_jwt>
Contribución
Si quieres contribuir a ForoHub, por favor sigue estos pasos:

Haz un fork del repositorio.
Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
Haz tus cambios y confirma (git commit -am 'Agrega nueva funcionalidad').
Haz push a la rama (git push origin feature/nueva-funcionalidad).
Crea un nuevo Pull Request.
Licencia
Distribuido bajo la licencia MIT. Ver LICENSE para más información.

css
Copiar código

Este formato debería verse correctamente en GitHub. Puedes copiar y pegar este texto en tu archivo README.md.
