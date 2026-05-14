# Task Manager API

API REST desarrollada con Java 17 y Spring Boot para la gestión de tareas.

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Oracle Database
- Bean Validation
- Swagger/OpenAPI
- Maven

## Arquitectura del proyecto

El proyecto se divide en capas para separar responsabilidades:

- **Controller:** recibe las peticiones HTTP y devuelve las respuestas.
- **Service:** contiene la lógica de negocio.
- **Repository:** maneja el acceso a datos mediante Spring Data JPA.
- **ML/Enum:** contiene el modelo de datos de la aplicación.
- **Exceptions:** centraliza el manejo de errores con `@ControllerAdvice`.

## Patrones aplicados

- **Repository Pattern:** implementado mediante `JpaRepository`, desacoplando el acceso a datos.
- **Service Layer:** separa la lógica de negocio de los controladores.
- **Dependency Injection:** los servicios y repositorios se inyectan por constructor.
- **Unit of Work:** gestionado mediante JPA y `@Transactional`.
- **Global Exception Handling:** manejo centralizado de errores HTTP.

## Endpoints

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/tasks` | Crea una nueva tarea |
| GET | `/api/tasks` | Obtiene todas las tareas |
| GET | `/api/tasks/{id}` | Obtiene una tarea por ID |
| PUT | `/api/tasks/{id}` | Actualiza una tarea existente |
| DELETE | `/api/tasks/{id}` | Elimina una tarea |

## Validaciones

La API valida los datos de entrada:

- El título es obligatorio.
- El título no puede superar 100 caracteres.
- La descripción no puede superar 500 caracteres.
- El estado de la tarea debe ser válido.

## Estados permitidos

```text
PENDING
IN_PROGRESS
COMPLETED
````

## Manejo de errores

| Código | Descripción |
|---|---|
| 400 | Datos inválidos en la solicitud |
| 404 | Tarea no encontrada |
| 500 | Error interno del servidor |

## Ejecutar el proyecto

Clonar el repositorio:

```bash
git clone URL_DEL_REPOSITORIO
```

Entrar al proyecto:

```bash
cd NOMBRE_DEL_PROYECTO
```

Compilar el proyecto:

```bash
mvn clean install
```

Ejecutar la aplicación:

```bash
mvn spring-boot:run
```

## Swagger/OpenAPI

La documentación de la API se puede consultar en:

```text
http://localhost:8080/swagger-ui/index.html
```

## Ejemplo de creación de tarea

```json
{
  "title": "Primera tarea",
  "description": "Probar endpoint POST",
  "status": "PENDING"
}
```

## Ejemplo de actualización de tarea

```json
{
  "title": "Tarea actualizada",
  "description": "Descripción actualizada",
  "status": "IN_PROGRESS"
}
```

## Autor

Desarrollado por Edson Alejandro Tena Rodríguez.
