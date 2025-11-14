# 🇪🇸 API España

Este proyecto ofrece una **API REST profesional** desarrollada con **Spring Boot**, junto con un **Frontend moderno en Astro**, para consultar datos administrativos de España:  
**comunidades autónomas, provincias y localidades**.

El objetivo es proporcionar una herramienta **sólida, clara y escalable**, pensada tanto para desarrolladores como para empresas que necesiten integrar datos territoriales de España en sus sistemas.

---

## 📌 Características principales

- API REST rápida y estructurada.
- Base de datos completa de España (incluida en el repositorio).
- Frontend moderno y minimalista con Astro.
- Código abierto, modular y fácil de extender.
- Documentación integrada en el propio frontend.
- Preparado para despliegue en servidores externos.

---

## 📁 Estructura del repositorio
- /BACKEND → API REST en Spring Boot
- /FRONTEND → Sitio web en Astro (documentación + navegación)
- spain.sql → Base de datos completa

## 🧰 Requisitos previos

### Backend (Spring Boot)
- Java **17+**
- Maven **3.8+**
- MySQL (**versión incluida en XAMPP**, perfectamente compatible)
- XAMPP ejecutando el servicio MySQL

### Frontend (Astro)
- Node.js **18+**
- npm (incluido con Node)

---

## 🗄️ Configuración de la base de datos (MySQL / XAMPP)

1. Arranca **MySQL** y **Apache** desde XAMPP.
2. Accede a **phpMyAdmin** o consola MySQL.
3. Crea la base de datos:

```sql
Importa el archivo:

Desde phpMyAdmin → Importar → seleccionar spain.sql

O por terminal:

mysql -u root -p spain < spain.sql

```

>**Nota**: en XAMPP el usuario suele ser root sin contraseña.

⚙️ Configuración del Backend (Spring Boot)

En:

/BACKEND/src/main/resources/

****
verás:
application.properties.example


Cópialo, adaptalo (Vienen ejemplo para MySql y para supabase) y renómbralo como:

application.properties


Configura tu conexión MySQL:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/spain
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

****
🚀 Ejecutar Backend (API)
cd BACKEND
mvn spring-boot:run


API disponible en:

http://localhost:8080

🌐 Frontend (Astro)
Frontend disponible en:

http://localhost:4321

📘 Documentación de la API

La documentación completa se muestra automáticamente en el frontend:

http://localhost:4321/documentacion


Incluye:

- Descripción de endpoints

- Ejemplos de respuestas

- Visual estilo Postman

- Explicaciones claras orientadas a desarrolladores

## 🤝 Contribuir al proyecto (Open Source)

Este proyecto busca ser un ejemplo profesional de arquitectura sencilla y bien organizada.
Cualquier mejora es bienvenida.

Pasos:

1. Haz un fork del repositorio.

2. Crea una rama:

3. feature/nueva-funcionalidad

4. Realiza tus cambios.

5. Envía un Pull Request.


📜 Licencia

Licencia MIT — libre uso, modificación y distribución.

✨ Autor

Desarrollado por <a href="https://github.com/PabloGonSan8">PabloGonSan8</a>, como proyecto open-source enfocado en calidad, claridad y utilidad real.