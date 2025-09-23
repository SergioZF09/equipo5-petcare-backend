# 🐾 PetCare Platform - El puente seguro entre dueños y cuidadores.

<div align="center">

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-Authentication-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Container-2496ED?style=for-the-badge&logo=docker&logoColor=white)

## **🏆 Proyecto desarrollado para el hackathon ONE - NoCountry**

*Plataforma integral para conectar dueños de mascotas, cuidadores y administradores en un ecosistema seguro, moderno y colaborativo.*
</div>

---

## 🚀 Deploy & Estado
| Estado | API Docs | Licencia |
|--------|----------|----------|
| <img alt="build" src="https://img.shields.io/badge/build-passing-brightgreen"> | API Docs | MIT |

---

## 📖 **Descripción del Proyecto**

**PetCare Platform** es una aplicación web que impulsa una plataforma de reservas y gestión de servicios para mascotas. Permite a usuarios registrar mascotas, reservar servicios, gestionar perfiles y administrar reservas de manera segura y eficiente.

### 🎯 **Objetivos Principales**
- Facilitar la conexión entre dueños de mascotas y cuidadores/servicios.
- Automatizar la gestión de reservas y disponibilidad.
- Garantizar la seguridad y privacidad de los datos.
- Proveer una base robusta para futuras integraciones (móvil).

---

## ✨ **Funcionalidades Principales**

- 🔐 **Autenticación y autorización** con JWT
- 🐶 **Gestión de mascotas** (alta, edición, baja)
- 📅 **Reservas de servicios** (creación, edición, cancelación)
- 🧑‍💼 **Gestión de usuarios y roles** (admin, cliente, cuidador)
- 🛡️ **Seguridad** con Spring Security
- 📄 **Documentación automática** con SpringDoc OpenAPI

---

## 🛠️ **Tecnologías y Arquitectura**

| Categoría         | Tecnología         | Versión   | Propósito                        |
|-------------------|-------------------|-----------|-----------------------------------|
| **Framework**     | Spring Boot       | 3.5.x     | Backend principal                 |
| **Lenguaje**      | Java              | 21        | Desarrollo                        |
| **Base de Datos** | PostgreSQL        | 15        | Persistencia                      |
| **ORM**           | Spring Data JPA   | -         | Acceso a datos                    |
| **Seguridad**     | Spring Security   | -         | Autenticación y autorización      |
| **Tokens**        | JWT               | -         | Autenticación stateless           |
| **Documentación** | SpringDoc OpenAPI | -         | Documentación automática          |
| **Contenedores**  | Docker            | -         | Despliegue y orquestación         |

### **Dependencias Clave**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
```

---

## 📂 **Estructura del Proyecto**

```
├── src/main/java/com/equipo5/backend
│   ├── config/         # Configuración (CORS, OpenAPI)
│   ├── controller/     # Controladores REST
│   ├── exception/      # Manejo de excepciones
│   ├── model/          # Entidades, DTOs, enums, mappers
│   ├── repository/     # Repositorios JPA
│   ├── security/       # Seguridad y JWT
│   ├── service/        # Interfaces de servicios
│   └── serviceImpl/    # Implementaciones de servicios
├── src/main/resources/ # Configuración y properties
├── Dockerfile          # Imagen Docker
├── docker-compose.yml  # Orquestación de servicios
├── pom.xml             # Dependencias Maven
```

---

## 🚀 **Instalación y Ejecución**

### **Prerrequisitos**
- Java 21+
- Maven 3.8+
- Docker y Docker Compose

### **Ejecución Local**
1. Clona el repositorio:
   ```bash
   git clone <URL-del-repo>
   cd equipo5-petcare-backend
   ```
2. Levanta la base de datos:
   ```bash
   docker-compose up -d
   ```
3. Configura `src/main/resources/application.properties` según tu entorno.
4. Compila y ejecuta:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### **Ejecución con Docker**
1. Compila el JAR:
   ```bash
   mvn clean package
   ```
2. Construye la imagen Docker:
   ```bash
   docker build -t petcare-backend .
   ```
3. Levanta la base de datos:
   ```bash
   docker-compose up -d
   ```
4. Ejecuta el contenedor:
   ```bash
   docker run --rm -p 8080:8080 --network="host" petcare-backend
   ```

---

## 📚 **Endpoints Principales**

- `POST   /api/auth/login`         - Login de usuario
- `POST   /api/auth/register`      - Registro de usuario
- `GET    /api/pets`               - Listar mascotas
- `POST   /api/pets`               - Registrar mascota
- `PUT    /api/pets/{id}`          - Editar mascota
- `DELETE /api/pets/{id}`          - Eliminar mascota
- `GET    /api/bookings`           - Listar reservas
- `POST   /api/bookings`           - Crear reserva
- `PUT    /api/bookings/{id}`      - Editar reserva
- `DELETE /api/bookings/{id}`      - Cancelar reserva
- `GET    /api/services`           - Listar servicios disponibles

---

## 👥 **Equipo de Desarrollo**


| Desarrollador               | Rol principal      | GITHUB                   |
|-----------------------------|--------------------|--------------------------|
| Matías Nehuen Malpartida   | Backend | [@matiasnm](https://github.com/matiasnm)
| Christian Iván Cachero     | Backend | [@Christian-Cachero](https://github.com/Christian-Cachero)
| Cristhian Rodrigo Sosa Zurita | Frontend | [@CristhianSZ](https://github.com/CristhianSZ)
| Matías Zelarayán           | Frontend | [@R-Mutt22](https://github.com/R-Mutt22)
| Sergio Zuñiga Fraga        | Fullstack | [@SergioZF09](https://github.com/SergioZF09)

---

## 📄 Licencia

```
MIT License

Copyright (c) 2025 PetCare Team 5 - Hackathon ONE 2025
```

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

### **¿Qué significa esto?**

- ✅ **Uso libre**: Puedes usar este código para cualquier propósito
- ✅ **Modificación**: Puedes modificar y adaptar el código
- ✅ **Distribución**: Puedes distribuir el código original o modificado
- ✅ **Uso comercial**: Puedes usar este código en proyectos comerciales
- ⚠️ **Atribución**: Debes incluir el aviso de copyright original
- ⚠️ **Sin garantías**: El software se proporciona "tal como está"

---

<div align="center">

### 🎯 **Construido con ❤️ para la comunidad de desarrolladores**

**PETCARE** - *El puente seguro entre dueños y cuidadores.*

</div>
